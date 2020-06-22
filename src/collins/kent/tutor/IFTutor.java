package collins.kent.tutor;

import java.util.ArrayList;
import java.util.Random;
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
	ArrayList<Problem> correct = new ArrayList<>();
	ArrayList<Problem> toReview = new ArrayList<>();
	ArrayList<Problem> reviewed = new ArrayList<>(); // will hold all that were incorrect
	Random random = new Random(); // central source for random numbers

	public void ask(Problem p) {
		System.out.println(p.getStatement());
		String response = s.next().trim();
		if (p.isCorrect(response)) {
			correct.add(p);
		} else {
			toReview.add(p);
			System.out.println(p.getCorrection(response));
		}
		System.out.println("Number correct: " + correct.size());
	}

	public static void main(String[] args) {
		IFTutor ift = new IFTutor();
		ift.random.setSeed(1L);
		for (int i = 0; i < 10; i++) {
			Problem p = new RandomDoubleArithmeticProblem().generate(ift.random);
			ift.ask(p);
		}
		// recheck the items missed
		while (ift.toReview.size() != 0) {
			Problem missed = ift.toReview.remove(0);
			ift.reviewed.add(missed); // so can retrieve it later, for analysis
			Class<? extends Problem> clazz = missed.getClass();
			try {
				ift.ask(clazz.newInstance().generate(ift.random));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Correct: " + ift.correct.size() + "\tIncorrect: " + ift.reviewed.size());
	}

}
