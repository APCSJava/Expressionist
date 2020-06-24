package collins.kent.tutor.string;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import collins.kent.tutor.Problem;

/***
 * Produces a substring from a medium length string. Quote marks are expected to
 * emphasize that a string type is returned.
 * 
 * @author kentcollins
 *
 */
public class SubstringTwoIndexProblem implements Problem {

	String s;
	int from;
	int to;

	@Override
	public Problem generate(Random rng) {
		s=StringSource.getInstance().getRandomWord(rng, 4, 7);
		from = rng.nextInt(s.length()+1); // occasionally, ask about final index
		to = from + rng.nextInt(s.length() - from);
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
