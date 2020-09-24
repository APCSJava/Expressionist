package collins.kent.tutor.strings;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Produces a substring from a medium length string. Quote marks are expected to
 * emphasize that a string type is returned.
 * 
 * @author kentcollins
 *
 */
@Meta(skill="Extract portions of a string using substring() [two parameters]")
public class SubstringTwoIndexProblem implements Problem {

	String s;
	int from;
	int to;

	@Override
	public Problem generate(Random rng) {
		s=StringSource.getInstance().getRandomWord(rng, 4, 7);
		from = rng.nextInt(s.length()+1); // occasionally, ask about final index
		from /= rng.nextBoolean() ? 1 : 2; // favor lower indices
		int maxOffset = s.length() - from; // 
		to = from + rng.nextInt(Math.max(0, maxOffset)+1);
		if (from == to && rng.nextBoolean()) { // not so many where they match
			if (to < s.length()) to++;
		}
		return this;
	}

	@Override
	public String getStatement() {
		String question = "\"" + s + "\".substring(" + from + ", "
				+ to + ")";
		return question;
	}

	@Override
	public String getAnswer() {
		return "\"" + s.substring(from, to) + "\"";
	}

}
