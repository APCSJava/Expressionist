package collins.kent.tutor;

import static collins.kent.tutor.Operator.*;

public class DivModByZeroProblem extends Problem {

	public DivModByZeroProblem() {
		this(Math.random() < 0.5 ? DIV : MOD);
	}

	public DivModByZeroProblem(Operator op) {
		if (!(op == MOD || op == DIV))
			op = Math.random() < 0.5 ? MOD : DIV;
		IntegerArithmeticProblem intProblem = new IntegerArithmeticProblem(op);
		int lastSpaceLoc = intProblem.statement.lastIndexOf(" ");
		this.statement = intProblem.statement.substring(0, lastSpaceLoc) + " 0";
		this.answer = "e";
		if (op == DIV) {
			this.correction = "Incorrect.  Division by the integer literal 0 is detected as an error by the compiler.";
		} else {
			this.correction = "Incorrect.  Attempting to modulo 0 results in a run time exception.";
		}
	}

}
