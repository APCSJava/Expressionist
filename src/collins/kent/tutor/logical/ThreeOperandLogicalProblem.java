package collins.kent.tutor.logical;

import java.util.Random;

import collins.kent.tutor.Operator;
import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Evaluate logical expressions involving three operators")
public class ThreeOperandLogicalProblem implements Problem {

	boolean left;
	boolean center;
	boolean right;
	Operator op1;
	Operator op2;

	@Override
	public Problem generate(Random rng) {
		left = rng.nextBoolean();
		center = rng.nextBoolean();
		right = rng.nextBoolean();
		op1 = rng.nextBoolean() ? Operator.AND : Operator.OR;
		op2 = rng.nextBoolean() ? Operator.AND : Operator.OR;
		return this;
	}

	@Override
	public String getStatement() {
		return left + " " + Operator.symbol(op1) + " " + center + " "
				+ Operator.symbol(op2) + " " + right;
	}

	@Override
	public String getAnswer() {
		// if left OR and right AND, right side first; else, left to right
		boolean result;
		if (op1 == Operator.OR && op2 == Operator.AND) {
			result = left || center && right;
		} else if (op1 == Operator.OR && op2 == Operator.OR) {
			result = left || center || right;
		} else if (op1 == Operator.AND && op2 == Operator.OR) {
			result = left && center || right;
		} else {
			result = left && center && right;
		}
		return Boolean.toString(result);
	}

}
