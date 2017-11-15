package app.utils.port.decoding.decoder;

import app.utils.port.decoding.algorithm.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gaidin on 12.11.2017.
 */
@Component
public class ComPortDecoder implements Decoder<Double, String> {
	@Autowired
	public Algorithm<Double, String> algorithm;

	@Override
	public Double decode(String string) {
		return algorithm.calculate(string);
	}
}
