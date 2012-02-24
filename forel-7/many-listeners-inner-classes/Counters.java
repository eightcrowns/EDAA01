import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Counters {
	private int yesCount, noCount;
	private JLabel yesLabel, noLabel;
	
	public Counters()  {
		yesCount = noCount = 0;
		
		JFrame frame = new JFrame("Counters");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel yesPanel = new JPanel();
		frame.add(yesPanel, BorderLayout.NORTH);
		JButton yesButton = new JButton("Yes!");
		yesPanel.add(yesButton);
		yesButton.addActionListener(new YesButtonListener());
		yesLabel = new JLabel("Yescount: " + yesCount);	
		yesPanel.add(yesLabel);
		
		JPanel noPanel = new JPanel();
		frame.add(noPanel, BorderLayout.SOUTH);
		JButton noButton = new JButton("No!");
		noPanel.add(noButton);
		noButton.addActionListener(new NoButtonListener());
		noLabel = new JLabel("Nocount: " + noCount);	
		noPanel.add(noLabel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	class YesButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			yesCount++;
			yesLabel.setText("Yescount: " + yesCount);
		}
	}
	
	class NoButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noCount++;
			noLabel.setText("Nocount: " + noCount);
		}
	}
	
	public static void main(String[] args) {
		new Counters();
	}
}

