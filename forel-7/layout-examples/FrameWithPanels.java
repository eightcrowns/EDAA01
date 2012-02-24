import javax.swing.*;

import java.awt.*;

public class FrameWithPanels {
	
	public FrameWithPanels() {
		JFrame frame = new JFrame("A Frame with Two Panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel northPanel = new JPanel();
		northPanel.add(new JButton("one"));
		northPanel.add(new JButton("two"));
		frame.add(northPanel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel();
		southPanel.add(new JButton("three"));
		southPanel.add(new JButton("four"));
		southPanel.add(new JButton("five"));
		frame.add(southPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameWithPanels();
	}

}

