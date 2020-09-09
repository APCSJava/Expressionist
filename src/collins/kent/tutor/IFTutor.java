package collins.kent.tutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import collins.kent.tutor.casting.CastDoubleDividendToIntProblem;
import collins.kent.tutor.casting.CastIntDividendToDoubleProblem;

/***
 * Creates drills to strengthen student reasoning about expressions across
 * different data type and operators.
 * 
 * @author k. collins
 *
 */

public class IFTutor {

	public static final String ERROR = "e";

	static final Scanner scanner = new Scanner(System.in);
	ArrayList<Problem> correct = new ArrayList<>();
	ArrayList<Problem> toReview = new ArrayList<>();
	ArrayList<Problem> reviewed = new ArrayList<>(); // will hold all that were
														// incorrect
	Random random = new Random(); // central source for random numbers

	public void ask(Problem p) {
		System.out.println(p.getStatement());
		String response = scanner.next().trim();
		if (p.isCorrect(response)) {
			correct.add(p);
			System.out.println(
					"Yes.  " + correct.size() + " correct.");
		} else {
			toReview.add(p);
			System.out.println("*****  INCORRECT  *****\t"
					+ p.getFeedback(response));
		}
	}

	public static void main(String[] args) {
		IFTutor tutor = new IFTutor();
		// tutor.random.setSeed(1L);
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine().trim();
		System.out.println("How many questions?");
		int numQuestions = scanner.nextInt();
		for (int i = 0; i < numQuestions; i++) {
			Problem p = null;
			double num = tutor.random.nextDouble();
			// SimpleLogical 30%
			// SimpleNot 15%
			// SimpleNotted 25%
			// ThreeOperand 30%
			if (num <0.5)
				p = new CastDoubleDividendToIntProblem(); 
			else
				p = new CastIntDividendToDoubleProblem();

			p.generate(tutor.random);
			tutor.ask(p);
		}
		// recheck the items missed
		while (tutor.toReview.size() != 0) {
			Problem missed = tutor.toReview.remove(0);
			tutor.reviewed.add(missed); // so can retrieve it later, for
										// analysis
			Class<? extends Problem> c = missed.getClass();
			try {
				tutor.ask(c.newInstance().generate(tutor.random));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " completed "
				+ tutor.correct.size() + " questions correctly on "
				+ LocalDateTime.now() + ".\n" + tutor.reviewed.size()
				+ " missed.");
		System.out.println("Topic: Casting Problems");
	}

	public static String getExceptionSymbol() {
		return "e";
	}

	public static String getErrorSymbol() {
		return "e";
	}

}
