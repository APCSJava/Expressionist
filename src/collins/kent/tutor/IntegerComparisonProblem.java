package collins.kent.tutor;

import static collins.kent.tutor.Operator.*;

public class IntegerComparisonProblem extends Problem {

	int leftOperand;
	int rightOperand;
	Operator op;

	public IntegerComparisonProblem() {
		this(Operator.random(COMPARISON));
	}

	public IntegerComparisonProblem(Operator op) {
		leftOperand = random.nextInt(5);
		// provide slight bias towards same so GTE, LTE and == are relevant
		rightOperand = random.nextDouble() < 0.2 ? leftOperand : random.nextInt(5);
		this.statement = leftOperand + " " + Operator.symbol(op) + " " + rightOperand;
		this.answer = result(op);
		this.correction = "Incorrect.  The comparison is " + answer;
	}

	private String result(Operator op) {
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
		return Boolean.toString(result);
	}
}
