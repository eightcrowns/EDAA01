import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class SudokuGUI {
	public SudokuGUI() {
		Sudoku s = null;
		int[][] values = new int[9][9];
		
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel sudokuPanel = new JPanel();
		sudokuPanel.setLayout(new GridLayout(9, 9));
		JTextField fields[][] = new JTextField[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[y][x] = new JTextField(1);
				fields[y][x].setEditable(false);
				sudokuPanel.add(fields[y][x]);
			}
		}
		frame.add(sudokuPanel, BorderLayout.CENTER);
		
		JLabel statusLabel = new JLabel();
		statusLabel.setPreferredSize(new Dimension(100, 100));
		
		JPanel buttonPanel = new JPanel();
		NewButton newButton = new NewButton(values, fields);
		buttonPanel.add(newButton);
		ClearButton clearButton = new ClearButton(s, fields);
		buttonPanel.add(clearButton);
		JButton checkButton = new JButton("Check");
		buttonPanel.add(checkButton);
		SolveButton solveButton = new SolveButton(values, fields, statusLabel);
		buttonPanel.add(solveButton);
		
		buttonPanel.add(statusLabel);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SudokuGUI();
	}
}