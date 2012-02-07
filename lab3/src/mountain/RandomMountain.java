package mountain;

import fractal.*;

public class RandomMountain extends Mountain {
	private int dev;

	public RandomMountain(Point p1, Point p2, Point p3, int dev) {
		super(p1, p2, p3);
		this.dev = dev;
	}
	
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, p1, p2, p3);
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
			Point ab = new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2 + RandomUtilities.randFunc(dev / Math.pow(2, order)));
			Point bc = new Point((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2 + RandomUtilities.randFunc(dev / Math.pow(2, order)));
			Point ca = new Point((c.getX() + a.getX()) / 2, (c.getY() + a.getY()) / 2 + RandomUtilities.randFunc(dev / Math.pow(2, order)));
//			System.out.println("Order: " + order + " dev: " + dev / Math.pow(2, order));
			fractalTriangle(turtle, order-1, a, ab, ca);
			fractalTriangle(turtle, order-1, ab, b, bc);
			fractalTriangle(turtle, order-1, bc, c, ca);
			fractalTriangle(turtle, order-1, ab, bc, ca);
		}
	}

	@Override
	public String getTitle() {
		return "Slumpm�ssig bergfraktal";
	}

}