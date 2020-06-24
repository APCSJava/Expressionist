package collins.kent.tutor.comparison;

import java.util.Random;

import collins.kent.tutor.Operator;
import collins.kent.tutor.Problem;

/***
 * Produces a problem involving comparisons of integer values.
 * 
 * @author k. collins
 *
 */

public class IntegerComparisonProblem implements Problem {

	int leftOperand;
	int rightOperand;
	Operator op;

	public Problem generate(Random rng) {
		leftOperand = rng.nextInt(5);
		// provide slight bias towards same so GTE, LTE and == are relevant
		rightOperand = rng.nextDouble() < 0.2 ? leftOperand : rng.nextInt(5);
		int opIndex = rng.nextInt(Operator.COMPARISON.size());
		op = Operator.COMPARISON.get(opIndex);
		return this;
	}

	private boolean result(Operator op) {
		boolean result = false;
		switch (op) {
		case LTE:
			result = leftOperand <= rightOperand;
			break;
		case LT:
			result = leftOperand < rightOperand;
			break;
		case GT:
			result = leftOperand > rightOperand;
			break;
		case GTE:
			result = leftOperand >= rightOperand;
			break;
		case EQUAL:
			result = leftOperand == rightOperand;
			break;
		case NOT_EQUAL:
			result = leftOperand != rightOperand;
			break;
		}
		return result;
	}

	@Override
	public String getStatement() {
		return leftOperand + " " + Operator.symbol(op) + " " + rightOperand;
	}

	@Override
	public String getAnswer() {
		return Boolean.toString(result(op));
	}
}
