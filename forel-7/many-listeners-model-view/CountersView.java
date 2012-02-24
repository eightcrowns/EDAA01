import javax.swing.*;
import java.awt.*;

public class CountersView {
	private Counters counters;
	private JLabel yesLabel, noLabel;

	public CountersView(Counters counters)  {
		this.counters = counters;
		JFrame frame = new JFrame("Counters");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel yesPanel = new JPanel();
		frame.add(yesPanel, BorderLayout.NORTH);
		YesButton yesButton = new YesButton(counters, this);
		yesPanel.add(yesButton);
		yesLabel = new JLabel();
		updateYesLabel();
		yesPanel.add(yesLabel);
		
		JPanel noPanel = new JPanel();
		frame.add(noPanel, BorderLayout.SOUTH);
		NoButton noButton = new NoButton(counters, this);
		noPanel.add(noButton);
		noLabel = new JLabel();
		updateNoLabel();
		noPanel.add(noLabel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void updateYesLabel() {
		yesLabel.setText("Yescount: " + counters.getYesCount());
	}
	
	public void updateNoLabel() {
		noLabel.setText("Nocount: " + counters.getNoCount());
	}
}
