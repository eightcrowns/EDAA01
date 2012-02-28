package phonebook;
import javax.swing.*;
import java.awt.event.*;
import java.util.Set;

@SuppressWarnings("serial")
public class ShowAllMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public ShowAllMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show all");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Set<String> names = phoneBook.names();
		if (!names.isEmpty()) {
			gui.addMessage("Alla namn i telefonboken: " + phoneBook.names().toString());
		} else {
			gui.addMessage("Telefonboken är tom.");
		}
	}
}
