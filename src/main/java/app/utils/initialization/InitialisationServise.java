package app.utils.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Evgeny_Akulenko on 11/13/2017.
 */
@Component
public class InitialisationServise {
	@Autowired
	DataBaseInitializer dataBaseInitializer;

	public void init() {
		dataBaseInitializer.initialize();
	}
}
