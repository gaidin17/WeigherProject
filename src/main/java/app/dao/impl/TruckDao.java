package app.dao.impl;

import app.dao.AbstractDao;
import app.domain.Truck;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Gaidin on 12.11.2017.
 */
@Component
public class TruckDao extends AbstractDao<Truck, Long> {

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, Truck truck) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO trucks (number) VALUES(?)");
			preparedStatement.setString(1, truck.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, Truck truck) {
		return null;
	}

	@Override
	protected PreparedStatement getRemoveStatement(Connection connection, Long aLong) {
		return null;
	}

	@Override
	protected PreparedStatement getGetAllStatement(Connection connection) {
		return null;
	}

	@Override
	protected PreparedStatement getEntityByIdStatement(Connection connection, Long aLong) {
		return null;
	}
}
