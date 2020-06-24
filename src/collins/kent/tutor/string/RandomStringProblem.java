package collins.kent.tutor.string;

import java.util.Random;

import collins.kent.tutor.Problem;

public class RandomStringProblem implements Problem {

	Problem actual;
	Class[] classes = { StringIndexOfProblem.class,
			StringLengthProblem.class,
			SubstringIndexErrorProblem.class,
			SubstringLengthSingleArgumentProblem.class,
			SubstringLengthTwoArgumentProblem.class,
			SubstringSingleIndexProblem.class,
			SubstringTwoIndexProblem.class
			};

	@Override
	public Problem generate(Random rng) {
		int selection = rng.nextInt(classes.length);
		try {
			actual = (Problem) classes[selection].newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
