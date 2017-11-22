package app.dao.impl.stub;

import app.dao.DriverDao;
import app.dao.utils.StubDaoIdGenerator;
import app.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 12.11.2017.
 */

@Component("DriverDaoStub")
public class DriverDaoStubImpl implements DriverDao {
	@Autowired
	StubDaoIdGenerator idGenerator;
	List<Driver> drivers;

	@PostConstruct
	private void init() {
		drivers = new ArrayList<>();
	}

	@Override
	public boolean create(Driver cargo) {
		cargo.setId(idGenerator.getNextId());
		return drivers.add(cargo);
	}

	@Override
	public boolean update(Driver driver) {
		for (Driver d : drivers) {
			if (d.getId() == driver.getId()) {
				d.setName(driver.getName());
				return true;
			}
		}
		return false;
	}

	@Override
	public Driver getEntityById(Long id) {
		for (Driver d : drivers) {
			if (d.getId() == id) {
				return d;
			}
		}
		return null;
	}

	@Override
	public List<Driver> getAll() {
		return drivers;
	}

	@Override
	public boolean remove(Long id) {
		for (Driver d : drivers) {
			if (d.getId() == id) {
				return drivers.remove(d);
			}
		}
		return false;
	}
}
