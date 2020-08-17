package collins.kent.tutor;

import java.lang.annotation.Annotation;

/***
 * Inteface for the root of all problems.
 * 
 * @author k. collins
 */

public interface Problem {

	Problem generate(java.util.Random rng);

	String getStatement();

	String getAnswer();
	
	default boolean isCorrect(String response) {
		return getAnswer().equals(response);
	}

	default String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct";
		}
		return "Incorrect.  The correct answer is " + getAnswer();
	}
	
	// if our class is annotated with @Skill, return the skill string
	default String getSkill() {
		Class<? extends Problem> theClass = this.getClass();
		Annotation a = theClass.getAnnotation(Skill.class);
		if (a instanceof Skill) {
			return ((Skill) a).skill();
		}
		return "Skill not identified";
	}
}
