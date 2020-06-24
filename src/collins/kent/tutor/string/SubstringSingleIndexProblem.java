package collins.kent.tutor.string;

import java.util.Random;

import collins.kent.tutor.Problem;

/***
 * Produces a substring from a medium length string. Quote marks are expected to
 * emphasize that a string type is returned.
 * 
 * @author kentcollins
 *
 */
public class SubstringSingleIndexProblem implements Problem {

	String s;
	int from;

	@Override
	public Problem generate(Random rng) {
		s = StringSource.getInstance().getRandomWord(rng, 3, 6);
		from = rng.nextInt(s.length() + 1); // want to include final index
		return this;
	}

	@Override
	public String getStatement() {
		String question = "\"" + s + "\".substring(" + from + ")";
		return question;
	}

	@Override
	public String getAnswer() {
		return "\"" + s.substring(from) + "\"";
	}

}
