import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SolveButton extends JButton implements ActionListener {
	//private Sudoku sudoku;
	private int[][] values;
	private JTextField[][] fields;
	private JLabel statusLabel;
	
	public SolveButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super("Solve");
		//this.sudoku = sudoku;
		this.values = values;
		this.fields = fields;
		this.statusLabel = statusLabel;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		/*int[][] s = new int[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				String field = fields[y][x].getText();
				if (field.isEmpty()) {
					s[y][x] = 0;
				} else {
					s[y][x] = Integer.parseInt(field);
				}
			}
		}*/
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				System.out.print(values[y][x] + " ");
			}
			System.out.println();
		}
		Sudoku sudoku = new Sudoku(values);
		//if (sudoku != null) {
			if (sudoku.solve()) {
				int[][] s = sudoku.getValues();
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
