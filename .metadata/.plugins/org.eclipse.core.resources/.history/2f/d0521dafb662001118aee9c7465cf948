import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class SudokuButton extends JButton implements ActionListener {
	protected int[][] values;
	protected JTextField[][] fields;
	protected JLabel statusLabel;
	
	public SudokuButton(int[][] values, JTextField[][] fields, JLabel statusLabel, String name) {
		super(name);
		this.values = values;
		this.fields = fields;
		this.statusLabel = statusLabel;
		addActionListener(this);
	}
}
