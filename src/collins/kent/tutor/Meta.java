package collins.kent.tutor;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Meta {
	String skill(); // short description of skill being developed
	int prefRatio() default 0; // preferred ratio for problems of this class
}
