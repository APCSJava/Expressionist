package collins.kent.tutor.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Skill;
@Skill(skill="Identify the index of an element in an array")
public class DetermineCorrectIndexProblem implements Problem {
	
	String[] zodiac = {"rabbit", "dog", "horse", "ox", "rat", "monkey", "dragon", "tiger", "snake", "goat", "rooster", "pig"};
	List<String> list; 
	String[] arrayNames = {"animals", "zodiac", "arr", "theArray", "a"};
	String selectedName;
	int nameIndex;
	String prompt;
	String word;
	int chosen;
	int num;
	boolean causeError;
	
	@Override
	public Problem generate(Random rng) {
		list = Arrays.asList(zodiac);
		Collections.shuffle(list, rng);
		// use three to five elements
		num = rng.nextInt(3)+ 3;
		chosen = rng.nextInt(num);
		word = list.get(chosen);
		nameIndex = rng.nextInt(arrayNames.length);
		selectedName = arrayNames[nameIndex];
		prompt = "Given an array of strings initialized as follows:\n\t";
		prompt +="String[] "+selectedName+" = {";
		for ( int i = 0; i<num; i++) {
			prompt+="\""+list.get(i)+"\", ";
		}
		prompt = prompt.substring(0, prompt.length()-2); // remove last comma
		prompt+="};\n";
		prompt +="What expression would access the element \""+word+"\"?";
		return this;
	}

	@Override
	public String getStatement() {
		return prompt;
	}

	@Override
	public String getAnswer() {
		return selectedName+"["+chosen+"]";
	}
	
	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct";
		} else return "Incorrect.  The required expression is " + getAnswer();
	}

}
