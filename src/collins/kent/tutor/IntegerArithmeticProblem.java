package collins.kent.tutor;

import static collins.kent.tutor.Operator.*;

/***
 * Easy math problems involve the five arithmetic operators and two numeric
 * operands of the same type. The emphasis is on data types and functioning of
 * the operator, not on whether the student can do math. These expressions are
 * those a student is most likely to encounter and which need to be instantly
 * recognizable in order to minimize cognitive loading while reading code.
 * 
 * @author k. collins
 *
 */

public class IntegerArithmeticProblem extends Problem {

	int operandLeft = random.nextInt(10);
	int operandRight = random.nextInt(10);
	Operator operator = Operator.random(ARITHMETIC);

	public IntegerArithmeticProblem() {
		generate();
	}

	public IntegerArithmeticProblem(Operator op) {
		operator = op;
		generate();
	}

	private void generate() {
		this.answer = evaluate();
		this.statement = operandLeft + " " + symbol(operator) + " " + operandRight;
		this.correction = correction == null ? "Incorrect.  The answer is " + answer : correction;
	}

	/**
	 * Builds the result string
	 * 
	 * @param operands
	 * @param operator
	 * @return
	 */
	private String evaluate() {
		int result = Integer.MIN_VALUE;
		switch (operator) {
		case ADD:
			result = operandLeft + operandRight;
			break;
		case SUB:
			result = operandLeft - operandRight;
			break;
		case MULT:
			result = operandLeft * operandRight;
			break;
		case DIV:
			// check corner cases with separate class of problem; here, simply avoid
			if (operandRight == 0) {
				operandRight+=2;
			}
			result = operandLeft / operandRight;
			break;
		case MOD:
			// check corner cases with separate class of problem; here, simply avoid
			if (operandRight == 0) {
				operandRight+=2;
			}
			// while modulo of negative integers is allowed by Java, not gonna sweat it here.
			operandLeft = Math.abs(operandLeft);
			operandRight = Math.abs(operandRight);
			result = operandLeft % operandRight;
			break;
		default:
			return "Evaluation Error";
		}
		return "" + result;
	}

}