package collins.kent.tutor.arithmetic;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Produces random addition, subtraction, multiplication and division problems
 * involving exclusively doubles. 
 * 
 * @author k. collins
 *
 */
@Meta(skill="Solve a variety of arithmetic problems involving doubles")
public class RandomDoubleArithmeticProblem implements Problem {

	Problem actual;

	@Override
	public Problem generate(Random rng) {
		int r = rng.nextInt(4);
		switch (r) {
		case 0:
			actual = new DoubleAdditionProblem();
			break;
		case 1:
			actual = new DoubleSubtractionProblem();
			break;
		case 2:
			actual = new DoubleMultiplicationProblem();
			break;
		case 3:
			actual = new DoubleDivisionProblem();
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

	@Override
	public boolean isCorrect(String response) {
		return actual.isCorrect(response);
	}

	public Class<? extends Problem> getInstantiatedClass() {
		return actual.getClass();
	}

}
