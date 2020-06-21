package collins.kent.tutor;

/***
 * Root of all problems.
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

	@Override
	public String toString() {
		return statement;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setCorrection(String correction) {
		this.correction = correction;
	}

	String getCorrection() {
		return correction;
	}
	
}