package collins.kent.tutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
    ArrayList<Problem> missed = new ArrayList<>();
    ArrayList<String> missedResponses = new ArrayList<>();

    Random random = new Random(); // central source for random numbers

    public void ask(Problem p) {
        System.out.println(p.getStatement());
        String response = scanner.next().trim();
        boolean isCorrect = p.isCorrect(response);
        if (isCorrect) {
            correct.add(p);
//            System.out.println(
//                    "Yes.  " + correct.size() + " correct.");
        } else {
//			addToReview(p, random);
            missed.add(p);
            missedResponses.add(response);
//            System.out.println("*****  INCORRECT  *****\t"
//                    + p.getFeedback(response));
        }
    }

    public static void main(String[] args) {
        IFTutor tutor = new IFTutor();
        // tutor.random.setSeed(1L);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine().trim();
        System.out.println("How many questions?");
        int numQuestions = scanner.nextInt();
        System.out.println("Today's assessment will have " + numQuestions + " random string questions.");

        LocalDateTime startTime = LocalDateTime.now();

        for (int i = 0; i < numQuestions; i++) {
            Problem p = new RandomStringProblem();
            p.generate(tutor.random);
            tutor.ask(p);
        }
        // recheck the items missed
//		while (tutor.toReview.size() != 0) {
//			Problem missed = tutor.toReview.remove(0);
//			tutor.reviewed.add(missed); // so can retrieve it later, for
//										// analysis
//			tutor.ask(missed);
//
//		}
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(name + "\n"
                + "Questions answered: "+(numQuestions) +"\n"
                + "Start time: "+startTime + "\n"
                + "Finish time: "+endTime + "\n"
                + "Number correct: " + tutor.correct.size()+"\n"
                + "Number incorrect: "+ tutor.missed.size());
        System.out.println("Missed Problems:");
        for (int i = 0; i < tutor.missed.size(); i++) {
            System.out.println(tutor.missed.get(i).getStatement()+"  you missed with a response of "+tutor.missedResponses.get(i));
        }
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
