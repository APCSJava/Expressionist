package collins.kent.tutor;

/***
 * Inteface for the root of all problems.
 * 
 * @author k. collins
 */

public interface Problem {

	String getStatement();

	String getAnswer();

	default Problem generate(java.util.Random rng) {
		return this;
	}

	default boolean isCorrect(String response) {
		return getAnswer().equals(response);
	}

	default String getCorrection(String response) {
		if (isCorrect(response)) {
			return "Correct";
		}
		return "Incorrect.  The correct answer is " + getAnswer();
	}
}
