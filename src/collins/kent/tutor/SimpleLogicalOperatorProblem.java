package collins.kent.tutor;

import java.util.Random;

public class SimpleLogicalOperatorProblem implements Problem {

	boolean left;
	boolean right;
	Operator op;

	@Override
	public Problem generate(Random rng) {
		left = rng.nextBoolean();
		right = rng.nextBoolean();
		op = rng.nextDouble() < 0.5 ? Operator.AND : Operator.OR;
		return this;
	}

	@Override
	public String getStatement() {
		return left + " " + Operator.symbol(op) + " " + right;
	}

	@Override
	public String getAnswer() {
		return Boolean.toString(op == Operator.AND ? (left && right) : (left || right));
	}

}
