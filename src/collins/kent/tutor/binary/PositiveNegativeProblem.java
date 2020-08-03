package collins.kent.tutor.binary;

import java.util.Random;

import collins.kent.tutor.Problem;

public class PositiveNegativeProblem implements Problem {

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
		return "Is the following value positive [pos] or negative [neg]? (two's complement)\n"
				+ value;
	}

	@Override
	public String getAnswer() {
		return value.substring(0, 1).equals("0")
				? "pos"
				: "neg";
	}

}
