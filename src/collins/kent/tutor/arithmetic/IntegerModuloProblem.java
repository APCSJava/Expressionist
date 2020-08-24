package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Produces a modulo problem involving integers. Avoids % 0. Operands are
 * intentionally low to keep the focus on the operation rather than the
 * mathematics.
 * 
 * @author k. collins
 *
 */
@Meta(skill="Perform the remainder operation on non-zero values")
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
