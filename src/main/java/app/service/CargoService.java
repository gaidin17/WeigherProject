package app.service;

import app.dao.CargoDao;
import app.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/22/2017.
 */
@Component
public class CargoService {
	@Autowired
	private CargoDao cargoDao;

	public Cargo getCargoById(Long id) {
		return cargoDao.getEntityById(id);
	}

	public List<Cargo> getAll() {
		return cargoDao.getAll();
	}

	public boolean removeCargo(Long id) {
		return cargoDao.remove(id);
	}

	public boolean updateCargo(Cargo cargo) {
		return cargoDao.update(cargo);
	}

	public boolean addCargo(Cargo cargo) {
		return cargoDao.create(cargo);
	}
}
