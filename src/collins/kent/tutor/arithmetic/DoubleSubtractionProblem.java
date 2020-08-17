package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

/***
 * Produces a problem involving subtraction of doubles. Operands are restricted to
 * those that produce "nice" results to keep the emphasis on the production of a
 * double result rather than the performance of mental arithmetic.
 * 
 * @author k. collins
 *
 */
@Skill(skill="Subtract a double value from a double value")
public class DoubleSubtractionProblem implements Problem {

	double leftOperand;
	double rightOperand;

	public Problem generate(Random rng) {
		leftOperand = rng.nextInt(10);
		rightOperand = rng.nextInt(10);
		return this;
	}

	@Override
	public String getStatement() {
		return leftOperand + " - " + rightOperand;
	}

	@Override
	public String getAnswer() {
		return Double.toString(leftOperand - rightOperand);
	}
	
	@Override
	public boolean isCorrect(String response) {
		if (response.indexOf(".") == -1) return false; // not formatted as double
		try {
			double answer = Double.parseDouble(response);
			return answer == leftOperand - rightOperand;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
