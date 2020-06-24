package collins.kent.tutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * Singleton instance used as a source of words and phrases. 
 * 
 * @author k. collins
 *
 */

public final class StringSource {

	private static StringSource instance;

	private StringSource() {
	}

	public static StringSource getInstance() {
		if (instance == null) {
			instance = new StringSource();
		}
		return instance;
	}

	List<String> words = Arrays.asList(new String[] { "quick", "terminator", "start" });
	public List<String> getWords() {
		return new ArrayList<>(words);
	}

	public List<String> getPhrases() {
		return phrases;
	}

	List<String> phrases = Arrays.asList(new String[] { "Love's Labours Lost", "Hello, World!", "Let's go.", "Just do it!" });

	String getRandomWord(Random random) {
		return words.get(random.nextInt(words.size()));
	}

	int map(double d, int range) {
		return (int) (d * range);
	}

}
