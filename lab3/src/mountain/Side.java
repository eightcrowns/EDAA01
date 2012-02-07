package mountain;

public class Side {
	private Point p1;
	private Point p2;
	private Point middle;
	
	public Point getM() {
		return middle;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			return p1.equals(((Side) obj).p1) && p2.equals(((Side) obj).p2);
		} else {
			return false;
		}
	}
}
