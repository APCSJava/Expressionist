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
		pieces[0] = "(int) "+pieces[0]+".0";
		this.statement = String.join(" ", pieces);
		this.answer = p.answer;
		this.correction = "Incorrect.  Due to precedence, integer division is performed.";
	}
}
