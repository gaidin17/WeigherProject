package app.dao.utils;

import app.dao.DaoInterface;
import app.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 15.11.2017.
 */
@Component("WeighingEntityBuilder")
public class WeighingEntityBuilder implements EntityBuilder<Weighing> {
    private static final String ID = "id";
    private static final String ORGANIZATION_ID = "organization_id";
    private static final String DRIVER_ID = "driver_id";
    private static final String TRUCK_ID = "truck_id";
    private static final String CARGO_ID = "cargo_id";
    private static final String FIRST_WEIGHING = "firstWeighing";
    private static final String FIRST_WEIGHING_DATE = "firstWeighingDate";
    private static final String SECOND_WEIGHING = "secondWeighing";
    private static final String SECOND_WEIGHING_DATE = "secondWeighingDate";

    @Autowired
    private DaoInterface<? extends Organization, Long> organizationDao;

    @Autowired
    private DaoInterface<? extends Driver, Long> driverDao;

    @Autowired
    private DaoInterface<? extends Truck, Long> truckDao;

    @Autowired
    private DaoInterface<? extends Cargo, Long> cargoDao;

    @Override
    public Weighing buildSingleEntity(ResultSet resultSet) throws SQLException {
        Weighing weighing = new Weighing();
        weighing.setId(resultSet.getLong(ID));
        weighing.setOrganization(organizationDao.getEntityById(resultSet.getLong(ORGANIZATION_ID)));
        weighing.setDriver(driverDao.getEntityById(resultSet.getLong(DRIVER_ID)));
        weighing.setTruck(truckDao.getEntityById(resultSet.getLong(TRUCK_ID)));
        weighing.setCargo(cargoDao.getEntityById(resultSet.getLong(CARGO_ID)));
        weighing.setFirstWeighing(resultSet.getDouble(FIRST_WEIGHING));
        weighing.setFirstWeighingDate(resultSet.getDate(FIRST_WEIGHING_DATE));
        weighing.setSecondWeighing(resultSet.getDouble(SECOND_WEIGHING));
        weighing.setSecondWeighingDate(resultSet.getDate(SECOND_WEIGHING_DATE));

        return weighing;
    }

    @Override
    public List<Weighing> buildEntities(ResultSet resultSet) throws SQLException {
        List<Weighing> weighings = new ArrayList<>();
        while (resultSet.next()) {
            Weighing weighing = buildSingleEntity(resultSet);
            weighings.add(weighing);
        }
        return weighings;
    }
}
