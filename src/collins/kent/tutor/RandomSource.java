package collins.kent.tutor;

public interface RandomSource {

	
	double nextDouble();
	int nextInt();
	int nextInt(int max);
	boolean nextBoolean();
}
