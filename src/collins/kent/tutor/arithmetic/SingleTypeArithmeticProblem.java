package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;

public class SingleTypeArithmeticProblem implements Problem {
	
	Problem actualProblem;

	@Override
	public Problem generate(Random rng) {
		actualProblem = rng.nextBoolean()
				? new RandomDoubleArithmeticProblem().generate(rng)
				: new RandomIntegerArithmeticProblem().generate(rng);
		return actualProblem;
	}

	@Override
	public String getStatement() {
		// TODO Auto-generated method stub
		return actualProblem.getStatement();
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return actualProblem.getAnswer();
	}

}
