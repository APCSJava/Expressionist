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
public class SubstringSingleIndexProblem implements Problem {

	String s;
	int from;

	@Override
	public Problem generate(Random rng) {
		List<String> words = StringSource.getInstance().getWords();
		// choose a medium length word
		List<String> collect = words.stream()
				.filter(s -> s.length() >= 3 && s.length() <= 6)
				.collect(Collectors.toList());
		s = collect.get(rng.nextInt(collect.size()));
		from = rng.nextInt(s.length()+1); // want to include final index
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
