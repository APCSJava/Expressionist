package collins.kent.tutor.strings;

import java.util.Random;

import collins.kent.tutor.Operator;
import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Produces a problem wherein two strings are compared and the result is
 * evaluated.
 * 
 * @author k. collins
 *
 */
@Meta(skill="Compare two strings using the compareTo() method")
public class StringCompareToProblem implements Problem {

	String word1;
	String word2;
	Operator op;
	boolean answer;

	@Override
	public Problem generate(Random rng) {
		StringSource source = StringSource.getInstance();
		word1 = source.getRandomWord(rng);
		word2 = source.getRandomWord(rng);
		// 10% of the time, make them match
		if (rng.nextDouble() < 0.1) {
			word1 = word2;
		}
		int result = word1.compareTo(word2);
		if (rng.nextDouble() < 0.45) {
			op = Operator.LT;
			answer = result < 0;
		} else if (rng.nextDouble() < 0.90) {
			op = Operator.GT;
			answer = result > 0;
		} else {
			op = Operator.EQUAL;
			answer = result == 0;
		}
		return this;
	}

	@Override
	public String getStatement() {
		return "\"" + word1 + "\"." + "compareTo(\"" + word2 + "\") "
				+ Operator.symbol(op) + " 0";
	}

	@Override
	public String getAnswer() {
		return Boolean.toString(answer);
	}

}
