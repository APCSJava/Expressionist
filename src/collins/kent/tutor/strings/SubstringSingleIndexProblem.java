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
@Meta(skill="Extract portions of a string using substring() [one parameter]")
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
