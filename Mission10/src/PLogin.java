
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PLogin {

	// 10-12���� ���� �ڵ��Դϴ�.
	private SLogin sLogin;

	public PLogin() {
		this.sLogin = new SLogin();
	}

	public VLogin show() {

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel idLabel = new JLabel("ID : ");
		JTextField idSpace = new JTextField(10);
		JLabel pwLabel = new JLabel("PW : ");
		JPasswordField pwSpace = new JPasswordField(10);
		JButton logBtn = new JButton("Login");
		JLabel logo = new JLabel("�������б� ������û");

		// �α��� ������ ���� ����
		JLabel good = new JLabel("�α��� ����!!!!!!!!!!!");

		panel2.add(good);
		panel2.setVisible(false);

		panel1.setBounds(0, 0, 624, 361);
		panel1.setLayout(null);

		panel1.add(idLabel);
		panel1.add(idSpace);
		panel1.add(pwLabel);
		panel1.add(pwSpace);
		panel1.add(logBtn);
		panel1.add(logo);

		// ��ҵ� ��ġ�� �ؽ�Ʈ, ��Ʈ, �� ����
		good.setFont(new Font("����", Font.BOLD, 40));
		idLabel.setFont(new Font("����", Font.BOLD, 20));
		idLabel.setBounds(181, 148, 73, 24);
		pwLabel.setFont(new Font("����", Font.BOLD, 20));
		pwLabel.setBounds(170, 183, 54, 24);
		logBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		logBtn.setBounds(249, 224, 118, 48);
		idSpace.setBounds(226, 140, 165, 32);
		idSpace.setColumns(10);
		pwSpace.setBounds(226, 182, 165, 32);
		pwSpace.setColumns(10);
		logo.setForeground(new Color(0, 0, 255));
		logo.setFont(new Font("���� ���", Font.BOLD, 35));
		logo.setBounds(146, 37, 341, 98);

		// ��ư ����� ���� �α��� ���ο� ���� ����
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idSpace.getText();
				String passward = pwSpace.getText();
				try {
					VLogin vLogin = sLogin.login(id, passward);

					if (vLogin != null) {
						JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�.");
						panel2.setVisible(true);
						panel1.setVisible(false);
					}
					// return vLogin;

				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "���̵�/��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���");
					idSpace.setText(null);
					pwSpace.setText(null);
					// this.show();
				}

			}

		});

		// ������ ����� ����
		JFrame frame = new JFrame();
		frame.setVisible(true);

		frame.add(panel1);
		frame.add(panel2);
		// ������ ũ�� ����
		frame.setSize(600, 400);
		// �������� Ŭ���Ͽ� ������ �ý��۵� ���� �����ϱ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������ �߾����� ������ �ϱ�
		frame.setLocationRelativeTo(null);
		// ������ ũ�� ���� �Ұ����ϰ� �ϱ�
		frame.setResizable(false);

		return null;

	}
}
