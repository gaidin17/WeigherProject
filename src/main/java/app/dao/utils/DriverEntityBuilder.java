package app.dao.utils;

import app.domain.Driver;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 15.11.2017.
 */
@Component("DriverEntityBuilder")
public class DriverEntityBuilder implements EntityBuilder<Driver> {
    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public Driver buildSingleEntity(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getLong(ID));
        driver.setName(resultSet.getString(NAME));
        return driver;
    }

    @Override
    public List<Driver> buildEntities(ResultSet resultSet) throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        while (resultSet.next()) {
            Driver driver = buildSingleEntity(resultSet);
            drivers.add(driver);
        }
        return drivers;
    }
}
