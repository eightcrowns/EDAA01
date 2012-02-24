import java.util.Scanner;

import javax.swing.JOptionPane;

public class SquareRoot {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Ange ett tal: ");
		if (s == null) {
			System.exit(0);
		}
		double n = 0;
		try {
			n = Double.valueOf(s);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, " Felaktiga tecken i indata. ", "Kvadratrot",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		double sqrRoot = Math.sqrt(n);
		JOptionPane.showMessageDialog(null, sqrRoot, "Kvadratrot",
				JOptionPane.PLAIN_MESSAGE);
	}
}
