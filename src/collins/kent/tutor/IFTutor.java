package collins.kent.tutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import collins.kent.tutor.strings.*;

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
		boolean isCorrect = p.isCorrect(response);
		if (isCorrect) {
			correct.add(p);
			System.out.println(
					"Yes.  " + correct.size() + " correct.");
		} else {
			addToReview(p, random);
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
			Problem p = new RandomStringProblem();
//			double num = tutor.random.nextDouble();
//			if (num < 0.2)
//				p = new SubstringIndexErrorProblem();
//			else if (num < 0.4)
//				p = new SubstringLengthSingleArgumentProblem();
//			else if (num < 0.6)
//				p = new SubstringLengthTwoArgumentProblem();
//			else if (num < 0.8)
//				p = new SubstringSingleIndexProblem();
//			else
//				p = new SubstringTwoIndexProblem();
			p.generate(tutor.random);
			tutor.ask(p);
		}
		// recheck the items missed
		while (tutor.toReview.size() != 0) {
			Problem missed = tutor.toReview.remove(0);
			tutor.reviewed.add(missed); // so can retrieve it later, for
										// analysis
			tutor.ask(missed);

		}
		System.out.println(name + " completed "
				+ tutor.correct.size() + " questions correctly on "
				+ LocalDateTime.now() + ".\n" + tutor.reviewed.size()
				+ " missed.");
		System.out.println("Topic: Mixed String Problems");
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
