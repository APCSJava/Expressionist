package collins.kent.tutor.comparison;

import java.util.Random;

import collins.kent.tutor.Problem;

public class GotchaIntegerComparisonProblem implements Problem {
	
	String opt1 = "5/10 == 2/10 + 2/10";
	String opt2 = "3/10 == 1/10 + 2/10";
	String opt3 = "5/10 == 6/10";
	String opt4 = "1/10 + 2/10 == 4/10";
	String opt5 = "2/10 + 2/10 == 5/10";
	String[] options = {opt1, opt2, opt3, opt4, opt5};
	String selected;

	@Override
	public Problem generate(Random rng) {
		selected = options[rng.nextInt(options.length)];
		return this;
	}

	@Override
	public String getStatement() {
		return selected;
	}

	@Override
	public String getAnswer() {
		return Boolean.toString(true);
	}
	
	@Override
	public String getFeedback(String s) {
		return "Incorrect.  The statement is true.  Notice that integer division is being performed.";
	}

}
