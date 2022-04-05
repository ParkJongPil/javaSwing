package Project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class CafePay extends JFrame {
	private JTextField totalCount;
	private JTextField totalPrice;
	private String totalPrice1 = null;
	CafeDAO dao = new CafeDAO();
	CafeVO vo = new CafeVO();
	
	String menuName = "";

	public CafePay(String name) {
		super("주문내역");
		setSize(732, 523);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 112, 594, 162);
		getContentPane().add(scrollPane);

		JTextArea orderList = new JTextArea();
		orderList.setFont(new Font("굴림", Font.PLAIN, 17));
		scrollPane.setViewportView(orderList);

		JLabel lblNewLabel = new JLabel("주 문 내 역");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel.setBounds(219, 37, 269, 54);
		getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(92, 284, 515, 92);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("총 주문 개수");
		lblNewLabel_1.setBounds(83, 10, 116, 24);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("총 가격");
		lblNewLabel_2.setBounds(93, 44, 116, 24);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("개");
		lblNewLabel_2_1.setBounds(352, 10, 116, 24);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("원");
		lblNewLabel_2_1_1.setBounds(352, 44, 116, 24);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lblNewLabel_2_1_1);

		totalCount = new JTextField();
		totalCount.setFont(new Font("굴림", Font.PLAIN, 20));
		totalCount.setBounds(211, 14, 96, 21);
		panel.add(totalCount);
		totalCount.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(67, 378, 594, 98);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnPay = new JButton("결 제");
		btnPay.setFont(new Font("굴림", Font.PLAIN, 20));
		btnPay.setBounds(325, 10, 220, 69);
		panel_1.add(btnPay);

		JButton btnNewButton_1_1 = new JButton("이전 화면");
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(53, 10, 220, 69);
		panel_1.add(btnNewButton_1_1);

		setVisible(true);

		/* 아래는 메소드 영역 */

		// CafePay 클래스 생성과 동시에 주문내역 출력
		String[] list = CafeOrder.orderList;
		int cnt = 1;
		menuName = "";
		for (int i = 0; i < CafeOrder.cnt; i++) {
			orderList.append(cnt + "." + list[i] + "\n");
			cnt++;
			menuName += list[i] + "&";

		}
		menuName = menuName.substring(0,menuName.length()-1);
//		System.out.println(menuName);

		// 총 개수 출력
		totalCount.setText(String.valueOf(CafeOrder.cnt));

		totalPrice = new JTextField();
		totalPrice.setText("0");
		totalPrice.setFont(new Font("굴림", Font.PLAIN, 20));
		totalPrice.setColumns(10);
		totalPrice.setBounds(211, 48, 96, 21);
		panel.add(totalPrice);

		// 총 가격 출력
		totalPrice.setText(String.valueOf(CafeOrder.total));

		// 이전 버튼
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 결제 버튼
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String menu = orderList.getText();
				
				int pri = CafeOrder.total;
				vo.setPrice1(pri);
				vo.setMenuName1(menuName);
				vo.setName(name);
				
				dao.CafePay(vo);
				
				JOptionPane.showMessageDialog(null,menu);
				dispose();
				
			}
		});

	}

	public static void main(String[] args) {
		//new CafePay();
	}
}
