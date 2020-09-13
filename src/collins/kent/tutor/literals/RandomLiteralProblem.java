package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Meta;
import collins.kent.tutor.Problem;

/***
 * Creates one of the subclasses and delegates all interactions to it.
 * 
 * @author k. collins
 *
 */
@Meta(skill="Recognize literal values of different types")
public class RandomLiteralProblem implements Problem {

	Problem actual;

	@Override
	public Problem generate(Random rng) {
		double r = rng.nextDouble();
		if (r < 0.1) actual = new GotchaStringNotBooleanProblem();
		else if (r<0.2) actual = new GotchaStringNotCharProblem();
		else if (r<0.3) actual = new GotchaStringNotNumericProblem();
		else if (r<0.4) actual = new RecognizeBooleanLiteralProblem();
		else if (r<0.5) actual = new RecognizeCharLiteralProblem();
		else if (r<0.6) actual = new RecognizeDoubleLiteralProblem();
		else if (r<0.7) actual = new RecognizeFloatLiteralProblem();
		else if (r<0.8) actual = new RecognizeIntLiteralProblem();
		else if (r<0.9) actual = new RecognizeLongLiteralProblem();
		else if (r<1.0) actual = new GotchaOperatorNotLiteralProblem();
		else if (r<1.1) actual = new RecognizeStringLiteralProblem();
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
