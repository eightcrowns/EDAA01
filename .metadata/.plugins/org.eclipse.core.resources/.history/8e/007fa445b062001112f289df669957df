import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CheckButton extends SudokuButton {
	
	public CheckButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super(values, fields, statusLabel, "Check");
	}
	
	public void actionPerformed(ActionEvent e) {
		int[][] s = new int[9][9];
		// Läs in värden från textfälten
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (values[y][x] > 0) {
					s[y][x] = values[y][x];
				} else {
					String field = fields[y][x].getText();
					if (field.isEmpty()) {
						s[y][x] = 0;
					} else {
						s[y][x] = Integer.parseInt(field);
					}
				}
			}
		}
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				System.out.print(s[y][x] + " ");
			}
			System.out.println();
		}
		// Kontrollera lösningen
		Sudoku sudoku = new Sudoku(s);
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (s[y][x] == 0 || !sudoku.check(y, x)) {
					statusLabel.setText("Ogiltig lösning.");
					return;
				}
			}
		}
		statusLabel.setText("Godkänd lösning");
	}
}
