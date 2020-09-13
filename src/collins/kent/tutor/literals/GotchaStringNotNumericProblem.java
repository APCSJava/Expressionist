package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Avoid confusing strings with numeric types")
public class GotchaStringNotNumericProblem implements Problem {

	private String displayString;

	@Override
	public Problem generate(Random rng) {
		String numeric = null;
		double rand = rng.nextDouble();
		if (rand<0.25) {
			numeric = new RecognizeDoubleLiteralProblem().generate(rng).getNumericExpression();
		} else if (rand < 0.5) {
			numeric = new RecognizeFloatLiteralProblem().generate(rng).getNumericExpression();
		} else if (rand <0.75) {
			numeric = new RecognizeLongLiteralProblem().generate(rng).getNumericExpression();
		} else numeric = new RecognizeIntLiteralProblem().generate(rng).getNumericExpression();
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
