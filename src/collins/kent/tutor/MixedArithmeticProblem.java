package collins.kent.tutor;

/***
 * Mixed arithmetic problems involve one int operand and one double operand.
 * Because doubles are infrequently used in modulo calculations, their use --
 * though entirely permissible in Java -- is not addressed and a different
 * operator is substituted.
 * 
 * @author k. collins
 *
 */

public class MixedArithmeticProblem extends Problem {

	public MixedArithmeticProblem() {
		DoubleArithmeticProblem doubleProblem = new DoubleArithmeticProblem();
		copyInfoFromDoubleProblem(doubleProblem);
	}

	public MixedArithmeticProblem(Operator op) {
		DoubleArithmeticProblem doubleProblem = new DoubleArithmeticProblem(op);
		copyInfoFromDoubleProblem(doubleProblem);
	}

	public void copyInfoFromDoubleProblem(DoubleArithmeticProblem dap) {
		this.answer = dap.answer;
		this.correction = dap.correction;
		this.statement = modifyStatement(dap.statement);
	}

	private String modifyStatement(String s) {
		// removes the .0 from at random the left or right operand
		if (Math.random() < 0.5) {
			int firstDotLoc = s.indexOf(".");
			String left = s.substring(0, firstDotLoc);
			String right = s.substring(firstDotLoc + 2); // skip .0
			return left + right;
		} else {
			int lastDotLoc = s.lastIndexOf(".");
			String left = s.substring(0, lastDotLoc);
			String right = s.substring(lastDotLoc + 2); // skip .0
			return left + right;
		}
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
				// we got an int and should have been a double
				this.correction = "Incorrect.  That's not the right type. A double was expected.";
			} catch (NumberFormatException e) {
				// got a double, so the value must be wrong
				this.correction = "Incorrect value.  The double " + this.answer +" was expected.";
			}
		}
		return super.isCorrect(response);
	}

}
