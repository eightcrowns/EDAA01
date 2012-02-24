import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
	public DrawingPanel() {  
		setPreferredSize(new Dimension(400, 400));
	}

	/** Paint the component when it changes. This method is called
      by the Swing API.
      @param g The graphics object used for painting. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(10, 10, 200, 200);
		g.setColor(Color.GREEN);
		g.fillOval(50, 100, 200, 200);
	}
}
