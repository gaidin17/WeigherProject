package app.dao.impl.stub;

import app.dao.OrganizationDao;
import app.dao.utils.StubDaoIdGenerator;
import app.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 12.11.2017.
 */

@Component
public class OrganizationDaoStubImpl implements OrganizationDao {
	@Autowired
	StubDaoIdGenerator idGenerator;
	List<Organization> organizations;

	@PostConstruct
	private void init() {
		organizations = new ArrayList<>();
	}

	@Override
	public boolean create(Organization organization) {
		organization.setId(idGenerator.getNextId());
		return organizations.add(organization);
	}

	@Override
	public boolean update(Organization organization) {
		for (Organization o : organizations) {
			if (o.getId() == organization.getId()) {
				o.setAddress(organization.getAddress());
				o.setInn(organization.getInn());
				o.setName(organization.getName());
				return true;
			}
		}
		return false;
	}

	@Override
	public Organization getEntityById(Long id) {
		for (Organization o : organizations) {
			if (o.getId() == id) {
				return o;
			}
		}
		return null;
	}

	@Override
	public List<Organization> getAll() {
		return organizations;
	}

	@Override
	public boolean remove(Long id) {
		for (Organization o : organizations) {
			if (o.getId() == id) {
				return organizations.remove(o);
			}
		}
		return false;
	}
}
