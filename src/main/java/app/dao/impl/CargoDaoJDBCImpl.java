package app.dao.impl;

import app.dao.AbstractJDBCDao;
import app.dao.utils.EntityBuilder;
import app.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Gaidin on 12.11.2017.
 */

@Component
public class CargoDaoJDBCImpl extends AbstractJDBCDao<Cargo, Long> {

    @Override
    protected PreparedStatement getCreateStatement(Connection connection, Cargo cargo) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO cargo (type) VALUES(?)");
            preparedStatement.setString(1, cargo.getType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection, Cargo cargo) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE cargo type = ? WHERE id = ?");
            preparedStatement.setString(1, cargo.getType());
            preparedStatement.setLong(2, cargo.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM cargo WHERE id = ?");
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getGetAllStatement(Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cargo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getEntityByIdStatement(Connection connection, Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cargo WHERE id = ?");
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Autowired
    @Qualifier("CargoEntityBuilder")
    @Override
    protected void setEntityBuilder(EntityBuilder<Cargo> entityBuilder) {
        this.entityBuilder = entityBuilder;
    }


}
