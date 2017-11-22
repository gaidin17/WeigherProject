package app.dao.impl;

import app.dao.AbstractJDBCDao;
import app.dao.OrganizationDao;
import app.dao.utils.EntityBuilder;
import app.domain.Organization;
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
public class OrganizationDaoJDBCImpl extends AbstractJDBCDao<Organization, Long> implements OrganizationDao {

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, Organization organization) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO organizations (name, inn, address) VALUES(?, ?, ?)");
			preparedStatement.setString(1, organization.getName());
			preparedStatement.setString(2, organization.getInn());
			preparedStatement.setString(3, organization.getAddress());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, Organization organization) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE organizations name = ?, inn = ?, address = ? WHERE id = ?");
			preparedStatement.setString(1, organization.getName());
			preparedStatement.setString(2, organization.getInn());
			preparedStatement.setString(3, organization.getAddress());
			preparedStatement.setLong(2, organization.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getRemoveStatement(Connection connection, Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM organizations WHERE id = ?");
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
			preparedStatement = connection.prepareStatement("SELECT * FROM organizations");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	protected PreparedStatement getEntityByIdStatement(Connection connection, Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM organizations WHERE id = ?");
			preparedStatement.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Autowired
	@Qualifier("OrganisationEntityBuilder")
	@Override
	protected void setEntityBuilder(EntityBuilder<Organization> entityBuilder) {
		this.entityBuilder = entityBuilder;
	}
}
