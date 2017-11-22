package app.dao.impl.jdbc;

import app.dao.AbstractJDBCDao;
import app.dao.WeightningDao;
import app.dao.utils.EntityBuilder;
import app.domain.Weighting;
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
public class WeightningDaoJDBCImpl extends AbstractJDBCDao<Weighting, Long> implements WeightningDao {
    @Override
    protected PreparedStatement getCreateStatement(Connection connection, Weighting weighting) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO weighting " +
                    "(organization_id, driver_id, truck_id, cargo_id, firstweighting, " +
                    "firstweightingDate, secondweighting, secondweightingDate ) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, weighting.getOrganization().getId());
            preparedStatement.setLong(2, weighting.getDriver().getId());
            preparedStatement.setLong(2, weighting.getTruck().getId());
            preparedStatement.setLong(3, weighting.getCargo().getId());
            preparedStatement.setDouble(4, weighting.getFirstweighting());
            preparedStatement.setString(5, weighting.getFirstweightingDate().toString());
            preparedStatement.setDouble(6, weighting.getSecondweighting());
            preparedStatement.setString(7, weighting.getSecondweightingDate().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection, Weighting weighting) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE weighting " +
                    "organization_id = ?, driver_id = ?, truck_id = ?, cargo_id = ?, " +
                    "firstweighting = ?, firstweightingDate = ?, secondweighting = ?, secondweightingDate = ? " +
                    "WHERE id = ?");
            preparedStatement.setLong(1, weighting.getOrganization().getId());
            preparedStatement.setLong(2, weighting.getDriver().getId());
            preparedStatement.setLong(2, weighting.getTruck().getId());
            preparedStatement.setLong(3, weighting.getCargo().getId());
            preparedStatement.setDouble(4, weighting.getFirstweighting());
            preparedStatement.setString(5, weighting.getFirstweightingDate().toString());
            preparedStatement.setDouble(6, weighting.getSecondweighting());
            preparedStatement.setString(7, weighting.getSecondweightingDate().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM weighting WHERE id = ?");
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
            preparedStatement = connection.prepareStatement("SELECT * FROM weighting");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getEntityByIdStatement(Connection connection, Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM weighting WHERE id = ?");
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Autowired
    @Qualifier("weightingEntityBuilder")
    @Override
    protected void setEntityBuilder(EntityBuilder<Weighting> entityBuilder) {
        this.entityBuilder = entityBuilder;
    }
}
