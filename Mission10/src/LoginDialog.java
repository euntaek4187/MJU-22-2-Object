import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField idField;
	private JPasswordField pwField;

	private SLogin sLogin;
	private SugangPanel sugangPanel;

	public LoginDialog(Frame parent) {
		super(parent, "�α���", ModalityType.APPLICATION_MODAL);
		setSize(450, 250);
		setLocationRelativeTo(null);
		// DO_NOTHING_ON_CLOSE => ���̾�α� �� ������
		// DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 3, 0, 0));

		JLabel idLabel = new JLabel("ID : ");
		idLabel.setFont(new Font("���� ���", Font.BOLD, 17));
		panel.add(idLabel);

		idField = new JTextField();
		panel.add(idField);
		idField.setColumns(10);

		JLabel pwLabel = new JLabel("PW : ");
		pwLabel.setFont(new Font("���� ���", Font.BOLD, 17));
		panel.add(pwLabel);

		pwField = new JPasswordField();
		panel.add(pwField);
		pwField.setColumns(10);

		JLabel info = new JLabel("�ʱ� ���̵�/��й�ȣ : 60221320 / 1111 �Դϴ�.");
		panel.add(info);
		info.setFont(new Font("���� ���", Font.BOLD, 13));

		// ��� �߰�
		JPanel leftPanel = new JPanel();
		JLabel leftLabel = new JLabel("                  ");
		leftPanel.add(leftLabel);
		JPanel rigthPanel = new JPanel();
		JLabel rigthLabel = new JLabel("                  ");
		rigthPanel.add(rigthLabel);
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("�α��ο� �����ϱ� ������ â�� ������ �����ϴ�. => Modal");
		titleLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		titlePanel.add(titleLabel);
		JPanel btnPanel = new JPanel();
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("���� ���", Font.BOLD, 20));
		btnPanel.add(loginBtn);

		this.add(leftPanel, BorderLayout.WEST);
		this.add(rigthPanel, BorderLayout.EAST);
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(btnPanel, BorderLayout.SOUTH);

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (NullPointerException e11) {
					JOptionPane.showMessageDialog(null, "���̵�/��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���");
					idField.setText(null);
					pwField.setText(null);
				}

			}

		});

		this.sLogin = new SLogin();
	}

	private void login() {
		String id = this.idField.getText();
		String password = this.pwField.getText();

		VLogin vLogin = sLogin.login(id, password);
		this.sugangPanel = new SugangPanel();
		if (vLogin != null) {
			this.dispose();
		}
	}
}
