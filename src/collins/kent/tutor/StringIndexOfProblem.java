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
	String chosenLetter;
	private int index;

	@Override
	public Problem generate(Random rng) {
		StringSource source = StringSource.getInstance();
		word = source.getRandomWord(rng);
		index = rng.nextInt(word.length());
		chosenLetter = word.substring(index, index+1);
		return this;
	}

	@Override
	public String getStatement() {
				return "\""+word+"\"."+"indexOf(\""+chosenLetter+"\");";
	}

	@Override
	public String getAnswer() {
		// doesn't work if builds off the last occurrence of a repeated letter
		// return Integer.toString(index);
		return Integer.toString(word.indexOf(chosenLetter));
	}

}
