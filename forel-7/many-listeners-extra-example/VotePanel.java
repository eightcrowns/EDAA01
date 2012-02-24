import javax.swing.JLabel;
import javax.swing.JPanel;

public class VotePanel extends JPanel  {
	private Vote vote;
	private String labelTextPrefix;
	private Counters counters;
	private JLabel label;
	
	public VotePanel(Vote vote, String buttonText, String labelTextPrefix, Counters counters) {
		this.vote = vote;
		this.labelTextPrefix = labelTextPrefix;
		this.counters = counters;
		VoteButton button = new VoteButton(vote, buttonText, counters, this);
		add(button);
		label = new JLabel();
		updateLabel();
		add(label);
	}

	public void updateLabel() {
		label.setText(labelTextPrefix + counters.getCount(vote));
	}
}
