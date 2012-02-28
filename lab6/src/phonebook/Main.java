package phonebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		int openChoice = JOptionPane.showConfirmDialog(null, "Open existing phonebook from file?");
		if (openChoice == JOptionPane.YES_OPTION) {
			String fileName = JOptionPane.showInputDialog("Enter filename");
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
				PhoneBook phoneBook = (PhoneBook) in.readObject();
				new PhoneBookGUI(phoneBook);
			} catch (FileNotFoundException fnfe) {
				PhoneBookGUI gui = new PhoneBookGUI(new PhoneBook());
				gui.addMessage("File " + fileName + " not found!");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(1);
			}
			// vid no eller cancel görs ingenting (programmet fortsätter med tom telefonbok)
		} else {
			new PhoneBookGUI(new PhoneBook());
		}
	}

}
