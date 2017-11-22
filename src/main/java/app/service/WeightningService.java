package app.service;

import app.dao.WeightningDao;
import app.domain.Weighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Gaidin on 12.11.2017.
 */
@Component
public class WeightningService {
	@Autowired
	@Qualifier("WeightningDaoStub")
	WeightningDao weightningDao;

	public Weighting getWeightningById(Long id) {
		return weightningDao.getEntityById(id);
	}

	public List<Weighting> getAll() {
		return weightningDao.getAll();
	}

	public boolean removeWeightning(Long id) {
		return weightningDao.remove(id);
	}

	public boolean updateWeightning(Weighting weighting) {
		return weightningDao.update(weighting);
	}

	public boolean addWeightning(Weighting weighting) {
		return weightningDao.create(weighting);
	}
}
