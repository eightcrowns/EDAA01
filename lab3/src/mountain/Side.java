package mountain;

public class Side {
	public Point p1;
	public Point p2;
	public Point middle;
	
	public Side(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Side(Point p1, Point p2, Point m) {
		this.p1 = p1;
		this.p2 = p2;
		middle = m;
	}
	
	public Point getM() {
		return middle;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			return p1.equals(((Side) obj).p1) && p2.equals(((Side) obj).p2) || p1.equals(((Side) obj).p2) && p2.equals(((Side) obj).p1);
		} else {
			return false;
		}
	}
}
