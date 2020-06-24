package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;

/***
 * Factory method for producing integer multiplication problems. Operand values
 * are intentionally limited to emphasize the operation rather than the
 * mathematics.
 * 
 * @author k. collins
 *
 */
public class IntegerMultiplicationProblem implements Problem {

	int operandLeft;
	int operandRight;

	@Override
	public Problem generate(Random rng) {
		operandLeft = rng.nextInt(5);
		operandRight = rng.nextInt(5);
		return this;
	}

	@Override
	public String getStatement() {
		return operandLeft + " * " + operandRight;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(operandLeft * operandRight);
	}
}
