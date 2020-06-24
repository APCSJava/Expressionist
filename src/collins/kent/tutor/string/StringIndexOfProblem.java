package collins.kent.tutor.string;

import java.util.Random;

import collins.kent.tutor.Problem;

/***
 * Produces a problem involving determining the location of a character in a
 * medium length string literal.
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
		word = source.getRandomWord(rng, 4, 8);
		index = rng.nextInt(word.length());
		chosenLetter = word.substring(index, index + 1);
		return this;
	}

	@Override
	public String getStatement() {
		return "\"" + word + "\"." + "indexOf(\"" + chosenLetter
				+ "\");";
	}

	@Override
	public String getAnswer() {
		// doesn't work if builds off the last occurrence of a repeated letter
		// return Integer.toString(index);
		return Integer.toString(word.indexOf(chosenLetter));
	}

}
