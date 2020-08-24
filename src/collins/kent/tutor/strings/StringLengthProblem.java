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
@Meta(skill="Determine the length of a string")
public class StringLengthProblem implements Problem {

	String s;

	@Override
	public Problem generate(Random rng) {
		s = StringSource.getInstance().getRandomWord(rng, 3, 7);
		return this;
	}

	@Override
	public String getStatement() {
		String question = "\"" + s + "\".length()";
		return question;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(s.length());
	}

}
