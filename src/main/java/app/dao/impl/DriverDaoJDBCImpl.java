package app.dao.impl;

import app.dao.AbstractJDBCDao;
import app.dao.DriverDao;
import app.dao.utils.EntityBuilder;
import app.domain.Driver;
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
public class DriverDaoJDBCImpl extends AbstractJDBCDao<Driver, Long> implements DriverDao {

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, Driver driver) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO drivers (name) VALUES(?)");
			preparedStatement.setString(1, driver.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, Driver driver) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE drivers name = ? WHERE id = ?");
			preparedStatement.setString(1, driver.getName());
			preparedStatement.setLong(2, driver.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getRemoveStatement(Connection connection, Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM drivers WHERE id = ?");
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
			preparedStatement = connection.prepareStatement("SELECT * FROM drivers");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getEntityByIdStatement(Connection connection, Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM drivers WHERE id = ?");
			preparedStatement.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Autowired
	@Qualifier("DriverEntityBuilder")
	@Override
	protected void setEntityBuilder(EntityBuilder<Driver> entityBuilder) {
		this.entityBuilder = entityBuilder;
	}
}
