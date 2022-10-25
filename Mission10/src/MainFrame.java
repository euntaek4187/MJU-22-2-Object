import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		// attributes
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		SugangPanel sugangPanel = new SugangPanel();
		this.add(sugangPanel, BorderLayout.NORTH);

		LoginDialog loginPanel = new LoginDialog(this);
		loginPanel.setVisible(true);
	}
}
