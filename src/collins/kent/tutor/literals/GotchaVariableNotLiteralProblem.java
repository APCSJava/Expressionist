package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Meta;
import collins.kent.tutor.Problem;

@Meta(skill="Recognize that variables are not literals")
public class GotchaVariableNotLiteralProblem implements Problem {

	private static String[] strings = { "d", "dog", "fox", "ant",
	"num1", "x" };
	private String displayString;

	@Override
	public GotchaVariableNotLiteralProblem generate(Random rng) {
		int idx = rng.nextInt(strings.length);
		displayString = strings[idx].replaceAll("\"", "");
		return this;
	}

	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		return IFTutor.getErrorSymbol();
	}

	@Override
	public String getFeedback(String response) {
		return "Incorrect.  " + displayString
				+ " is not a literal value.  The best response is "
				+ getAnswer();
	}

}
