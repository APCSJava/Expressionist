package collins.kent.tutor;

import collins.kent.tutor.arithmetic.*;
import collins.kent.tutor.casting.CastDoubleDividendToIntProblem;
import collins.kent.tutor.casting.CastIntDividendToDoubleProblem;
import collins.kent.tutor.literals.*;
import collins.kent.tutor.relational.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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

    public static void main(String[] args) {
        TestGenerator tutor = new TestGenerator();
        // tutor.random.setSeed(1L);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine().trim();

        for (int i = 0; i < 3; i++) {
            tutor.toAsk.add(new DoubleAdditionProblem().generate(tutor.random));
            tutor.toAsk.add(new DoubleDivisionProblem().generate(tutor.random));
            tutor.toAsk.add(new DoubleMultiplicationProblem().generate(tutor.random));
            tutor.toAsk.add(new DoubleSubtractionProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerAdditionProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerDivisionByZeroProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerDivisionProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerModuloProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerModuloZeroProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerMultiplicationProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerSubtractionProblem().generate(tutor.random));
            tutor.toAsk.add(new MixedTypeArithmeticProblem().generate(tutor.random));
            tutor.toAsk.add(new CastDoubleDividendToIntProblem().generate(tutor.random));
            tutor.toAsk.add(new CastIntDividendToDoubleProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaOperatorNotLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaStringNotBooleanProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaStringNotCharProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaStringNotNumericProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaVariableNotLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeBooleanLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeCharLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeDoubleLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeFloatLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeIntLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeLongLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new RecognizeStringLiteralProblem().generate(tutor.random));
            tutor.toAsk.add(new IntegerComparisonProblem().generate(tutor.random));
            tutor.toAsk.add(new DoubleComparisonProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaAssignVersusCompareProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaDoubleEqualityCheckProblem().generate(tutor.random));
            tutor.toAsk.add(new GotchaIntegerComparisonProblem().generate(tutor.random));
        }
        // seven more - focus on the gotchas
        tutor.toAsk.add(new GotchaAssignVersusCompareProblem().generate(tutor.random));
        tutor.toAsk.add(new GotchaIntegerComparisonProblem().generate(tutor.random));
        tutor.toAsk.add(new GotchaOperatorNotLiteralProblem().generate(tutor.random));
        tutor.toAsk.add(new GotchaStringNotBooleanProblem().generate(tutor.random));
        tutor.toAsk.add(new GotchaStringNotCharProblem().generate(tutor.random));
        tutor.toAsk.add(new GotchaStringNotNumericProblem().generate(tutor.random));
        tutor.toAsk.add(new GotchaVariableNotLiteralProblem().generate(tutor.random));

        Collections.shuffle(tutor.toAsk);

        System.out.println(tutor.toAsk.size() + " questions await.  Give the correct answer or 'e' (without quotes) in situations where an error is present or that would benefit from an explanation.");
        for (int i = 0; i < tutor.toAsk.size(); i++) {
            System.out.println("Question " + (i + 1) + ".");
            tutor.ask(tutor.toAsk.get(i));
        }
        System.out.println(name + " completed the assessment at "
                + LocalDateTime.now() + ".\n" + "Number Missed: "
                + (tutor.numMissed) + " out of " + tutor.toAsk.size());
        if (tutor.numMissed > 0) {
            System.out.println("Missed question types: ");
            for (Problem p : tutor.toReview) {
                System.out.println("\t" + p.getClass().getSimpleName());
            }
        }
    }

    public static String getExceptionSymbol() {
        return "e";
    }

    public static String getErrorSymbol() {
        return "e";
    }

    public void ask(Problem p) {
        System.out.println(p.getStatement());
        String response = scanner.next().trim();
        boolean isCorrect = p.isCorrect(response);
        if (isCorrect) {
            System.out.println("Correct\n");
        } else {
            System.out.println("*****  INCORRECT  *****\t"
                    + p.getFeedback(response) + "\n");
            numMissed++;
            toReview.add(p);
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

}
