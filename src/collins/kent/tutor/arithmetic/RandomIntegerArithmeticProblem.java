package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Solve a variety of integer arithmetic problems")
public class RandomIntegerArithmeticProblem implements Problem {

	Problem actualProblem;

	@Override
	public Problem generate(Random rng) {
		int r = rng.nextInt(7);
		switch (r) {
		case 0:
			actualProblem = new IntegerAdditionProblem();
			break;
		case 1:
			actualProblem = new IntegerSubtractionProblem();
			break;
		case 2:
			actualProblem = new IntegerMultiplicationProblem();
			break;
		case 3:
			actualProblem = new IntegerDivisionProblem();
			break;
		case 4:
			actualProblem = new IntegerModuloProblem();
			break;
		case 5:
			actualProblem = new IntegerDivisionByZeroProblem();
			break;
		case 6:
			actualProblem = new IntegerModuloZeroProblem();
			break;
		}
		actualProblem.generate(rng);
		return actualProblem; // delegate to the specific subclass
	}

	@Override
	public String getStatement() {
		return actualProblem.getStatement();
	}

	@Override
	public String getAnswer() {
		return actualProblem.getAnswer();
	}
	
	public Class<? extends Problem> getInstantiatedClass() {
		return actualProblem.getClass();
	}

}
