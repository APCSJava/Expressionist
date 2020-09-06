package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;

public class SingleTypeArithmeticProblem implements Problem {
	
	Problem specificCaseProblem;

	@Override
	public Problem generate(Random rng) {
		specificCaseProblem = rng.nextBoolean()
				? new RandomDoubleArithmeticProblem().generate(rng)
				: new RandomIntegerArithmeticProblem().generate(rng);
		return specificCaseProblem;
	}

	@Override
	public String getStatement() {
		// TODO Auto-generated method stub
		return specificCaseProblem.getStatement();
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return specificCaseProblem.getAnswer();
	}

}
