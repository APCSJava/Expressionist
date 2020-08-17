package collins.kent.tutor.strings;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

/***
 * Produces a medium length string with indices from and to both specified that
 * avoid exceptions.
 * 
 * @author kentcollins
 *
 */
@Skill(skill="Determine the length of an extracted substring [two parameters]")
public class SubstringLengthTwoArgumentProblem implements Problem {

	String s;
	int from;
	int to;

	@Override
	public Problem generate(Random rng) {
		s = StringSource.getInstance().getRandomWord(rng, 4, 10);
		from = rng.nextInt(s.length());
		to = from + rng.nextInt(s.length() - from);
		return this;
	}

	@Override
	public String getStatement() {
		String question = "\"" + s + "\".substring(" + from + ", "
				+ to + ").length()";
		return question;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(to - from);
	}

}
