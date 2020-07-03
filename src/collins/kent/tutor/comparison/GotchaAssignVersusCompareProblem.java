package collins.kent.tutor.comparison;

import java.util.Random;

import collins.kent.tutor.Operator;
import collins.kent.tutor.Problem;

public class GotchaAssignVersusCompareProblem implements Problem {

	IntegerComparisonProblem original;

	@Override
	public Problem generate(Random rng) {
		original = new IntegerComparisonProblem();
		original.generate(rng);
		while (original.op != Operator.EQUAL) {
			original.generate(rng);
		}
		return this;
	}

	@Override
	public String getStatement() {
		// replace the == with a single =
		return original.getStatement().replace("==", "=");
	}

	@Override
	public String getAnswer() {
		return "e";
	}

	@Override
	public String getFeedback(String s) {
		return "Incorrect.  An assignment operator has been used instead of the equality operator.  This produces an error when attempting to compile the code.";
	}

}
