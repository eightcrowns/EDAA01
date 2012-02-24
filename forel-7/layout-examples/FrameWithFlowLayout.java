import javax.swing.*;
import java.awt.*;

public class FrameWithFlowLayout {
	
	public FrameWithFlowLayout() {
		JFrame frame = new JFrame("A FlowLayout Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.add(new JButton("one"));
		frame.add(new JButton("two"));
		frame.add(new JButton("three"));
		frame.add(new JButton("four"));
		frame.add(new JButton("five"));
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameWithFlowLayout();
	}

}

