package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Solve a variety of integer arithmetic problems")
public class RandomIntegerArithmeticProblem implements Problem {

	Problem actual;

	@Override
	public Problem generate(Random rng) {
		int r = rng.nextInt(5);
		switch (r) {
		case 0:
			actual = new IntegerAdditionProblem();
			break;
		case 1:
			actual = new IntegerSubtractionProblem();
			break;
		case 2:
			actual = new IntegerMultiplicationProblem();
			break;
		case 3:
			actual = new IntegerDivisionProblem();
			break;
		case 4:
			actual = new IntegerModuloProblem();
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
