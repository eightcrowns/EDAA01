import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SolveButton extends SudokuButton {
	
	public SolveButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super(values, fields, statusLabel, "Solve");
	}
	
	public void actionPerformed(ActionEvent e) {
		int[][] s = new int[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				s[y][x] = values[y][x];
				System.out.print(s[y][x] + " ");
			}
			System.out.println();
		}
		Sudoku sudoku = new Sudoku(s);
		if (sudoku.solve()) {
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					fields[y][x].setText(Integer.toString(s[y][x]));
				}
			}
			statusLabel.setText("Vars�god!");
		} else {
			statusLabel.setText("Felaktigt sudoku.");
		}
	}
}