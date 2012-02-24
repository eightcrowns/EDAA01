import javax.swing.*;
import java.awt.*;

public class FrameWithGridLayout {
	
	public FrameWithGridLayout() {
		JFrame frame = new JFrame("A GridLayout Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(2, 3));
		frame.add(new JButton("one"));
		frame.add(new JButton("two"));
		frame.add(new JButton("three"));
		frame.add(new JButton("four"));
		frame.add(new JButton("five"));
		frame.add(new JButton("six"));	
	
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameWithGridLayout();
	}

}

