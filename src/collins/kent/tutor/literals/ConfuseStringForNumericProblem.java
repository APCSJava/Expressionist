package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;

public class ConfuseStringForNumericProblem implements Problem {

	private String displayString;

	@Override
	public Problem generate(Random rng) {
		String numeric = null;
		double rand = rng.nextDouble();
		if (rand<0.25) {
			numeric = new RecognizeDoubleProblem().generate(rng).getNumericExpression();
		} else if (rand < 0.5) {
			numeric = new RecognizeFloatProblem().generate(rng).getNumericExpression();
		} else if (rand <0.75) {
			numeric = new RecognizeLongProblem().generate(rng).getNumericExpression();
		} else numeric = new RecognizeIntProblem().generate(rng).getNumericExpression();
		displayString = "\""+numeric+"\"";
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
