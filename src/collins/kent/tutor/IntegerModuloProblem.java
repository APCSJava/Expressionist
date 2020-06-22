package collins.kent.tutor;

import java.util.Random;

/***
 * Produces a modulo problem involving integers. Avoids % 0. Operands are
 * intentionally low to keep the focus on the operation rather than the
 * mathematics.
 * 
 * @author k. collins
 *
 */
public class IntegerModuloProblem implements Problem {

	int operandLeft;
	int operandRight;

	@Override
	public Problem generate(Random rng) {
		operandLeft = rng.nextInt(10);
		operandRight = rng.nextInt(5);
		if (operandRight == 0) {
			operandRight = 3;
			operandLeft +=3;
		}
		return this;
	}

	@Override
	public String getStatement() {
		return operandLeft + " % " + operandRight;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(operandLeft % operandRight);
	}

}
