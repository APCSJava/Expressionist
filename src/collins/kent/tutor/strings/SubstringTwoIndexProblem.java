package collins.kent.tutor.strings;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

/***
 * Produces a substring from a medium length string. Quote marks are expected to
 * emphasize that a string type is returned.
 * 
 * @author kentcollins
 *
 */
@Skill(skill="Extract portions of a string using substring() [two parameters]")
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
