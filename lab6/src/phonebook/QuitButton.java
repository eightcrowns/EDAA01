package phonebook;
import javax.swing.*;

import java.awt.event.*;

public class QuitButton extends JButton implements ActionListener {
	private PhoneBookGUI gui;

	public QuitButton(PhoneBookGUI gui) {
		super("Quit");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.quit();
	}
}
