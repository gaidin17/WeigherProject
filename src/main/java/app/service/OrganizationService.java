package app.service;

import app.dao.OrganizationDao;
import app.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/22/2017.
 */
@Component
public class OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;

	public Organization getOrganizationById(Long id) {
		return organizationDao.getEntityById(id);
	}

	public List<Organization> getAll() {
		return organizationDao.getAll();
	}

	public boolean removeOrganization(Long id) {
		return organizationDao.remove(id);
	}

	public boolean updateOrganization(Organization organization) {
		return organizationDao.update(organization);
	}

	public boolean addOrganization(Organization organization) {
		return organizationDao.create(organization);
	}
}
