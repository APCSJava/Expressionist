package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

@Skill(skill="Recognize that operators are not values")
public class RecognizeOperatorProblem implements Problem {

	private static String operators = "+-*/%!";
	private String displayString;

	@Override
	public RecognizeOperatorProblem generate(Random rng) {
		displayString = ""
				+ operators.charAt(rng.nextInt(operators.length()));
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
				+ " is not a value of any type, it is an operator.  The best response is "
				+ getAnswer();
	}

}
