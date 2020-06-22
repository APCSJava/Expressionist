package collins.kent.tutor;

import java.util.Random;

/***
 * Produces a problem involving addition of doubles. Operands are restricted to
 * those that produce "nice" results to keep the emphasis on the production of a
 * double result rather than the performance of mental arithmetic.
 * 
 * @author k. collins
 *
 */
public class DoubleAdditionProblem implements Problem {

	double leftOperand;
	double rightOperand;

	public Problem generate(Random rng) {
		leftOperand = rng.nextInt(10);
		rightOperand = rng.nextInt(10);
		return this;
	}

	@Override
	public String getStatement() {
		return leftOperand + " + " + rightOperand;
	}

	@Override
	public String getAnswer() {
		return Double.toString(leftOperand + rightOperand);
	}
	
	@Override
	public boolean isCorrect(String response) {
		if (response.indexOf(".") == -1) return false; // not formatted as double
		try {
			double answer = Double.parseDouble(response);
			return answer == leftOperand + rightOperand;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
