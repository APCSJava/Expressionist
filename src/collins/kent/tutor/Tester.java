package collins.kent.tutor;

import java.util.Random;
import java.util.Scanner;

import collins.kent.tutor.string.StringIndexOfProblem;


public class Tester {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			Problem p = new StringIndexOfProblem();
			p.generate(r);
			System.out.println(p.getStatement());
			String response = s.nextLine();
			if (!p.isCorrect(response)) {
				System.out.println(p.getFeedback(response));
			}
		}
		s.close();
	}
}
