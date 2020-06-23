package collins.kent.tutor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * Singleton instance used as a word source
 * 
 * @author k. collins
 *
 */

public final class StringSource {
	
	private static StringSource instance;
	Random random;
	
	private StringSource() {	
	}
	
	public static StringSource getInstance() {
		if (instance == null) {
			instance = new StringSource();
		}
		return instance;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	List<String> words = Arrays.asList(new String[] {"quick", "terminator"});
	List<String> phrases = Arrays.asList(new String[] {"Love's Labours Lost", "Hello, World!"});
	
	String getRandomWord() {
		if (random == null) throw new UnsupportedOperationException("Random number generator not set.");
		return words.get(random.nextInt(words.size()));
	}

}
