package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Produces a problem involving multiplication of doubles. Operands are restricted to
 * those that produce "nice" results to keep the emphasis on the production of a
 * double result rather than the performance of mental arithmetic.
 * 
 * @author k. collins
 *
 */
@Meta(skill="Multiply one double value by a second double")
public class DoubleMultiplicationProblem implements Problem {
	
	double leftOperand;
	double rightOperand;

	public Problem generate(Random rng) {
		leftOperand = rng.nextInt(5);
		rightOperand = rng.nextInt(5);
		return this;
	}

	@Override
	public String getStatement() {
		return leftOperand + " * " + rightOperand;
	}

	@Override
	public String getAnswer() {
		return Double.toString(leftOperand * rightOperand);
	}
	
	@Override
	public boolean isCorrect(String response) {
		if (response.indexOf(".") == -1) return false; // not formatted as double
		try {
			double answer = Double.parseDouble(response);
			return answer == leftOperand * rightOperand;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
