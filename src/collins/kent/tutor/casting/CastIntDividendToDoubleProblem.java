package collins.kent.tutor.casting;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;
import collins.kent.tutor.arithmetic.DoubleDivisionProblem;

/***
 * Provides practice evaluating arithmetic problems where the left operand is
 * cast to a double, as in (double) 4/8.
 * 
 * @author k. collins
 *
 */
@Meta(skill="Cast an int to a double to force double arithmetic")
public class CastIntDividendToDoubleProblem implements Problem {

	Problem original;
	String revisedStatement;

	@Override
	public Problem generate(Random rng) {
		/* double division needs to be performed, so start with a double problem */
		original = new DoubleDivisionProblem();
		original.generate(rng);
		// remove the .0 following each of the operands in the statement
		String[] parts = original.getStatement().split("\\.");
		String first = "(double) " + parts[0];
		String middle = parts[1].substring(1);
		// assemble revised statement that displays both operands as integers
		revisedStatement = first + middle;
		return this;
	}

	@Override
	public String getStatement() {
		return revisedStatement;
	}

	@Override
	public String getAnswer() {
		return original.getAnswer();
	}

	@Override
	public boolean isCorrect(String response) {
		return original.isCorrect(response);
	}

	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return original.getFeedback(response);
		} else {
			// if answer came as integer, remind
			if (response.indexOf(".") == -1) {
				return "Incorrect.  Due to precedence, double division is performed, producing the value " + original.getAnswer();
			}
			// they gave a double, just the wrong one
			return "Incorrect.  Due to precedence, double division is performed, leading to " + original.getAnswer();
		}
	}

}
