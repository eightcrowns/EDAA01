import javax.swing.*;
import java.awt.event.*;

public class YesButton extends JButton implements ActionListener {
	private Counters counters;
	private CountersView view;
	
	public YesButton(Counters counters, CountersView view) {
		super("Yes!");
		this.counters = counters;
		this.view = view;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		counters.incrementYesCount();
		view.updateYesLabel();
	}
}
