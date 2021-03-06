package mountain;

import java.util.LinkedList;

import fractal.*;

public class RandomMountain extends Mountain {
	private int dev;
	private LinkedList<Side> sides;

	public RandomMountain(Point p1, Point p2, Point p3, int dev) {
		super(p1, p2, p3);
		this.dev = dev;
		this.sides = new LinkedList<Side>();
	}
	
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, p1, p2, p3);
//		for (Side s : sides) {
//			System.out.println(s.p1 + " " + s.p2 + " " + s.middle);
//		}
	}

	/* 
	 * Recursive method: Draws a recursive line of the triangle. 
	 */
	private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
		if (order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.penDown();
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		} else {
			Point ab, bc, ca;
			Side s = new Side(a, b);
			int abIndex = sides.indexOf(s);
			if (abIndex >= 0) {
				ab = sides.remove(abIndex).getM();
			} else {
				ab = new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2 + RandomUtilities.randFunc(dev / Math.pow(2, order)));
				sides.add(new Side(a, b, ab));
			}
			int bcIndex = sides.indexOf(new Side(b, c));
			if (bcIndex >= 0) {
				bc = sides.remove(bcIndex).getM();
			} else {
				bc = new Point((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2 + RandomUtilities.randFunc(dev / Math.pow(2, order)));
				sides.add(new Side(b, c, bc));
			}
			int caIndex = sides.indexOf(new Side(c, a));
			if (caIndex >= 0) {
				ca = sides.remove(caIndex).getM();
			} else {
				ca = new Point((c.getX() + a.getX()) / 2, (c.getY() + a.getY()) / 2 + RandomUtilities.randFunc(dev / Math.pow(2, order)));
				sides.add(new Side(c, a, ca));
			}
//			System.out.println("Order: " + order + " dev: " + dev / Math.pow(2, order));
			fractalTriangle(turtle, order-1, a, ab, ca);
			fractalTriangle(turtle, order-1, ab, b, bc);
			fractalTriangle(turtle, order-1, bc, c, ca);
			fractalTriangle(turtle, order-1, ab, bc, ca);
		}
	}

	@Override
	public String getTitle() {
		return "Slumpmässig bergfraktal";
	}

}
