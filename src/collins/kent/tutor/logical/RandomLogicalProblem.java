package collins.kent.tutor.logical;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

/***
 * Creates one of the subclasses and delegates all interactions to it.
 * 
 * @author k. collins
 *
 */
@Meta(skill="Solve a variety of arithmetic problems involving doubles")
public class RandomLogicalProblem implements Problem {

	Problem actual;

	@Override
	public Problem generate(Random rng) {
		int r = rng.nextInt(4);
		switch (r) {
		case 0:
			actual = new SimpleAndOrLogicalProblem();
			break;
		case 1:
			actual = new SimpleNotLogicalProblem();
			break;
		case 2:
			actual = new SimpleNottedOperandLogicalProblem();
			break;
		case 3:
			actual = new ThreeOperandLogicalProblem();
			break;
		}
		actual.generate(rng);
		return actual;
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
