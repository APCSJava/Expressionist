package collins.kent.tutor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
		List<String> words = StringSource.getInstance().getWords();
		// choose a medium length word
		List<String> collect = words.stream()
				.filter(s -> s.length() >= 4 && s.length() <= 7)
				.collect(Collectors.toList());
		s = collect.get(rng.nextInt(collect.size()));
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
