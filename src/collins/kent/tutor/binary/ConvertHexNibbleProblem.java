package collins.kent.tutor.binary;

import java.util.Random;

import collins.kent.tutor.Problem;

public class ConvertHexNibbleProblem implements Problem {
	
	Problem specificCaseProblem;

	@Override
	public Problem generate(Random rng) {
		specificCaseProblem = rng.nextBoolean()
				? new HexToNibbleProblem().generate(rng)
				: new NibbleToHexProblem().generate(rng);
		return specificCaseProblem;
	}

	@Override
	public String getStatement() {
		// TODO Auto-generated method stub
		return specificCaseProblem.getStatement();
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return specificCaseProblem.getAnswer();
	}

}
