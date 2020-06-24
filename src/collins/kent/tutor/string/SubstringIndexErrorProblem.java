package collins.kent.tutor.string;

import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Problem;

/***
 * Produces a medium length string with crossed indices demonstrating an
 * exception.
 * 
 * @author kentcollins
 *
 */
public class SubstringIndexErrorProblem implements Problem {

	String s;
	int from;
	int to;

	@Override
	public Problem generate(Random rng) {
		s = StringSource.getInstance().getRandomWord(rng, 3, 6);
		from = rng.nextInt(s.length() - 1);
		to = from + rng.nextInt(s.length() - from);
		// swap indices to create an exception
		int temp = to;
		to = from;
		from = temp;
		// avoid both indices the same which would not throw an exception
		if (from == to)
			from++;
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
		return IFTutor.getExceptionSymbol();
	}

	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct";
		}
		return "The first index is higher than the second -- an exception will be thrown when extracting the substring.";
	}

}
