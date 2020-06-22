package collins.kent.tutor;

/***
 * Inteface for the root of all problems.
 * 
 * @author k. collins
 */

public interface Problem {

	Problem generate(java.util.Random rng);

	String getStatement();

	String getAnswer();

	default boolean isCorrect(String response) {
		return getAnswer().equals(response);
	}

	default String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct";
		}
		return "Incorrect.  The correct answer is " + getAnswer();
	}
}
