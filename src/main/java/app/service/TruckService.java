package app.service;

import app.dao.TruckDao;
import app.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/22/2017.
 */
@Component
public class TruckService {
	@Autowired
	private TruckDao truckDao;

	public Truck getTruckById(Long id) {
		return truckDao.getEntityById(id);
	}

	public List<Truck> getAll() {
		return truckDao.getAll();
	}

	public boolean removeTruck(Long id) {
		return truckDao.remove(id);
	}

	public boolean updateTruck(Truck truck) {
		return truckDao.update(truck);
	}

	public boolean addTruck(Truck truck) {
		return truckDao.create(truck);
	}
}
