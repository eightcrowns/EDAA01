import java.awt.*;
import javax.swing.*;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame("Circle example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Circle c = new Circle(50, 50, 100);
		CirclePanel cp = new CirclePanel(c);
		frame.add(BorderLayout.CENTER, cp);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new MoveButton(cp));
		frame.add(BorderLayout.SOUTH, buttonPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}
}
