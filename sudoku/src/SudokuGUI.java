import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.*;

public class SudokuGUI {
	public static final Font standardFont = new Font(null, Font.PLAIN, 28);
	public static final Font boldFont = new Font(null, Font.BOLD, 28);
	
	/**
	 * Grafiskt anv�ndagr�nssnitt i sudokuprogrammet
	 */
	public SudokuGUI() {
		int[][] values = new int[9][9];
		
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel sudokuPanel = new JPanel();
		sudokuPanel.setLayout(new GridLayout(9, 9));
		JTextField fields[][] = new JTextField[9][9];
		
		// Skapa f�rger som anv�nds som bakgrunder i textf�lten
		Color r�sa = new Color(251, 174, 210);
		Color plum = new Color(221, 160, 221);
		
		// Skapa ett NumberFormat-objekt som anv�nds f�r att tvinga textf�lten att
		// endast till�ta ett heltal
		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumIntegerDigits(1);
		f.setMinimumIntegerDigits(0);
		
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[y][x] = new JFormattedTextField(f);
				fields[y][x].setEditable(false);
				fields[y][x].setFont(standardFont);
				
				if (y < 3 && (x < 3 || x >= 6) || y >= 3 && y < 6 && x >= 3 && x < 6 || y >= 6 && (x < 3 || x >= 6)) {
					fields[y][x].setBackground(r�sa);
				} else {
					fields[y][x].setBackground(plum);
				}
				
				sudokuPanel.add(fields[y][x]);
			}
		}
		frame.add(sudokuPanel, BorderLayout.CENTER);
		
		/*
		 * Dialogrutorna �r ersatta av ett statusf�lt eftersom vi anser att det f�rb�ttrar anv�ndargr�nssnittet.
		 * Och f�r att vi tycker att det �r snyggt!
		 */
		JLabel statusLabel = new JLabel();
		statusLabel.setPreferredSize(new Dimension(130, 20)); // st�ll in statusf�ltets storlek
		
		JPanel buttonPanel = new JPanel();
		NewButton newButton = new NewButton(values, fields, statusLabel);
		buttonPanel.add(newButton);
		ClearButton clearButton = new ClearButton(values, fields, statusLabel);
		buttonPanel.add(clearButton);
		CheckButton checkButton = new CheckButton(values, fields, statusLabel);
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