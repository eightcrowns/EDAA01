package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.util.List;

@SuppressWarnings("serial")
public class FindNamesMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNamesMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find name(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String number = JOptionPane.showInputDialog("Enter number");
		if (number != null && !number.isEmpty()) {
			List<String> names = phoneBook.findNames(number);
			if (!names.isEmpty()) {
				gui.addMessage(number + " tillhör följande personer: " + names.toString());
			} else {
				gui.addMessage(number + " finns inte i telefonboken.");
			}
		}
	}
}
