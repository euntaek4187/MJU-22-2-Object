import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SugangPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SugangPanel() {
		JPanel login = new JPanel();
		login.setLayout(new BorderLayout());
		JLabel label = new JLabel("로그인에 성공하였습니다.");
		label.setForeground(new Color(0, 0, 255));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		this.add(label);
	}

}
