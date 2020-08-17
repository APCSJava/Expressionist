package collins.kent.tutor.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import collins.kent.tutor.IFTutor;
import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;

@Skill(skill="Identify an element in an array by its index")
public class StringArrayAccessByIndexProblem implements Problem {

	String[] zodiac = {"rabbit", "dog", "horse", "ox", "rat", "monkey", "dragon", "tiger", "snake", "goat", "rooster", "pig"};
	List<String> list; 
	String prompt;
	String word;
	int chosen;
	int num;
	boolean causeError;
	
	public Problem generate(Random rng) {
		list = Arrays.asList(zodiac);
		Collections.shuffle(list, rng);
		// choose a manageable three to five animals
		num = 3+rng.nextInt(3);
		causeError = rng.nextBoolean();
		if (causeError) {
			if (rng.nextBoolean()) {
				chosen = -1;
			} else {
				chosen = num;
			}
		} else {
			chosen = rng.nextInt(num);
		}
		prompt = "Given an array of strings initialized as follows:\n\t";
		prompt +="String[] animals = {";
		for ( int i = 0; i<num; i++) {
			prompt+="\""+list.get(i)+"\", ";
		}
		prompt = prompt.substring(0, prompt.length()-2); // remove last comma
		prompt+="};\n";
		prompt +="What is the result of evaluating the following expression?\n\t";
		prompt +="animals["+chosen+"]";
		return this;
	}

	@Override
	public String getStatement() {
		return prompt;
	}

	@Override
	public String getAnswer() {
		if (!causeError) {
			return "\""+list.get(chosen)+"\"";
		} else {
			return IFTutor.getErrorSymbol();
		}
	}
	
	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct";
		} else if (chosen >= 0 && chosen < num ) {
			return "Incorrect.  The correct answer is " + getAnswer();
		} else if (chosen<0 || chosen >= num){
			return "Incorrect.  That expression shown will throw an ArrayIndexOutOfBounds exception.";
		} else return "Incorrect.  The correct answer is " + getAnswer();
	}
}