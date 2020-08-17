package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Problem;

public class RecognizeLiteralValueProblem implements Problem {

	// train students to recognize literal values of the following types:
	// int, double, float, long, char, boolean, and String
	private static final int INT_TYPE = 0;
	private static final int DOUBLE_TYPE = 1;
	private static final int FLOAT_TYPE = 2;
	private static final int LONG_TYPE = 3;
	private static final int CHAR_TYPE = 4;
	private static final int BOOLEAN_TYPE = 5;
	private static final int STRING_TYPE = 6;
	private static final int ERROR_TYPE = 7;

	private static String chars = "aAcC       0123456789-/+%!?*";
	private static String[] strings = { "cat", "dog", "fox", "ant",
			"Bob" };
	private static String operators = "+-*/%!";
	private int selectedType;
	private String displayString;

	@Override
	public Problem generate(Random rng) {
		selectedType = rng.nextInt(ERROR_TYPE + 1);
		displayString = buildLiteralString(rng, selectedType);
		return this;
	}

	private String buildLiteralString(Random r, int n) {
		switch (n) {
		case INT_TYPE:
			return (r.nextBoolean() ? "" : "-") + r.nextInt(100);
		case LONG_TYPE:
			return buildLiteralString(r, INT_TYPE) + "L";
		case DOUBLE_TYPE:
			return (r.nextBoolean() ? "" : "-") + r.nextInt(100)
					+ "." + r.nextInt(100);
		case FLOAT_TYPE:
			return buildLiteralString(r, DOUBLE_TYPE)
					+ (r.nextBoolean() ? "F" : "f");
		case CHAR_TYPE:
			return "'" + chars.charAt(r.nextInt(chars.length()))
					+ "'";
		case BOOLEAN_TYPE:
			// sometimes, confuse "true" for true
			boolean confuse = r.nextDouble() < 0.25;
			if (confuse) {
				String confusion = "\"" + r.nextBoolean() + "\"";
				selectedType = STRING_TYPE;
				return confusion;
			}
			return "" + r.nextBoolean();
		case STRING_TYPE:
			if (r.nextBoolean())
				return "\"" + strings[r.nextInt(strings.length)]
						+ "\"";
			else if (r.nextBoolean())
				return "\"" + chars.charAt(r.nextInt(chars.length()))
						+ "\"";
			else
				return "\"" + buildLiteralString(r, FLOAT_TYPE + 1)
						+ "\"";
		case ERROR_TYPE:
			return "" + operators
					.charAt(r.nextInt(operators.length()));
		}
		return null;
	}

	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		switch (selectedType) {
		case INT_TYPE:
			return "int";
		case DOUBLE_TYPE:
			return "double";
		case LONG_TYPE:
			return "long";
		case FLOAT_TYPE:
			return "float";
		case BOOLEAN_TYPE:
			return "boolean";
		case CHAR_TYPE:
			return "char";
		case STRING_TYPE:
			return "String";
		case ERROR_TYPE:
			return IFTutor.getErrorSymbol();
		}
		return null;
	}

	@Override
	public String getFeedback(String response) {
		if (selectedType==ERROR_TYPE) {
		return "Incorrect.  "+displayString
				+ " is not a value of any type, it is an operator.  The best response is "
				+ getAnswer();
		} else return Problem.super.getFeedback(response);
	}

}
