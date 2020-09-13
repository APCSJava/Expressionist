package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Recognize literals of type float")
public class RecognizeFloatLiteralProblem implements Problem, NumericExpression {

	private String displayString;

	@Override
	public RecognizeFloatLiteralProblem generate(Random rng) {
		displayString = (rng.nextBoolean() ? "" : "-")
				+ rng.nextInt(100) + "." + rng.nextInt(100)
				+ (rng.nextBoolean() ? "F" : "f");
		return this;
	}

	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		return "float";
	}

	@Override
	public String getNumericExpression() {
		return displayString;
	}
}
