package collins.kent.tutor.strings;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Produces a medium length string with a single 'from' index.
 * 
 * @author kentcollins
 *
 */
@Meta(skill="Determine the length of an extracted substring [one parameter]")
public class SubstringLengthSingleArgumentProblem
		implements Problem {

	String s;
	int from;

	@Override
	public Problem generate(Random rng) {
		s = StringSource.getInstance().getRandomWord(rng, 4, 6);
		from = rng.nextInt(s.length());
		return this;
	}

	@Override
	public String getStatement() {
		String question = "\"" + s + "\".substring(" + from
				+ ").length()";
		return question;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(s.length() - from);
	}

}
