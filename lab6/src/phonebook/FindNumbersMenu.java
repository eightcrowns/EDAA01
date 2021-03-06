package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.util.List;

@SuppressWarnings("serial")
public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find number(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Enter name");
		if (name != null && !name.isEmpty()) {
			List<String> numbers = phoneBook.findNumber(name);
			if (!numbers.isEmpty()) {
				gui.addMessage(name + " har f�ljande nummer: " + numbers.toString());
			} else {
				gui.addMessage("Personen " + name + " finns inte i telefonboken.");
			}
		}
	}
}
