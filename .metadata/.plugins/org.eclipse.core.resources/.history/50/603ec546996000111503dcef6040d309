import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ClearButton extends JButton implements ActionListener {
	private Sudoku sudoku;
	private JTextField[][] fields;
	
	public ClearButton(Sudoku sudoku, JTextField[][] fields) {
		super("Clear");
		this.sudoku = sudoku;
		this.fields = fields;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		sudoku = null;
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[y][x].setText("");
				fields[y][x].setEditable(false);
			}
		}
	}
}
