package collins.kent.tutor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * Operations that may be performed on values in the Expressionator.
 * 
 * @author k. collins
 *
 */
public enum Operator {

	ADD, SUB, MULT, DIV, MOD, AND, OR, LT, LTE, GT, GTE, NOT_EQUAL, EQUAL, ASSIGN, ADD_ASSIGN, DIV_ASSIGN, MULT_ASSIGN, SUB_ASSIGN,
	MOD_ASSIGN;

	public static final List<Operator> LOGICAL = Arrays.asList(new Operator[] { AND, OR });
	public static final List<Operator> ARITHMETIC = Arrays.asList(new Operator[] { ADD, SUB, MULT, DIV, MOD });
	public static final List<Operator> COMPOUND = Arrays
			.asList(new Operator[] { ADD_ASSIGN, DIV_ASSIGN, MULT_ASSIGN, SUB_ASSIGN, MOD_ASSIGN });
	public static final List<Operator> COMPARISON = Arrays.asList(new Operator[] { LT, LTE, GT, GTE, NOT_EQUAL, EQUAL });
	
	static String symbol(Operator op) {
		switch (op) {
		case ADD:
			return "+";
		case SUB:
			return "-";
		case MULT:
			return "*";
		case DIV:
			return "/";
		case MOD:
			return "%";
		case AND:
			return "&&";
		case OR:
			return "||";
		case LT:
			return "<";
		case LTE:
			return "<=";
		case GT:
			return ">";
		case GTE:
			return ">=";
		case NOT_EQUAL:
			return "!=";
		case EQUAL:
			return "==";
		case ASSIGN:
			return "=";
		case ADD_ASSIGN:
			return "+=";
		case SUB_ASSIGN:
			return "-=";
		case MULT_ASSIGN:
			return "*=";
		case DIV_ASSIGN:
			return "/=";
		case MOD_ASSIGN:
			return "%=";
		default:
			return "NO SIGN FOUND";
		}
	}

}
