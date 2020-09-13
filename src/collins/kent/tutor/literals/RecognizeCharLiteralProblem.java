package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Recognize literals of type char")
public class RecognizeCharLiteralProblem implements Problem {

	private static String chars = "aAcC       0123456789-/+%!?*";
	private String displayString;

	@Override
	public Problem generate(Random rng) {
		displayString = "'"
				+ chars.charAt(rng.nextInt(chars.length())) + "'";
		return this;
	}

	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		return "char";
	}

}
