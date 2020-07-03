package collins.kent.tutor.logical;

import java.util.Random;

import collins.kent.tutor.Operator;
import collins.kent.tutor.Problem;

public class SimpleNottedOperandLogicalProblem implements Problem {

	boolean leftInverted;
	boolean left;
	boolean right;
	Operator op;

	@Override
	public Problem generate(Random rng) {
		left = rng.nextBoolean();
		right = rng.nextBoolean();
		op = rng.nextBoolean() ? Operator.AND : Operator.OR;
		leftInverted = rng.nextBoolean(); // if not, right is inverted
		return this;
	}

	@Override
	public String getStatement() {
		if (leftInverted) {
			return "!" + left + " " + Operator.symbol(op) + " "
					+ right;
		} else {
			return left + " " + Operator.symbol(op) + " !"
					+ right;
		}
	}

	@Override
	public String getAnswer() {
		if (op == Operator.AND) {
			return Boolean.toString(leftInverted? !left && right : left && !right);
		}
		return Boolean.toString(leftInverted? !left || right : left || !right);
	}

}
