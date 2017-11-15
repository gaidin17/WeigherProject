package app.utils.initialization;

/**
 * Created by Evgeny_Akulenko on 11/13/2017.
 */
public class Initializer {
	private boolean initialized = false;

	public void initialize() {
		if (!initialized) {
			initialized = true;
		}
	}
}
