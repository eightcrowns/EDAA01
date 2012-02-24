import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MoveButton extends JButton implements ActionListener {
	CirclePanel cp;

	public MoveButton(CirclePanel cp) {
 		super("move");
 		this.cp = cp;
  		addActionListener(this);
	 }
	
	 public void actionPerformed(ActionEvent e) {
 		cp.moveButtonPressed();
 	}
}
