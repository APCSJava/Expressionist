package collins.kent.tutor;

import static collins.kent.tutor.Operator.*;

/***
 * Practice problems involving exclusively doubles. The emphasis is on the
 * operator and that the output produced is a double and needs to be written as
 * such. For that reason, any attempt at modulo will be replaced by a different
 * operator.
 * 
 * @author k. collins
 *
 */

public class EasyDoubleMathProblem extends Problem {

	int operandLeft = random.nextInt(10);
	int operandRight = random.nextInt(10);
	Operator operator = Operator.random(ARITHMETIC);

	public EasyDoubleMathProblem() {
		while (operator == MOD) { // roll again
			operator = Operator.random(ARITHMETIC);
		}
		generate();
	}

	public EasyDoubleMathProblem(Operator op) {
		operator = op;
		while (operator == MOD) { // roll again
			operator = Operator.random(ARITHMETIC);
		}
		generate();
	}

	public void generate() {
		this.answer = evaluate();
		this.statement = operandLeft + ".0 " + symbol(operator) + " " + operandRight+".0 ";
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
			if (operandLeft>5) operandLeft/=2;
			if (operandRight>5) operandRight/=2;
			result = operandLeft * operandRight;
			break;
		case DIV:
			if (operandRight == 0) {
				// dividing by 0.0 yields Infinity but not emphasizing that here.
				operandRight = 2; // arbitrary choice
			}
			
			// refrain from large numbers
			if (operandLeft>5) operandLeft/=2;
			if (operandRight>5) operandRight/=2;
			
			// make evenly divisible
			int product = operandLeft * operandRight;
			int lower = Math.min(operandLeft, operandRight);
			int higher = Math.max(operandLeft, operandRight);
			
			// allow, if evenly divisible
			if (lower == 2) {
				operandLeft = higher;
				operandRight = product;
				return "0.5";
			}
			operandLeft = product;
			operandRight = higher;
			result = lower;
			break;
		default:
			return "Evaluation Error";
		}
		return "" + result + ".0";
	}

}
