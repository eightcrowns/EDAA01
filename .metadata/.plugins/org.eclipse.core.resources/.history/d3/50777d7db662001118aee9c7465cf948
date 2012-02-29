import java.awt.event.ActionEvent;
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
		while (scanner.hasNext() && y < 9) { // försök att läsa in 9 rader
			Scanner lineScanner = new Scanner(scanner.nextLine());
			for (int x = 0; x < 9; x++) { // förutsätt att varje rad har 9 heltal separerade med whitespace
				int num = lineScanner.nextInt();
				values[y][x] = num;
				if (num > 0) { // aktuell ruta ska vara ifylld från början
					fields[y][x].setText(Integer.toString(num));
					fields[y][x].setEditable(false);
					fields[y][x].setFont(SudokuGUI.boldFont);
				} else { // töm rutan, sätt till redigerbar
					fields[y][x].setText("");
					fields[y][x].setEditable(true);
					fields[y][x].setFont(SudokuGUI.standardFont);
				}
			}
			y++;
		}
		if (scanner.hasNext()) { // finns mer att läsa från filen
			scanner.nextLine(); // skrota en tomrad
		} else { // öppna filen på nytt för att börja om från början
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
