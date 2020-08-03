package collins.kent.tutor.binary;

import java.util.Random;

import collins.kent.tutor.Problem;

public class OddEvenProblem implements Problem {

	String value;

	@Override
	public Problem generate(Random rng) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(rng.nextBoolean() ? "0" : "1");
		}
		value = sb.toString();
		return this;
	}

	@Override
	public String getStatement() {
		return "Is the following value odd or even? (two's complement)\n"
				+ value;
	}

	@Override
	public String getAnswer() {
		return value.substring(value.length() - 1).equals("0")
				? "even"
				: "odd";
	}

}
