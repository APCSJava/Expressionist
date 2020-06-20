package tutor;

public class Problem {
	
	String statement;
	String answer;
	String correction;
	
	boolean isCorrect(String response) {
		return answer.equals(response);
	}
	
	String getCorrection() {
		return correction;
	}
	
	public String toString() {
		return statement;
	}
	
}
