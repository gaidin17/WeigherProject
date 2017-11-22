package app.dao.impl.jdbc;

import app.dao.AbstractJDBCDao;
import app.dao.TruckDao;
import app.dao.utils.EntityBuilder;
import app.domain.Truck;
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
public class TruckDaoJDBCImpl extends AbstractJDBCDao<Truck, Long> implements TruckDao {

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, Truck truck) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO trucks (number) VALUES(?)");
			preparedStatement.setString(1, truck.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, Truck truck) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE trucks number = ? WHERE id = ?");
			preparedStatement.setString(1, truck.getNumber());
			preparedStatement.setLong(2, truck.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getRemoveStatement(Connection connection, Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM trucks WHERE id = ?");
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
			preparedStatement = connection.prepareStatement("SELECT * FROM trucks");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getEntityByIdStatement(Connection connection, Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM trucks WHERE id = ?");
			preparedStatement.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Autowired
	@Qualifier("TruckEntityBuilder")
	@Override
	protected void setEntityBuilder(EntityBuilder<Truck> entityBuilder) {
		this.entityBuilder = entityBuilder;
	}
}
