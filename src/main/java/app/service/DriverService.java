package app.service;

import app.dao.DriverDao;
import app.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/22/2017.
 */
@Component
public class DriverService {
	@Autowired
	private DriverDao driverDao;

	public Driver getDriverById(Long id) {
		return driverDao.getEntityById(id);
	}

	public List<Driver> getAll() {
		return driverDao.getAll();
	}

	public boolean removeDriver(Long id) {
		return driverDao.remove(id);
	}

	public boolean updateDriver(Driver driver) {
		return driverDao.update(driver);
	}

	public boolean addDriver(Driver driver) {
		return driverDao.create(driver);
	}
}
