package collins.kent.tutor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/***
 * Produces a medium length string with indices from and to both specified that
 * avoid exceptions.
 * 
 * @author kentcollins
 *
 */
public class StringSimpleLengthOfSubstringProblem
		implements Problem {

	String s;
	int from;
	int to;

	@Override
	public Problem generate(Random rng) {
		List<String> words = StringSource.getInstance().getWords();
		// choose a medium length word
		List<String> collect = words.stream()
				.filter(s -> s.length() >= 4 && s.length() <= 8)
				.collect(Collectors.toList());
		s = collect.get(rng.nextInt(collect.size()));
		from = rng.nextInt(s.length());
		to = from + rng.nextInt(s.length()-from);
		return this;
	}

	@Override
	public String getStatement() {
		String question = "What is the length of the string returned by this expression?\n";
		question+="\t\""+s+"\".substring("+from+", "+to+");";
		return question;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(to - from);
	}

}
