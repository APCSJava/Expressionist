package collins.kent.tutor.strings;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

/***
 * Produces a problem involving a random word and a random letter sequence that
 * may appear as a substring using .indexOf
 * 
 * @author k. collins
 *
 */
@Skill(skill="Determine the index of a sequence within a string")
public class StringIndexOfProblem implements Problem {

	String word;
	String target;

	@Override
	public Problem generate(Random rng) {
		StringSource source = StringSource.getInstance();
		word = source.getRandomWord(rng, 4, 8);
		// most of the time, pick a substring from this word
		if (rng.nextDouble() < 0.8) {
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
		int start = rng.nextInt(s.length() - numLetters+1);
		return s.substring(start, start + numLetters);
	}

}
