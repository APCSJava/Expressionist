package collins.kent.tutor;

import java.util.Random;

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
