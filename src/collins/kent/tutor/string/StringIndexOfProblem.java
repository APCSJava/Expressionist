package collins.kent.tutor.string;

import java.util.Random;

import collins.kent.tutor.Problem;

/***
 * Produces a problem involving a random word and a random letter sequence that
 * may appear as a substring using .indexOf
 * 
 * @author k. collins
 *
 */
public class StringIndexOfProblem implements Problem {

	String word;
	String target;

	@Override
	public Problem generate(Random rng) {
		StringSource source = StringSource.getInstance();
		word = source.getRandomWord(rng, 4, 8);
		// half the time, pick a substring from this word
		if (rng.nextDouble() < 0.5) {
			target = getOneToThreeLetterSubstring(rng, word);
		} else {
			// otherwise, grab substring from some random word
			target = getOneToThreeLetterSubstring(rng,
					source.getRandomWord(rng));
		}
		return this;
	}

	@Override
	public String getStatement() {
		return "\"" + word + "\"." + "indexOf(\"" + target + "\");";
	}

	@Override
	public String getAnswer() {
		return Integer.toString(word.indexOf(target));
	}

	private String getOneToThreeLetterSubstring(Random rng,
			String s) {
		// pick one to three letters, if word is long enough
		int numLetters = Math.min(rng.nextInt(3) + 1, s.length());
		int start = rng.nextInt(s.length() - numLetters);
		return s.substring(start, start + numLetters);
	}

}
