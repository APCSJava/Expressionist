package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;

public class RecognizeStringValueProblem implements Problem {
	
	private static String[] strings = { "cat", "dog", "fox", "ant",
			"Bob" };
	private String displayString;

	@Override
	public Problem generate(Random rng) {
		displayString = "\"" + strings[rng.nextInt(strings.length)]
				+ "\"";
		return this;
	}


	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		return "String";
	}
}
