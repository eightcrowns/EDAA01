import java.awt.event.ActionEvent;

import javax.swing.*;


public class SolveButton extends SudokuButton {
	public SolveButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super(values, fields, statusLabel, "Solve");
	}
	
	public void actionPerformed(ActionEvent e) {
		int[][] s = new int[9][9];
		// Kopiera de rutor som var ifyllda från början till ny vektor
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				s[y][x] = values[y][x];
			}
		}
		Sudoku sudoku = new Sudoku(s);
		if (sudoku.solve()) { // försök att lösa sudokut
			// Skriv ut lösningen i textfälten
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					fields[y][x].setText(Integer.toString(s[y][x]));
				}
			}
			statusLabel.setText("Varsågod!");
		} else { // ingen lösning fanns
			statusLabel.setText("Felaktigt sudoku");
		}
	}
}
