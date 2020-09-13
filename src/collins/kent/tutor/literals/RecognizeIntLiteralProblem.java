package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Recognize literals of type int")
public class RecognizeIntLiteralProblem implements Problem, NumericExpression {

	private String displayString;

	@Override
	public RecognizeIntLiteralProblem generate(Random rng) {
		displayString = (rng.nextBoolean() ? "" : "-")
				+ rng.nextInt(100);
		return this;
	}

	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		return "int";
	}
	
	@Override
	public String getNumericExpression() {
		return displayString;
	}

}
