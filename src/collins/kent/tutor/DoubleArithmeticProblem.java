package collins.kent.tutor;

import static collins.kent.tutor.Operator.*;

/***
 * Practice problems involving exclusively doubles. The emphasis is on the
 * operator and that the output produced is a double and needs to be written as
 * such. For that reason, any attempt at modulo will be replaced by the division
 * operator.
 * 
 * @author k. collins
 *
 */

public class DoubleArithmeticProblem extends Problem {

	int operandLeft = random.nextInt(10);
	int operandRight = random.nextInt(10);
	Operator operator = Operator.random(ARITHMETIC);

	public DoubleArithmeticProblem() {
		if (operator == MOD) { // roll again
			operator = DIV;
		}
		generate();
	}

	public DoubleArithmeticProblem(Operator op) {
		operator = op;
		if (operator == MOD) { // roll again
			operator = DIV;
		}
		generate();
	}

	public void generate() {
		this.answer = evaluate();
		this.statement = operandLeft + ".0 " + symbol(operator) + " " + operandRight + ".0 ";
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
			// refrain from large numbers
			if (operandLeft > 5)
				operandLeft /= 2;
			if (operandRight > 5)
				operandRight /= 2;
			result = operandLeft * operandRight;
			break;
		case DIV:
			if (operandRight == 0) {
				// dividing by 0.0 yields Infinity but not emphasizing that here.
				operandRight = 2; // arbitrary choice
			}
			// raise the chances for division by two by an odd number
			if (Math.random() < 0.5) {
				operandRight = 2;
				if (operandLeft % 2 == 0)
					operandLeft++;
			}
			// permit division by two straightaway, as relatively easy to realize x.5
			if (operandRight == 2) {
				return "" + ((double) operandLeft / operandRight);
			}

			// knock back large numbers
//			if (operandLeft > 5)
//				operandLeft /= 2;
			if (operandRight > 5)
				operandRight /= 2;

			// eliminate most divisions that yield 1.0
			if (operandLeft == operandRight && Math.random() < 0.8) {
				operandRight += Math.random() < 0.5 ? 1 : 2;
			}

			// creates evenly divisible double
			int product = operandLeft * operandRight;
			result = operandLeft;
			operandLeft = product;
			break;
		default:
			return "Evaluation Error";
		}
		return "" + result + ".0";
	}

}
