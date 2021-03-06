import java.awt.event.ActionEvent;

import javax.swing.*;


public class ClearButton extends SudokuButton {
	public ClearButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super(values, fields, statusLabel, "Clear");
	}
	
	/**
	 * Nollst�ll sudokuvektorn, t�m och �terst�ll alla textf�lt
	 */
	public void actionPerformed(ActionEvent e) {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				values[y][x] = 0;
				fields[y][x].setText("");
				fields[y][x].setEditable(false);
				fields[y][x].setFont(SudokuGUI.boldFont);
			}
		}
		statusLabel.setText("");
	}
}
