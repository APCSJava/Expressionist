package tutor;

import static tutor.Operator.ARITHMETIC;
import static tutor.Operator.symbol;

public class EasyMathProblem extends Problem {

	public EasyMathProblem() {
		statement = "1+4";
		answer = "5";
		correction = "that is incorrect";
	}
//	
//	public String generateProblem() {
//		Operator op = Operator.random(ARITHMETIC);
//		double LHS = (double) random.nextInt(10) - 5;
//		int RHS = random.nextInt(10);
//		return LHS + " " + symbol(op) + " " + RHS;
//	}
}
