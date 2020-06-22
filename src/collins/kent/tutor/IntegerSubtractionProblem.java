package collins.kent.tutor;

import java.util.Random;

public class IntegerSubtractionProblem implements Problem{

	int operandLeft;
	int operandRight;

	@Override
	public Problem generate(Random rng) {
		operandLeft = rng.nextInt(10);
		operandRight = rng.nextInt(10);
		return this;
	}

	@Override
	public String getStatement() {
		return operandLeft + " - " + operandRight;
	}

	@Override
	public String getAnswer() {
		return Integer.toString(operandLeft - operandRight);
	}

}
