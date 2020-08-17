package collins.kent.tutor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import collins.kent.defunct.RecognizeLiteralValueProblem;

/***
 * Creates drills to strengthen student reasoning about expressions across
 * different data type and operators.
 * 
 * @author k. collins
 *
 */

public class IFTutor {

	public static final String ERROR = "e";

	static final Scanner s = new Scanner(System.in);
	ArrayList<Problem> correct = new ArrayList<>();
	ArrayList<Problem> toReview = new ArrayList<>();
	ArrayList<Problem> reviewed = new ArrayList<>(); // will hold all that were
														// incorrect
	Random random = new Random(); // central source for random numbers

	public void ask(Problem p) {
		System.out.println(p.getStatement());
		String response = s.next().trim();
		if (p.isCorrect(response)) {
			correct.add(p);
		} else {
			toReview.add(p);
			System.out.println(p.getFeedback(response));
		}
		System.out.println("Number correct: " + correct.size());
	}

	public static void main(String[] args) {
		IFTutor tutor = new IFTutor();
		//tutor.random.setSeed(1L);
		for (int i = 0; i < 20; i++) {
			Problem p = new RecognizeLiteralValueProblem()
					.generate(tutor.random);
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
		System.out.println("Correct: " + tutor.correct.size()
				+ "\tIncorrect: " + tutor.reviewed.size());
	}

	public static String getExceptionSymbol() {
		return "e";
	}

	public static String getErrorSymbol() {
		return "e";
	}

}
