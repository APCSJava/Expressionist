package collins.kent.tutor;

import java.util.Random;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random(5);
		StringSource.getInstance().setRandom(rand);
		for (int i = 0; i < 5; i++) {
			Problem p = new StringIndexOfProblem();
			p.generate(rand);
			System.out.println(p.getStatement());
			String response = s.nextLine();
			System.out.println(p.getFeedback(response));
		}
		s.close();
	}
}
