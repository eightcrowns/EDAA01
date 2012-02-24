import javax.swing.*;

public class MinimalExample {

	public MinimalExample() {
		JFrame frame = new JFrame("Ett litet exempel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("En etikett");
		frame.add(label);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MinimalExample();
	}

}
