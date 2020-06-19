package collins.kent.expressionator;

import static collins.kent.expressionator.Operator.ADD;

import java.util.Random;

/***
 * Creates instant expressions for building student facility with reasoning
 * about expressions across different data and operator types.
 * 
 * @author k. collins
 *
 */

public class Expressions {
	
	static Random random = new Random();
	
	public static Operator getRandomOperator() {
		int n = random.nextInt(Operator.values().length);
		return Operator.values()[n];
	}

	public static void main(String[] args) {
		for (int i = 0; i<10; i++) {
			System.out.println(getRandomOperator());
		}

	}

}
