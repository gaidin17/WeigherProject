package app.dao.impl.stub;

import app.dao.CargoDao;
import app.dao.utils.StubDaoIdGenerator;
import app.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 12.11.2017.
 */

@Component("CargoDaoStub")
public class CargoDaoStubImpl implements CargoDao {
	@Autowired
	StubDaoIdGenerator idGenerator;
	List<Cargo> cargos;

	@PostConstruct
	private void init() {
		cargos = new ArrayList<>();
	}

	@Override
	public boolean create(Cargo cargo) {
		cargo.setId(idGenerator.getNextId());
		return cargos.add(cargo);
	}

	@Override
	public boolean update(Cargo cargo) {
		for (Cargo c : cargos) {
			if (c.getId() == cargo.getId()) {
				c.setType(cargo.getType());
				return true;
			}
		}
		return false;
	}

	@Override
	public Cargo getEntityById(Long id) {
		for (Cargo c : cargos) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Cargo> getAll() {
		return cargos;
	}

	@Override
	public boolean remove(Long id) {
		for (Cargo o : cargos) {
			if (o.getId() == id) {
				return cargos.remove(o);
			}
		}
		return false;
	}

}
