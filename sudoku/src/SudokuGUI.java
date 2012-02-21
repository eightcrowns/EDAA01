import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class SudokuGUI {
	public SudokuGUI() {
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel sudokuPanel = new JPanel();
		sudokuPanel.setLayout(new GridLayout(9, 9));
		JTextField fields[][] = new JTextField[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[y][x] = new JTextField(1);
				sudokuPanel.add(fields[y][x]);
			}
		}
		frame.add(sudokuPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		JButton button = new JButton("Yes!");
		buttonPanel.add(button);
		JLabel label = new JLabel("Yescount: " + 0);
		buttonPanel.add(label);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SudokuGUI();
	}
}