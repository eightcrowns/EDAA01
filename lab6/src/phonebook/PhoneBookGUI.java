package phonebook;
import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.*;

public class PhoneBookGUI extends JFrame implements WindowListener {
	private PhoneBook phoneBook;
	private JTextArea messageArea;
		
	public PhoneBookGUI(PhoneBook pb) {
		super("PhoneBook");
		phoneBook = pb;
		
		Locale.setDefault(new Locale("en"));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText","Cancel");

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		setLayout(new BorderLayout());
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		JMenu findMenu = new JMenu("Find");
		menubar.add(findMenu);
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		editMenu.add(new AddMenu(phoneBook,this));
		editMenu.add(new RemoveMenu(phoneBook,this));
		findMenu.add(new FindNumbersMenu(phoneBook,this));
		findMenu.add(new FindNamesMenu(phoneBook,this));
		viewMenu.add(new ShowAllMenu(phoneBook,this));
		
		JPanel southPanel = new JPanel();
		messageArea = new JTextArea(4,25);
		messageArea.setEditable(false);
		southPanel.add(new JScrollPane(messageArea));
		QuitButton quitButton = new QuitButton(this);
		southPanel.add(quitButton);
		add(southPanel,BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	public void addMessage(String message) {
		messageArea.append(message);
		messageArea.append("\n");
	}
	
	public void quit() {
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
		// vid cancel g�rs ingenting
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		quit();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
