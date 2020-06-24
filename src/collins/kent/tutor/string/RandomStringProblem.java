package collins.kent.tutor.string;

import java.util.Random;

import collins.kent.tutor.Problem;

public class RandomStringProblem implements Problem {

	Problem actual;

	@Override
	public Problem generate(Random rng) {
		int r = rng.nextInt(7);
		switch (r) {
		case 0:
			actual = new StringIndexOfProblem();
			break;
		case 1:
			actual = new StringLengthProblem();
			break;
		case 2:
			actual = new SubstringIndexErrorProblem();
			break;
		case 3:
			actual = new SubstringLengthSingleArgumentProblem();
			break;
		case 4:
			actual = new SubstringLengthTwoArgumentProblem();
			break;
		case 5:
			actual = new SubstringSingleIndexProblem();
			break;
		case 6:
			actual = new SubstringTwoIndexProblem();
			break;
		}
		actual.generate(rng);
		return this;
	}

	@Override
	public String getStatement() {
		return actual.getStatement();
	}

	@Override
	public String getAnswer() {
		return actual.getAnswer();
	}
	
	public Class<? extends Problem> getInstantiatedClass() {
		return actual.getClass();
	}

}
