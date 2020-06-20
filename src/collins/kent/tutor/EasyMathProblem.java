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

	
	public void generate() {
		Operator op = Operator.random(ARITHMETIC);
		double LHS = (double) random.nextInt(10) - 5;
		int RHS = random.nextInt(10);
		return LHS + " " + symbol(op) + " " + RHS;
	}
}
