package collins.kent.tutor.string;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import collins.kent.tutor.Problem;

/***
 * Produces a medium length string with a single 'from' index.
 * 
 * @author kentcollins
 *
 */
public class SubstringLengthSingleArgumentProblem
		implements Problem {

	String s;
	int from;

	@Override
	public Problem generate(Random rng) {
		s=StringSource.getInstance().getRandomWord(rng, 4, 6);
		from = rng.nextInt(s.length());
		return this;
	}

	@Override
	public String getStatement() {
		String question = "\""+s+"\".substring("+from+").length()";
		return question;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(s.length()-from);
	}

}
