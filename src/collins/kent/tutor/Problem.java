package collins.kent.tutor;

/***
 * Sets a common API for all problems.
 */

import java.util.Random;

public abstract class Problem {
	
	String statement;
	String answer;
	String correction;
	
	Random random = new Random();
	
	boolean isCorrect(String response) {
		return answer.equals(response);
	}
	
	String getCorrection() {
		return correction;
	}
	
	public String toString() {
		return statement;
	}
	
	/**
	 * initializes the problem
	 */
	public abstract void generate();
	
}
