import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
	Circle c; 

	public CirclePanel(Circle c) {
		super();
		setPreferredSize(new Dimension(400, 200));
		this.c = c;
	} 

	public void moveButtonPressed() {
		c.move(10, 10);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillOval(c.getX(),c.getY(),c.getRadius(),c.getRadius());
	}
}
