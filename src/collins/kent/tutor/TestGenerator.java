package collins.kent.tutor;

import collins.kent.tutor.arithmetic.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/***
 * Creates drills to strengthen student reasoning about expressions across
 * different data type and operators.
 * 
 * @author k. collins
 *
 */

public class TestGenerator {

	public static final String ERROR = "e";

	static final Scanner scanner = new Scanner(System.in);
	ArrayList<Problem> toAsk = new ArrayList<>();
	ArrayList<Problem> correct = new ArrayList<>();
	ArrayList<Problem> toReview = new ArrayList<>();
	ArrayList<Problem> reviewed = new ArrayList<>(); // will hold all that were
														// incorrect
	Random random = new Random(); // central source for random numbers
	int numMissed = 0;

	public void ask(Problem p) {
		System.out.println(p.getStatement());
		String response = scanner.next().trim();
		boolean isCorrect = p.isCorrect(response);
		if (isCorrect) {
			System.out.println("Correct\n");
		} else {
			System.out.println("*****  INCORRECT  *****\t"
					+ p.getFeedback(response)+"\n");
			numMissed++;
		}
	}

	public static void main(String[] args) {
		TestGenerator tutor = new TestGenerator();
		// tutor.random.setSeed(1L);
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine().trim();
		System.out.println("100 questions.  Let's begin");
		tutor.toAsk.add(new DoubleAdditionProblem());
		tutor.toAsk.add(new DoubleDivisionProblem());
		tutor.toAsk.add(new DoubleMultiplicationProblem());
		tutor.toAsk.add(new DoubleSubtractionProblem());
		tutor.toAsk.add(new IntegerAdditionProblem());
		tutor.toAsk.add(new IntegerDivisionByZeroProblem());
		tutor.toAsk.add(new IntegerDivisionProblem());
		tutor.toAsk.add(new IntegerModuloProblem());
		tutor.toAsk.add(new IntegerMultiplicationProblem());
		tutor.toAsk.add(new IntegerSubtractionProblem());
		tutor.toAsk.add(new MixedTypeArithmeticProblem());

		for (int i = 0; i < tutor.toAsk.size(); i++) {
			tutor.ask(tutor.toAsk.get(i));
		}
		System.out.println(name + " completed the assessment at "
				+ LocalDateTime.now() + ".\n" + "Final score: "
				+ (100-tutor.numMissed *2));
	}

	public void addToReview(Problem p, Random rand) {
		Class<? extends Problem> c = p.getClass();
		//System.out.println("Missed: " + p.getClass());
		//System.out.println("Adding to review: " + c);
		try {
			toReview.add(c.newInstance().generate(rand));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static String getExceptionSymbol() {
		return "e";
	}

	public static String getErrorSymbol() {
		return "e";
	}

}
