
public class Counters {
	private int yesCount;
	private int noCount;
	
	public Counters() {
		yesCount = 0;
		noCount = 0;
	}
	
	public void incrementYesCount() {
		yesCount++;
	}
	
	public void incrementNoCount() {
		noCount++;
	}
	
	public int getYesCount() {
		return yesCount;
	}
	
	public int getNoCount() {
		return noCount;
	}	
}
