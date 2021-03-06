import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class SudokuButton extends JButton implements ActionListener {
	protected int[][] values;
	protected JTextField[][] fields;
	protected JLabel statusLabel;
	
	/**
	 * Abstrakt klass som representerar knapparna i användargränssnittet
	 * @param values sudokumatrisen
	 * @param fields textfälten
	 * @param statusLabel statusfältet
	 * @param name knappens namn
	 */
	public SudokuButton(int[][] values, JTextField[][] fields, JLabel statusLabel, String name) {
		super(name);
		this.values = values;
		this.fields = fields;
		this.statusLabel = statusLabel;
		addActionListener(this);
	}
}
