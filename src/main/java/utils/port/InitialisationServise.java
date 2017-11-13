package utils.port;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/13/2017.
 */
public class InitialisationServise {
	private static List<Initializer> initializers = new ArrayList<>();

	static {
		initializers.add(new DataBaseInitializer());
	}

	public static void init() {
		for (Initializer initializer : initializers) {
			initializer.initialize();
		}
	}
}
