package Project;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.awt.event.ActionEvent;

public class CafeHome extends JFrame {

	public CafeHome() {
		super("커피 자판기");
		setSize(614, 617);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 605, 589);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("주문하기");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("굴림체", Font.PLAIN, 30));
		btnNewButton.setBounds(0, 437, 290, 152);
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("종료");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.setFont(new Font("굴림체", Font.PLAIN, 30));
		btnNewButton_2.setBounds(302, 437, 301, 152);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("");
		URL imgUrl = this.getClass().getClassLoader().getResource("c1.png");
		lblNewLabel_2.setIcon(new ImageIcon(imgUrl));

		lblNewLabel_2.setBounds(0, 51, 603, 375);
		panel.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("관리자 계정");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("굴림체", Font.BOLD, 20));
		btnNewButton_1.setBounds(403, 10, 175, 36);
		panel.add(btnNewButton_1);

		setVisible(true);

		/* 아래로 메소드 처리 */

		// 관리자 계정
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CafeLogin();
			}
		});

		// 관리자 계정 엔터키 처리
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				new CafeLogin();
			}
		});

		// 주문하기
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CafeOrder();
			}
		});

		// 주문하기 엔터키 처리
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				new CafeOrder();
			}
		});
		// 종료
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		// 종료하기 엔터키 처리
		btnNewButton_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new CafeHome();
	}
}
