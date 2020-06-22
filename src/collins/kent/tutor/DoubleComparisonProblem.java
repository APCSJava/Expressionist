package collins.kent.tutor;

import java.util.Random;

/***
 * Produces a problem involving comparisons of double values. Avoids checking
 * for equality/inequality (<=, >=, ==, !=) as equality operations are
 * problematic for floating point. (0.1 + 0.2 == 0.3)
 * 
 * @author k. collins
 *
 */

public class DoubleComparisonProblem implements Problem {

	double leftOperand;
	double rightOperand;
	Operator op;

	public Problem generate(Random rng) {
		leftOperand = rng.nextInt(5);
		rightOperand = rng.nextInt(5);
		Operator selected = chooseOperator(rng);
		while (selected == Operator.EQUAL || selected == Operator.NOT_EQUAL || selected == Operator.GTE
				|| selected == Operator.LTE) {
			selected = chooseOperator(rng);
		}
		op = selected;
		return this;
	}

	private Operator chooseOperator(Random rng) {
		int opIndex = rng.nextInt(Operator.COMPARISON.size());
		return Operator.COMPARISON.get(opIndex);
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
