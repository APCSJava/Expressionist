package collins.kent.tutor;

import java.util.Random;

/***
 * Produces a problem involving division of doubles. Division by zero or 0.0 is
 * not addressed. Operands are restricted to those that produce "nice" results
 * (evenly divisible or result in 0.5) to keep the emphasis on the production of
 * a double result rather than the performance of mental arithmetic.
 * 
 * @author k. collins
 *
 */
public class DoubleDivisionProblem implements Problem {

	double dividend;
	double divisor;
	double result;

	public Problem generate(Random rng) {
		// 20% cleanly divisible, 40% in half, 40% odd divided by two
		double random = rng.nextDouble();
		if (random < 0.2) {
			evenlyDivisible(rng);
		} else if (random < 0.6) {
			cleanlyInHalf(rng);
		} else
			divideOddByTwo(rng);
		return this;
	}

	private void evenlyDivisible(Random rng) {
		result = rng.nextInt(4) + 1;
		divisor = rng.nextInt(4) + 1;
		dividend = result * divisor;
	}

	private void cleanlyInHalf(Random rng) {
		result = 0.5;
		divisor = rng.nextInt(4)*2 + 2; // an even number
		dividend = result * divisor;
	}

	private void divideOddByTwo(Random rng) {
		divisor = 2.0;
		dividend = rng.nextInt(9)+1; // odd
		result = dividend / divisor;
	}

	@Override
	public String getStatement() {
		return dividend + " / " + divisor;
	}

	@Override
	public String getAnswer() {
		return Double.toString(result);
	}
	
	@Override
	public boolean isCorrect(String response) {
		if (response.indexOf(".") == -1) return false; // not formatted as double
		try {
			double answer = Double.parseDouble(response);
			return answer == dividend / divisor;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
