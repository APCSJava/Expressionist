package collins.kent.tutor.binary;

import java.util.HashMap;
import java.util.Random;

import collins.kent.tutor.Problem;

public class NibbleToHexProblem implements Problem {

	private static final String[] values = { "0000", "0001", "0010",
			"0011", "0100", "0101", "0110", "0111", "1000", "1001",
			"1010", "1011", "1100", "1101", "1110", "1111"};
	
	private static final String[] answers = { "0", "1", "2",
			"3", "4", "5", "6", "7", "8", "9",
			"a", "b", "c", "d", "e", "f"};
	
	private int key;

	@Override
	public Problem generate(Random rng) {
		key = rng.nextInt(values.length);
		return this;
	}

	@Override
	public String getStatement() {
		return "What is the hexadecimal equivalent for this four-bit value?\n"
				+ values[key];
	}

	@Override
	public String getAnswer() {
		return answers[key];
	}

}
