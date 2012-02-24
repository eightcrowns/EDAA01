import javax.swing.*;
import java.awt.event.*;

public class Counter implements ActionListener {
	private int yesCount;
	private JLabel label;
	
	public Counter()  {
		yesCount = 0;
		JFrame frame = new JFrame("Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton button = new JButton("Yes!");
		panel.add(button);
		button.addActionListener(this);
		
		label = new JLabel("Yescount: " + yesCount);	
		panel.add(label);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		yesCount++;
		label.setText("Yescount: " + yesCount);
	}
	
	public static void main(String[] args) {
		new Counter();
	}
}

