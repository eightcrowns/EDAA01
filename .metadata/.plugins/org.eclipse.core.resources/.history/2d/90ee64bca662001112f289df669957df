package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;


public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int exitChoice = JOptionPane.showConfirmDialog(null, "Save your changes?");
		switch (exitChoice) {
		case JOptionPane.YES_OPTION:
			String fileName = JOptionPane.showInputDialog("Enter filename");
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
				out.writeObject(phoneBook);
				System.exit(0);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(1);
			}
			break;
		case JOptionPane.NO_OPTION:
			System.exit(0);
			break;
		// vid cancel görs ingenting
		}
		
	}
}
