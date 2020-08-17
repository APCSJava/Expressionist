package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

@Skill(skill="Identify integer division by zero as an error")
public class IntegerDivisionByZeroProblem implements Problem {

	Problem original;

	@Override
	public Problem generate(Random rng) {
		original = new IntegerDivisionProblem();
		original.generate(rng);
		return this;
	}

	@Override
	public String getStatement() {
		// drop all after / and insert 0
		int spaceIndex = original.getStatement().lastIndexOf(" ");
		String sub = original.getStatement().substring(0, spaceIndex);
		return sub += " 0";
	}

	@Override
	public String getAnswer() {
		return IFTutor.getErrorSymbol();
	}

	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct.";
		}
		return "Incorrect.  Division by the integer literal 0 is detected as an error by the compiler.";
	}

}
