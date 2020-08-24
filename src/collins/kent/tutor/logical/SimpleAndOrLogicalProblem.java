package collins.kent.tutor.logical;

import java.util.Random;

import collins.kent.tutor.Operator;
import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Evaluate logical expressions involving AND and OR")
public class SimpleAndOrLogicalProblem implements Problem {

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
