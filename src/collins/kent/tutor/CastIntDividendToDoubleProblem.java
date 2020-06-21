package collins.kent.tutor;

import static collins.kent.tutor.Operator.DIV;

/***
 * Provides practice evaluating arithmetic problems where the left operand is
 * cast to a double, as in (double) 4/8.
 * 
 * @author k. collins
 *
 */

public class CastIntDividendToDoubleProblem extends Problem {

	public CastIntDividendToDoubleProblem() {
		// get double division problem but replace left operand with cast integer
		DoubleArithmeticProblem p = new DoubleArithmeticProblem(DIV);
		String[] pieces = p.statement.split("\\.");
		String newLeft = "(double) "+pieces[0];
		String middle = pieces[1].substring(1); // remove the zero preceding /
		this.statement = newLeft + middle;
		this.answer = p.answer;
		this.correction = "Incorrect.  Due to precedence, double division is performed.";
	}

}
