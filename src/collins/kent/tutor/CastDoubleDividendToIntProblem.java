package collins.kent.tutor;

import static collins.kent.tutor.Operator.DIV;

/***
 * Provides practice evaluating arithmetic problems where the left operand is
 * cast to an integer, as in (int) 4.0/8.
 * 
 * @author k. collins
 *
 */

public class CastDoubleDividendToIntProblem extends Problem {

	public CastDoubleDividendToIntProblem() {
		// get integer division problem but replace left operand with cast double
		IntegerArithmeticProblem p = new IntegerArithmeticProblem(DIV);
		String[] pieces = p.statement.split(" ");
		pieces[0] = "(int) " + pieces[0] + ".0";
		this.statement = String.join(" ", pieces);
		this.answer = p.answer;
		this.correction = "Incorrect.  Due to precedence, integer division is performed.";
	}

	/**
	 * Now that we have a response available, override is correct and modify our
	 * correction string, if needed.
	 */
	@Override
	boolean isCorrect(String response) {
		if (!response.equals(this.answer)) {
			try {
				Integer.parseInt(response);
				// we got an int, so type is correct, must be wrong value
				this.correction = "Incorrect value.  The integer " + this.answer +" was expected.";
			} catch (NumberFormatException e) {
				// was not an int and should have been -- let original correction stand
			}
		}
		return super.isCorrect(response);
	}
}
