package app.utils.port.decoding;

import org.springframework.stereotype.Component;

/**
 * Created by Gaidin on 12.11.2017.
 */
@Component
public class ComPortDecoder implements Decoder<Double, String>{

	@Override
	public Double decode(String string) {
		if (string == null) {
			return 0.0;
		} else {
			return 1d;
		}
	}
}
