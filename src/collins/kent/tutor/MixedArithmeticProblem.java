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

}
