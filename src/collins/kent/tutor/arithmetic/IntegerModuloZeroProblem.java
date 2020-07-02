package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Problem;

public class IntegerModuloZeroProblem implements Problem {

	Problem original;

	@Override
	public Problem generate(Random rng) {
		original = new IntegerModuloProblem();
		original.generate(rng);
		return this;
	}

	@Override
	public String getStatement() {
		// drop all after / and insert 0
		int spaceIndex = original.getStatement().lastIndexOf(" ");
		String root = original.getStatement().substring(0, spaceIndex);
		return root + " 0";
	}

	@Override
	public String getAnswer() {
		return IFTutor.getExceptionSymbol();
	}
	
	@Override
	public boolean isCorrect(String response) {
		return IFTutor.getExceptionSymbol().equals(response);
	}

	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct.";
		}
		return "Incorrect.  An attempt to take modulo 0 results in an arithmetic exception.";
	}
}
