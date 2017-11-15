package app.utils.port.decoding;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/14/2017.
 */
@Component
public class DecodingAlgorithm implements Algorithm<Double, String> {
	private static final int MAX_VALUE = 1000000;
	List<Double> decodingResults;

	@PostConstruct
	private void init() {
		decodingResults = new ArrayList<>();
	}

	@Override
	public Double calculate(String s) {

		List<Integer> qualityResults = new ArrayList<>();
		int size = decodingResults.size();
		Double currentValue = 100.00;
		if (!decodingResults.isEmpty()) {
			Double diff = currentValue - decodingResults.get(size - 1);
			if (Math.abs(diff) < currentValue * 0.01) {
				qualityResults.add(1);
			} else {
				qualityResults.add(0);
			}
		}
		decodingResults.add(currentValue);
		if (decodingResults.size() == MAX_VALUE && !qualityResults.contains(0)) {
			return currentValue;
		}

		return null;
	}
}
