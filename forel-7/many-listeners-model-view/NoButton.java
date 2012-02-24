import javax.swing.*;
import java.awt.event.*;

public class NoButton extends JButton implements ActionListener {
	private Counters counters;
	private CountersView view;
	
	public NoButton(Counters counters, CountersView view) {
		super("No!");
		this.counters = counters;
		this.view = view;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		counters.incrementNoCount();
		view.updateNoLabel();
	}

}
