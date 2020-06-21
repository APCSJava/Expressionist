package collins.kent.tutor;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * Creates instant expressions for building student facility with reasoning
 * about expressions across different data and operator types.
 * 
 * @author k. collins
 *
 */

public class IFTutor {

	static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Problem> correct = new ArrayList<>();
		ArrayList<Problem> toReview = new ArrayList<>();
		ArrayList<Problem> reviewed = new ArrayList<>(); // will hold all that were incorrect
		for (int i = 0; i < 5; i++) {
			Problem p = new MixedArithmeticProblem();
			ask(p, correct, toReview);
		}
		// recheck the items missed
		while (toReview.size() != 0) {
			Problem missed = toReview.remove(0);
			reviewed.add(missed); // so can retrieve it later, for analysis
			Class<? extends Problem> clazz = missed.getClass();
//			System.out.println("Reasking class " + clazz);
			try {
				ask(clazz.newInstance(), correct, toReview);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Correct: " + correct.size() + "\tIncorrect: " + reviewed.size());
	}

	public static void ask(Problem p, ArrayList<Problem> correct, ArrayList<Problem> incorrect) {
		System.out.println(p);
		String response = s.next().trim();
		if (p.isCorrect(response)) {
			correct.add(p);
		} else {
			incorrect.add(p);
			System.out.println(p.getCorrection());
		}
	}

}
