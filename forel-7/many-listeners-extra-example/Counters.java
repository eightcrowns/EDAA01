
public class Counters {
	private int yesCount;
	private int noCount;
	private int neutralCount;
	
	public Counters() {
		yesCount = 0;
		noCount = 0;
		neutralCount = 0;
	}
	
	public void incrementCount(Vote vote) {
		switch (vote) {
		case YES:
			yesCount++;
			break;
		case NO:
			noCount++;
			break;
		case NEUTRAL:
			neutralCount++;
			break;
		}
	}
	
	
	public int getCount(Vote vote) {
		int count = 0;
		switch (vote) {
		case YES:
			count = yesCount;
			break;
		case NO:
			count = noCount;
			break;
		case NEUTRAL:
			count = neutralCount;
			break;
		}
		return count;
	}
}
