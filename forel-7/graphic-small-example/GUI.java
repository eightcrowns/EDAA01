import java.awt.*;
import javax.swing.*;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame("Graphics Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DrawingPanel());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}
}
