
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

	// 10-12일자 과제 코드입니다.
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
		JLabel logo = new JLabel("명지대학교 수강신청");

		// 로그인 됬을때 나올 문구
		JLabel good = new JLabel("로그인 성공!!!!!!!!!!!");

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

		// 요소들 위치와 텍스트, 폰트, 색 설정
		good.setFont(new Font("굴림", Font.BOLD, 40));
		idLabel.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel.setBounds(181, 148, 73, 24);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel.setBounds(170, 183, 54, 24);
		logBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		logBtn.setBounds(249, 224, 118, 48);
		idSpace.setBounds(226, 140, 165, 32);
		idSpace.setColumns(10);
		pwSpace.setBounds(226, 182, 165, 32);
		pwSpace.setColumns(10);
		logo.setForeground(new Color(0, 0, 255));
		logo.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		logo.setBounds(146, 37, 341, 98);

		// 버튼 기능을 통해 로그인 여부에 따른 설정
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idSpace.getText();
				String passward = pwSpace.getText();
				try {
					VLogin vLogin = sLogin.login(id, passward);

					if (vLogin != null) {
						JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
						panel2.setVisible(true);
						panel1.setVisible(false);
					}
					// return vLogin;

				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "아이디/비밀번호가 틀렸습니다. 다시 입력하세요");
					idSpace.setText(null);
					pwSpace.setText(null);
					// this.show();
				}

			}

		});

		// 프레임 만들고 띄우기
		JFrame frame = new JFrame();
		frame.setVisible(true);

		frame.add(panel1);
		frame.add(panel2);
		// 프레임 크기 조절
		frame.setSize(600, 400);
		// 프레임을 클릭하여 껐을때 시스템도 같이 종료하기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 프레임 중앙으로 나오게 하기
		frame.setLocationRelativeTo(null);
		// 프레임 크기 조절 불가능하게 하기
		frame.setResizable(false);

		return null;

	}
}
