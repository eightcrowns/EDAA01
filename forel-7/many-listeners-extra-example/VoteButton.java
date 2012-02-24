import javax.swing.*;
import java.awt.event.*;

public class VoteButton extends JButton implements ActionListener {
	private Vote vote;
	private Counters counters;
	private VotePanel panel;
	
	public VoteButton(Vote vote, String text, Counters counters, VotePanel panel) {
		super(text);
		this.vote = vote;
		this.counters = counters;
		this.panel = panel;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		counters.incrementCount(vote);
		panel.updateLabel();
	}
}
