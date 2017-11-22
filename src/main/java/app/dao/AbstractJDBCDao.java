package app.dao;

import app.dao.utils.EntityBuilder;
import app.datasource.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/15/2017.
 */

public abstract class AbstractJDBCDao<T, V> implements DaoInterface<T, V> {
	@Autowired
	private DataSourceManager dataSourceManager;
	protected EntityBuilder<T> entityBuilder;

	private DataSource getDataSource() {
		return dataSourceManager.getDatasource();
	}

	@Override
	@Transactional
	public boolean create(T t) {
		try (Connection connection = getDataSource().getConnection();
				PreparedStatement statement = getCreateStatement(connection, t)) {
			return statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(T t) {
		try (Connection connection = getDataSource().getConnection();
				PreparedStatement statement = getUpdateStatement(connection, t)) {
			return statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	@Transactional
	public T getEntityById(V v) {
		try (Connection connection = getDataSource().getConnection();
				PreparedStatement statement = getEntityByIdStatement(connection, v)) {
			ResultSet resultSet = statement.executeQuery();
			return entityBuilder.buildSingleEntity(resultSet);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public List<T> getAll() {
		try (Connection connection = getDataSource().getConnection();
				PreparedStatement statement = getGetAllStatement(connection)) {
			ResultSet resultSet = statement.executeQuery();
			return entityBuilder.buildEntities(resultSet);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public boolean remove(V v) {
		try (Connection connection = getDataSource().getConnection();
				PreparedStatement statement = getRemoveStatement(connection, v)) {
			return statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	protected abstract PreparedStatement getCreateStatement(Connection connection, T t);

	protected abstract PreparedStatement getUpdateStatement(Connection connection, T t);

	protected abstract PreparedStatement getRemoveStatement(Connection connection, V v);

	protected abstract PreparedStatement getGetAllStatement(Connection connection);

	protected abstract PreparedStatement getEntityByIdStatement(Connection connection, V v);

	protected EntityBuilder<T> getEntityBuilder() {
		return entityBuilder;
	}

	protected abstract void setEntityBuilder(EntityBuilder<T> entityBuilder);
}
