import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CheckButton extends SudokuButton {
	public CheckButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super(values, fields, statusLabel, "Check");
	}
	
	/**
	 * Kontrollerar anv�ndarens l�sning av sudokut och anger det
	 * i statusf�ltet
	 */
	public void actionPerformed(ActionEvent e) {
		int[][] s = new int[9][9];
		// L�s in v�rden till ny vektor
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (values[y][x] > 0) { // v�rdet var ifyllt fr�n b�rjan
					s[y][x] = values[y][x]; // kopiera fr�n ursprunglig vektor
				} else {
					// L�s in fr�n textf�lt
					String field = fields[y][x].getText();
					if (field.isEmpty()) {
						s[y][x] = 0; // f�ltet var tomt - s�tt till 0
					} else {
						s[y][x] = Integer.parseInt(field);
					}
				}
			}
		}
		// Kontrollera l�sningen
		Sudoku sudoku = new Sudoku(s);
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (s[y][x] == 0 || !sudoku.check(y, x)) {
					statusLabel.setText("Ogiltig l�sning");
					return; // avbryt s� fort en felaktig ruta hittats
				}
			}
		}
		statusLabel.setText("Godk�nd l�sning");
	}
}
