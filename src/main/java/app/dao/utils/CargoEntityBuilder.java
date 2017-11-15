package app.dao.utils;

import app.domain.Cargo;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 15.11.2017.
 */
@Component("CargoEntityBuilder")
public class CargoEntityBuilder implements EntityBuilder<Cargo> {
    private static final String ID = "id";
    private static final String TYPE = "name";

    @Override
    public Cargo buildSingleEntity(ResultSet resultSet) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setId(resultSet.getLong(ID));
        cargo.setType(resultSet.getString(TYPE));
        return cargo;
    }

    @Override
    public List<Cargo> buildEntities(ResultSet resultSet) throws SQLException {
        List<Cargo> cargoList = new ArrayList<>();
        while (resultSet.next()) {
            Cargo cargo = buildSingleEntity(resultSet);
            cargoList.add(cargo);
        }
        return cargoList;
    }
}
