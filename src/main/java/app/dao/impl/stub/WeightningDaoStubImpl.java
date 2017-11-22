package app.dao.impl.stub;

import app.dao.WeightningDao;
import app.dao.utils.StubDaoIdGenerator;
import app.domain.Weighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaidin on 12.11.2017.
 */

@Component("WeightningDaoStub")
public class WeightningDaoStubImpl implements WeightningDao {
	@Autowired
	StubDaoIdGenerator idGenerator;
	List<Weighting> weightings;

	@PostConstruct
	private void init() {
		weightings = new ArrayList<>();
	}

	@Override
	public boolean create(Weighting weighting) {
		weighting.setId(idGenerator.getNextId());
		return weightings.add(weighting);
	}

	@Override
	public boolean update(Weighting weighting) {
		for (Weighting w : weightings) {
			if (w.getId() == weighting.getId()) {
				w.setCargo(weighting.getCargo());
				w.setDriver(weighting.getDriver());
				w.setTruck(weighting.getTruck());
				w.setOrganization(weighting.getOrganization());
				w.setFirstweighting(weighting.getFirstweighting());
				w.setSecondweighting(weighting.getSecondweighting());
				w.setFirstweightingDate(weighting.getFirstweightingDate());
				w.setSecondweightingDate(weighting.getSecondweightingDate());
				return true;
			}
		}
		return false;
	}

	@Override
	public Weighting getEntityById(Long id) {
		for (Weighting w : weightings) {
			if (w.getId() == id) {
				return w;
			}
		}
		return null;
	}

	@Override
	public List<Weighting> getAll() {
		return weightings;
	}

	@Override
	public boolean remove(Long id) {
		for (Weighting w : weightings) {
			if (w.getId() == id) {
				return weightings.remove(w);
			}
		}
		return false;
	}
}
