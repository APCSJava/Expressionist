package collins.kent.tutor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static collins.kent.tutor.Operator.*;

/***
 * Creates instant expressions for building student facility with reasoning
 * about expressions across different data and operator types.
 * 
 * @author k. collins
 *
 */

public class IFTutor {

	private Random random = new Random();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Problem> incorrect = new ArrayList<>();
		ArrayList<Problem> correct = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
//			Problem p = Math.random() < 0.5 ? new DoubleArithmeticProblem(DIV) : new IntegerArithmeticProblem(DIV);
			Problem p = new MixedArithmeticProblem();
			System.out.println(p);
			String response = s.next().trim();
			if (p.isCorrect(response)) {
				correct.add(p);
			} else {
				incorrect.add(p);
				System.out.println(p.getCorrection());
			}
		}
		System.out.println("Correct: " + correct.size() + "\tIncorrect: " + incorrect.size());
	}

}
