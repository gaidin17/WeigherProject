package app.dao.utils;

import app.domain.Organization;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 15.11.2017.
 */
@Component("OrganisationEntityBuilder")
public class OrganisationEntityBuilder implements EntityBuilder<Organization> {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String INN = "inn";
    private static final String ADDRESS = "address";

    @Override
    public Organization buildSingleEntity(ResultSet resultSet) throws SQLException {
        Organization organization = new Organization();
        organization.setId(resultSet.getLong(ID));
        organization.setName(resultSet.getString(NAME));
        organization.setInn(resultSet.getString(INN));
        organization.setAddress(resultSet.getString(ADDRESS));
        return organization;
    }

    @Override
    public List<Organization> buildEntities(ResultSet resultSet) throws SQLException {
        List<Organization> organizations = new ArrayList<>();
        while (resultSet.next()) {
            Organization organization = buildSingleEntity(resultSet);
            organizations.add(organization);
        }
        return organizations;
    }
}
