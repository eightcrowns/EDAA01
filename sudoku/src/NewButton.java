import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;


public class NewButton extends JButton implements ActionListener {
	//private Sudoku sudoku;
	private int[][] values;
	private Scanner scanner;
	private JTextField[][] fields;
	
	public NewButton(int[][] values, JTextField[][] fields) {
		super("New");
		this.values = values;
		this.fields = fields;
		addActionListener(this);
		
		try {
			scanner = new Scanner(new File("sudokus"));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open file: sudokus");
			System.exit(1);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		//int[][] s = new int[9][9];
		int y = 0;
		while (scanner.hasNext() && y < 9) {
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			for (int x = 0; x < 9; x++) {
				int num = lineScanner.nextInt();
				values[y][x] = num;
				if (num > 0) {
					fields[y][x].setText(Integer.toString(num));
					fields[y][x].setEditable(false);
				} else { // t�m rutan, s�tt till redigerbar
					fields[y][x].setText("");
					fields[y][x].setEditable(true);
				}
			}
			y++;
		}
		if (scanner.hasNext()) { // finns mer att l�sa fr�n filen
			scanner.nextLine(); // skrota en tomrad
		} else { // �ppna filen p� nytt
			try {
				scanner = new Scanner(new File("sudokus"));
			} catch (FileNotFoundException e1) {
				System.out.println("Couldn't open file: sudokus");
				System.exit(1);
			}
		}
		
		//sudoku = new Sudoku(s);
	}
}
