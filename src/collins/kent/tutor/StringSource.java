package collins.kent.tutor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * Singleton instance used as a word source. Requests are made with a random
 * number to keep this class from needing its own random number source.
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

	List<String> words = Arrays.asList(new String[] { "quick", "terminator" });
	List<String> phrases = Arrays.asList(new String[] { "Love's Labours Lost", "Hello, World!" });

	String getRandomWord(double rand) {
		return words.get(map(rand, words.size()));
	}
	
	int map(double d, int range) {
		return (int) (d*range);
	}

}
