package app.dao.impl;

import app.dao.AbstractJDBCDao;
import app.dao.utils.EntityBuilder;
import app.domain.Weighing;
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
public class WeightningDaoJDBCImpl extends AbstractJDBCDao<Weighing, Long> {
    @Override
    protected PreparedStatement getCreateStatement(Connection connection, Weighing weighing) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO weighing " +
                    "(organization_id, driver_id, truck_id, cargo_id, firstWeighing, " +
                    "firstWeighingDate, secondWeighing, secondWeighingDate ) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, weighing.getOrganization().getId());
            preparedStatement.setLong(2, weighing.getDriver().getId());
            preparedStatement.setLong(2, weighing.getTruck().getId());
            preparedStatement.setLong(3, weighing.getCargo().getId());
            preparedStatement.setDouble(4, weighing.getFirstWeighing());
            preparedStatement.setString(5, weighing.getFirstWeighingDate().toString());
            preparedStatement.setDouble(6, weighing.getSecondWeighing());
            preparedStatement.setString(7, weighing.getSecondWeighingDate().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection, Weighing weighing) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE weighing " +
                    "organization_id = ?, driver_id = ?, truck_id = ?, cargo_id = ?, " +
                    "firstWeighing = ?, firstWeighingDate = ?, secondWeighing = ?, secondWeighingDate = ? " +
                    "WHERE id = ?");
            preparedStatement.setLong(1, weighing.getOrganization().getId());
            preparedStatement.setLong(2, weighing.getDriver().getId());
            preparedStatement.setLong(2, weighing.getTruck().getId());
            preparedStatement.setLong(3, weighing.getCargo().getId());
            preparedStatement.setDouble(4, weighing.getFirstWeighing());
            preparedStatement.setString(5, weighing.getFirstWeighingDate().toString());
            preparedStatement.setDouble(6, weighing.getSecondWeighing());
            preparedStatement.setString(7, weighing.getSecondWeighingDate().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM weighing WHERE id = ?");
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
            preparedStatement = connection.prepareStatement("SELECT * FROM weighing");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getEntityByIdStatement(Connection connection, Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM weighing WHERE id = ?");
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Autowired
    @Qualifier("WeighingEntityBuilder")
    @Override
    protected void setEntityBuilder(EntityBuilder<Weighing> entityBuilder) {
        this.entityBuilder = entityBuilder;
    }
}
