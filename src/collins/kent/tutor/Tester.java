package collins.kent.tutor;

import java.util.Random;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random(7);
		for (int i = 0; i < 5; i++) {
			Problem p = new StringSimpleLengthOfSubstringProblem();
			p.generate(r);
			System.out.println(p.getStatement());
			String response = s.nextLine();
			System.out.println(p.getFeedback(response));
		}
		s.close();
	}
}
