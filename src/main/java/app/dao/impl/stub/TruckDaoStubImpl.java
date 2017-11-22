package app.dao.impl.stub;

import app.dao.TruckDao;
import app.dao.utils.StubDaoIdGenerator;
import app.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 12.11.2017.
 */

@Component
public class TruckDaoStubImpl implements TruckDao {
	@Autowired
	StubDaoIdGenerator idGenerator;
	List<Truck> trucks;

	@PostConstruct
	private void init() {
		trucks = new ArrayList<>();
	}

	@Override
	public boolean create(Truck truck) {
		truck.setId(idGenerator.getNextId());
		return trucks.add(truck);
	}

	@Override
	public boolean update(Truck truck) {
		for (Truck t : trucks) {
			if (t.getId() == truck.getId()) {
				t.setNumber(truck.getNumber());
				return true;
			}
		}
		return false;
	}

	@Override
	public Truck getEntityById(Long id) {
		for (Truck t : trucks) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	@Override
	public List<Truck> getAll() {
		return trucks;
	}

	@Override
	public boolean remove(Long id) {
		for (Truck t : trucks) {
			if (t.getId() == id) {
				return trucks.remove(t);
			}
		}
		return false;
	}
}
