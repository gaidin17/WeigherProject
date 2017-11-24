package app.utils.initialization;

import app.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Evgeny_Akulenko on 11/13/2017.
 */
@Component
public class InitialisationServise {
	//@Autowired
	DataBaseInitializer dataBaseInitializer;

	@Autowired
	OrganizationInitializer organizationInitializer;
	public void init() {
		if (dataBaseInitializer != null) {
			dataBaseInitializer.initialize();

		}
		if (organizationInitializer != null) {
			organizationInitializer.initialize();
		}
	}
}
