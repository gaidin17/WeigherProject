package app.dao.utils;

import app.domain.Truck;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 15.11.2017.
 */
@Component("TruckEntityBuilder")
public class TruckEntityBuilder implements EntityBuilder<Truck> {
    private static final String ID = "id";
    private static final String NUMBER = "number";

    @Override
    public Truck buildSingleEntity(ResultSet resultSet) throws SQLException{
        Truck truck = new Truck();
        truck.setId(resultSet.getLong(ID));
        truck.setNumber(resultSet.getString(NUMBER));
        return truck;
    }

    @Override
    public List<Truck> buildEntities(ResultSet resultSet) throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        while (resultSet.next()) {
            Truck truck = buildSingleEntity(resultSet);
            trucks.add(truck);
        }
        return trucks;
    }
}
