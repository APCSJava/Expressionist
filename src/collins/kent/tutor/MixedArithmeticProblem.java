package collins.kent.tutor;

import static collins.kent.tutor.Operator.ARITHMETIC;

/***
 * Mixed arithmetic problems involve one int operand and one double operand.
 * Because doubles are infrequently used in modulo calculations, their use --
 * though entirely permissible in Java -- is not addressed and a different operator is substituted.
 * 
 * @author k. collins
 *
 */

public class MixedArithmeticProblem extends Problem {

	int operandLeft = random.nextInt(10);
	int operandRight = random.nextInt(10);
	Operator operator = Operator.random(ARITHMETIC);
	
}
