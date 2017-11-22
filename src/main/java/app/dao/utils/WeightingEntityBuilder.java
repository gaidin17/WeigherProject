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
@Component("weightingEntityBuilder")
public class WeightingEntityBuilder implements EntityBuilder<Weighting> {
    private static final String ID = "id";
    private static final String ORGANIZATION_ID = "organization_id";
    private static final String DRIVER_ID = "driver_id";
    private static final String TRUCK_ID = "truck_id";
    private static final String CARGO_ID = "cargo_id";
    private static final String FIRST_weighting = "firstweighting";
    private static final String FIRST_weighting_DATE = "firstweightingDate";
    private static final String SECOND_weighting = "secondweighting";
    private static final String SECOND_weighting_DATE = "secondweightingDate";

    @Autowired
    private DaoInterface<? extends Organization, Long> organizationDao;

    @Autowired
    private DaoInterface<? extends Driver, Long> driverDao;

    @Autowired
    private DaoInterface<? extends Truck, Long> truckDao;

    @Autowired
    private DaoInterface<? extends Cargo, Long> cargoDao;

    @Override
    public Weighting buildSingleEntity(ResultSet resultSet) throws SQLException {
        Weighting weighting = new Weighting();
        weighting.setId(resultSet.getLong(ID));
        weighting.setOrganization(organizationDao.getEntityById(resultSet.getLong(ORGANIZATION_ID)));
        weighting.setDriver(driverDao.getEntityById(resultSet.getLong(DRIVER_ID)));
        weighting.setTruck(truckDao.getEntityById(resultSet.getLong(TRUCK_ID)));
        weighting.setCargo(cargoDao.getEntityById(resultSet.getLong(CARGO_ID)));
        weighting.setFirstweighting(resultSet.getDouble(FIRST_weighting));
        weighting.setFirstweightingDate(resultSet.getDate(FIRST_weighting_DATE));
        weighting.setSecondweighting(resultSet.getDouble(SECOND_weighting));
        weighting.setSecondweightingDate(resultSet.getDate(SECOND_weighting_DATE));

        return weighting;
    }

    @Override
    public List<Weighting> buildEntities(ResultSet resultSet) throws SQLException {
        List<Weighting> weightings = new ArrayList<>();
        while (resultSet.next()) {
            Weighting weighting = buildSingleEntity(resultSet);
            weightings.add(weighting);
        }
        return weightings;
    }
}
