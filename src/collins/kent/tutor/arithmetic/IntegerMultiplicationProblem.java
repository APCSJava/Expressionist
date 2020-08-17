package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

/***
 * Factory method for producing integer multiplication problems. Operand values
 * are intentionally limited to emphasize the operation rather than the
 * mathematics.
 * 
 * @author k. collins
 *
 */
@Skill(skill="Multiply one integer value by a second integer")
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
