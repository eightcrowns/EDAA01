import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;


public class NewButton extends SudokuButton {
	private Scanner scanner;
	
	public NewButton(int[][] values, JTextField[][] fields, JLabel statusLabel) {
		super(values, fields, statusLabel, "New");
		
		try {
			scanner = new Scanner(new File("sudokus"));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open file: sudokus");
			System.exit(1);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
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
				} else { // töm rutan, sätt till redigerbar
					fields[y][x].setText("");
					fields[y][x].setEditable(true);
				}
			}
			y++;
		}
		if (scanner.hasNext()) { // finns mer att läsa från filen
			scanner.nextLine(); // skrota en tomrad
		} else { // öppna filen på nytt
			try {
				scanner = new Scanner(new File("sudokus"));
			} catch (FileNotFoundException e1) {
				System.out.println("Couldn't open file: sudokus");
				System.exit(1);
			}
		}
		statusLabel.setText("");
	}
}
