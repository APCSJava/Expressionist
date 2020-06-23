package collins.kent.tutor;

import java.util.Random;

/***
 * Produces a problem involving determining the location of a character in a string literal.
 * 
 * @author k. collins
 *
 */
public class StringIndexOfProblem implements Problem {
	
	String word;
	private int index;

	@Override
	public Problem generate(Random rng) {
		StringSource source = StringSource.getInstance();
		this.word = source.getRandomWord(rng.nextDouble());
		int length = word.length();
		this.index = rng.nextInt(length);
		return this;
	}

	@Override
	public String getStatement() {
				return "\""+word+"\"."+"indexOf(\""+word.charAt(index)+"\");";
	}

	@Override
	public String getAnswer() {
		return Integer.toString(index);
	}

}
