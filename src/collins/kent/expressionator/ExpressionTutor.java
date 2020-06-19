package collins.kent.expressionator;

import static collins.kent.expressionator.Operator.*;
import java.util.Random;

/***
 * Creates instant expressions for building student facility with reasoning
 * about expressions across different data and operator types.
 * 
 * @author k. collins
 *
 */

public class ExpressionTutor {

	private Random random = new Random();
	
	public String generateProblem() {
		Operator op = Operator.random(ARITHMETIC);
		double LHS = (double) random.nextInt(10)-5;
		int RHS = random.nextInt(10);
		return LHS+" "+symbol(op)+" "+RHS;
	}

	public static void main(String[] args) {
		ExpressionTutor et = new ExpressionTutor();
		for (int i = 0; i < 10; i++) {
			System.out.println(et.generateProblem());
		}
	}

}
