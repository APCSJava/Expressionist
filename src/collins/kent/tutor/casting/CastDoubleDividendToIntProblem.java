package collins.kent.tutor.casting;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.arithmetic.IntegerDivisionProblem;

/***
 * Provides practice evaluating arithmetic problems where the left operand is
 * cast to an integer, as in (int) 4.0/8.
 * 
 * @author k. collins
 *
 */

public class CastDoubleDividendToIntProblem implements Problem {

	Problem original;
	String revisedStatement;

	@Override
	public Problem generate(Random rng) {
		/* integer division needs to be performed, so start with an integer problem */
		original = new IntegerDivisionProblem();
		original.generate(rng);
		// modify dividend to incorporate the cast
		String[] parts = original.getStatement().split(" ");
		String first = "(int) " + parts[0] +".0 ";
		// assemble revised statement that displays both operands as integers
		revisedStatement = first + parts[1]+" "+parts[2];
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
			// if answer came as double, remind
			if (response.indexOf(".") != -1) {
				return "Incorrect.  Due to precedence, integer division is performed, producing the value " + original.getAnswer();
			}
			// they gave an integer, just the wrong one
			return "Incorrect.  The correct answer is " + original.getAnswer();
		}
	}
}
