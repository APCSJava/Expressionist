package collins.kent.tutor.logical;

import java.util.Random;

import collins.kent.tutor.Problem;

public class SimpleNotLogicalProblem implements Problem {

	boolean premise;
	
	@Override
	public Problem generate(Random rng) {
		premise = rng.nextBoolean();
		return this;
	}

	@Override
	public String getStatement() {
		return "!"+premise;
	}

	@Override
	public String getAnswer() {
		return Boolean.toString(!premise);
	}

}
