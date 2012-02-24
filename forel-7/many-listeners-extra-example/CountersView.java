import javax.swing.*;

public class CountersView {

	public CountersView(Counters counters)  {
		JFrame frame = new JFrame("Counters");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		
	
		panel.add(new VotePanel(Vote.YES, "Yes!", "YesCount: ", counters));
		panel.add(new VotePanel(Vote.NO, "No!", "NoCount: ", counters));
		panel.add(new VotePanel(Vote.NEUTRAL, "Neutral!","NeutralCount: ", counters));
		
		frame.pack();
		frame.setVisible(true);
	}
}
