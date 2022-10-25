import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LoginPanelBTN extends JPanel {

	public LoginPanelBTN() {
		JButton loginBTN = new JButton("LOGIN");
		this.add(loginBTN);
		loginBTN.setPreferredSize(new Dimension(200, 50));
	}
}
