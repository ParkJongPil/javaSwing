package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class CafeLogin extends JFrame {
	private JTextField txtId;
	private JPasswordField txtPwd;

	public CafeLogin() {
		super("관리자 계정");
		setSize(597, 414);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 595, 391);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("관리자 계정");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(145, 57, 271, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 40));
		panel.add(lblNewLabel);

		JButton btnLogin = new JButton("로그인");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(145, 277, 126, 71);
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btnLogin);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림체", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(164, 158, 69, 24);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setFont(new Font("굴림체", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(145, 222, 88, 24);
		panel.add(lblNewLabel_1_1);

		txtId = new JTextField();
		txtId.setFont(new Font("굴림체", Font.PLAIN, 20));
		txtId.setBounds(245, 158, 171, 24);
		panel.add(txtId);
		txtId.setColumns(10);

		JButton btnExit = new JButton("종료");
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("굴림", Font.PLAIN, 20));
		btnExit.setBounds(290, 277, 126, 71);
		panel.add(btnExit);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("굴림체", Font.PLAIN, 20));
		txtPwd.setBounds(245, 222, 169, 25);
		panel.add(txtPwd);
		
		JLabel lblNewLabel_2 = new JLabel("");
		URL imgUrl = this.getClass().getClassLoader().getResource("c2_bg.jpg");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\images\\c2_bg.jpg"));
		lblNewLabel_2.setIcon(new ImageIcon(imgUrl));
		//lblNewLabel_2.setBackground(Color.ORANGE);
		lblNewLabel_2.setBounds(0, -21, 642, 425);
		panel.add(lblNewLabel_2);
		
//		JLabel lblNewLabel_2 = new JLabel("");
//		URL imgUrl = this.getClass().getClassLoader().getResource("c1.png");
//		lblNewLabel_2.setIcon(new ImageIcon(imgUrl));

		setVisible(true);

		/* 아래로 메소드 처리부 */

		// 로그인
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "root";
				String pwd = "1234";

				if (id.equals(txtId.getText()) && pwd.equals(txtPwd.getText())) {
					JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
					new CafeOrderList();
					dispose();
				} else if(!id.equals(txtId.getText())) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다");
					txtId.setText("");
					txtPwd.setText("");
					txtId.requestFocus();
				} else if(!pwd.equals(txtPwd.getText())) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 패스워드입니다.");
					txtId.setText("");
					txtPwd.setText("");
					txtPwd.requestFocus();
				} else 
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
			}
		});
		
		// 로그인 버튼 엔터처리
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String id = "root";
					String pwd = "1234";

					if (id.equals(txtId.getText()) && pwd.equals(txtPwd.getText())) {
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
						new CafeOrderList();
						dispose();
					} else if(!id.equals(txtId.getText())) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다");
						txtId.setText("");
						txtPwd.setText("");
						txtId.requestFocus();
					} else if(!pwd.equals(txtPwd.getText())) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 패스워드입니다.");
						txtId.setText("");
						txtPwd.setText("");
						txtPwd.requestFocus();
					} else 
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
				}
			}
		});
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		// 종료버튼 엔터키 처리
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		//new CafeLogin();
	}
}
