package collins.kent.tutor;

import static collins.kent.tutor.Operator.*;

/***
 * Easy math problems involve the five arithmetic operators and two numeric
 * operands of the same type.
 * 
 * @author k. collins
 *
 */

public class EasyMathProblem extends Problem {

	int operandLeft = random.nextInt(10);
	int operandRight = random.nextInt(10);
	Operator operator = Operator.random(ARITHMETIC);
	
	public EasyMathProblem() {
		generate();
	}
	
	public EasyMathProblem(Operator op) {
		operator = op;
		generate();
	}

	public void generate() {
		this.statement = operandLeft + " " + symbol(operator) + " " + operandRight;
		this.answer = evaluate();
		this.correction = correction == null ? "Incorrect.  The answer is " + answer : correction;
	}

	/**
	 * Builds the result string
	 * 
	 * @param operands
	 * @param operator
	 * @return
	 */
	public String evaluate() {
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
			if (operandRight == 0) {
				correction = "Incorrect. Division by zero will be caught be the compiler.";
				return "error";
			}
			result = operandLeft / operandRight;
			break;
		case MOD:
			result = operandLeft % operandRight;
			break;
		default:
			return "Evaluation Error";
		}
		return "" + result;
	}

}
