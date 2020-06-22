package collins.kent.tutor;

import java.util.Random;

/***
 * Mixed arithmetic problems involve one int operand and one double operand.
 * Because doubles are infrequently used in modulo calculations, their use --
 * though entirely permissible in Java -- is not addressed and a different
 * operator is substituted.
 * 
 * @author k. collins
 *
 */

public class RandomMixedArithmeticProblem implements Problem {
	
	Problem original;
	String revisedStatement;

	@Override
	public Problem generate(Random rng) {
		// grab a double problem and randomly remove a .0 from an operand
		original = new RandomDoubleArithmeticProblem();
		String s = original.getStatement();
		if (rng.nextDouble() < 0.5) {
			int firstDotLoc = s.indexOf(".0");
			String left = s.substring(0, firstDotLoc);
			String right = s.substring(firstDotLoc + 2); // skip .0
			revisedStatement = left+right;
		} else {
			int lastDotLoc = s.lastIndexOf(".0");
			revisedStatement = s.substring(0, lastDotLoc);	
		}
		return this;
	}

	@Override
	public String getStatement() {
		return revisedStatement;
	}

	@Override
	public String getAnswer() {
		return original.getAnswer();
	}

}
