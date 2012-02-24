import javax.swing.*;
import java.awt.*;

public class FrameWithBorderLayout {
	
	public FrameWithBorderLayout() {
		JFrame frame = new JFrame("A BorderLayout Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());  // Behövs ej, 
								//Borderlayout ör standard för JFrame
		frame.add(new JButton("Center"), BorderLayout.CENTER);	
		frame.add(new JButton("North"), BorderLayout.NORTH);
		frame.add(new JButton("South"), BorderLayout.SOUTH);
		frame.add(new JButton("East"), BorderLayout.WEST);
		frame.add(new JButton("West"), BorderLayout.EAST);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameWithBorderLayout();
	}

}

