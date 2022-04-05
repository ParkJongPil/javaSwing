package Project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class CafeOrder extends JFrame {

	public static String[] orderList;
	public static int cnt;
	public static int total;
	public JLabel lblImage;
	public URL imgUrl;
	public String name = "";
	public JComboBox comboBarista;

	CafeDAO dao = new CafeDAO();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public CafeOrder() {
		super("카페 메인");
		setSize(1265, 810);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1251, 784);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("주문하기(Order)");
		lblNewLabel.setBounds(529, 32, 285, 82);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("커피(Coffee)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(69, 145, 130, 28);
		panel.add(lblNewLabel_1);

		JCheckBox m1 = new JCheckBox("아메리카노 (Hot/ Ice) 3,000");
		m1.setBackground(Color.LIGHT_GRAY);
		m1.setHorizontalAlignment(SwingConstants.LEFT);
		m1.setFont(new Font("굴림", Font.PLAIN, 16));
		m1.setBounds(69, 179, 292, 28);
		panel.add(m1);

		JCheckBox m2 = new JCheckBox("콜드브루 아메리카노(Hot/ Ice) 3,000");
		m2.setBackground(Color.LIGHT_GRAY);
		m2.setHorizontalAlignment(SwingConstants.LEFT);
		m2.setFont(new Font("굴림", Font.PLAIN, 16));
		m2.setBounds(69, 225, 308, 28);
		panel.add(m2);

		JCheckBox m3 = new JCheckBox("카페라떼 (Hot/ Ice) 3,000");
		m3.setBackground(Color.LIGHT_GRAY);
		m3.setHorizontalAlignment(SwingConstants.LEFT);
		m3.setFont(new Font("굴림", Font.PLAIN, 16));
		m3.setBounds(69, 268, 229, 28);
		panel.add(m3);

		JCheckBox m4 = new JCheckBox("콜드브루 라떼 (Hot/ Ice) 3,000");
		m4.setBackground(Color.LIGHT_GRAY);
		m4.setHorizontalAlignment(SwingConstants.LEFT);
		m4.setFont(new Font("굴림", Font.PLAIN, 16));
		m4.setBounds(69, 313, 277, 28);
		panel.add(m4);

		JCheckBox m5 = new JCheckBox("바닐라라떼 (Hot/ Ice) 3,000");
		m5.setBackground(Color.LIGHT_GRAY);
		m5.setHorizontalAlignment(SwingConstants.LEFT);
		m5.setFont(new Font("굴림", Font.PLAIN, 16));
		m5.setBounds(69, 362, 251, 28);
		panel.add(m5);

		JCheckBox m6 = new JCheckBox("카라멜 마끼아또 (Hot/ Ice) 3,000");
		m6.setBackground(Color.LIGHT_GRAY);
		m6.setHorizontalAlignment(SwingConstants.LEFT);
		m6.setFont(new Font("굴림", Font.PLAIN, 16));
		m6.setBounds(69, 413, 292, 28);
		panel.add(m6);

		JLabel lblNewLabel_1_1 = new JLabel(" 라떼(Latte)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(381, 145, 130, 28);
		panel.add(lblNewLabel_1_1);

		JCheckBox m9 = new JCheckBox("녹차라떼 (Hot/ Ice) 3,000");
		m9.setBackground(Color.LIGHT_GRAY);
		m9.setHorizontalAlignment(SwingConstants.LEFT);
		m9.setFont(new Font("굴림", Font.PLAIN, 16));
		m9.setBounds(381, 184, 236, 28);
		panel.add(m9);

		JCheckBox m10 = new JCheckBox("카라멜 초코라떼 (Hot/ Ice) 3,000");
		m10.setBackground(Color.LIGHT_GRAY);
		m10.setHorizontalAlignment(SwingConstants.LEFT);
		m10.setFont(new Font("굴림", Font.PLAIN, 16));
		m10.setBounds(381, 225, 292, 28);
		panel.add(m10);

		JCheckBox m11 = new JCheckBox("토피넛 라떼 (Hot/ Ice) 3,000");
		m11.setBackground(Color.LIGHT_GRAY);
		m11.setHorizontalAlignment(SwingConstants.LEFT);
		m11.setFont(new Font("굴림", Font.PLAIN, 16));
		m11.setBounds(381, 268, 279, 28);
		panel.add(m11);

		JCheckBox m12 = new JCheckBox("로얄 밀크티 (Hot/ Ice) 3,000");
		m12.setBackground(Color.LIGHT_GRAY);
		m12.setHorizontalAlignment(SwingConstants.LEFT);
		m12.setFont(new Font("굴림", Font.PLAIN, 16));
		m12.setBounds(381, 313, 279, 28);
		panel.add(m12);

		JCheckBox m13 = new JCheckBox("딸기 라떼 (Hot/ Ice) 3,000");
		m13.setBackground(Color.LIGHT_GRAY);
		m13.setHorizontalAlignment(SwingConstants.LEFT);
		m13.setFont(new Font("굴림", Font.PLAIN, 16));
		m13.setBounds(381, 362, 279, 28);
		panel.add(m13);

		JLabel lblNewLabel_1_2 = new JLabel("에이드(Ade)");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(692, 145, 130, 28);
		panel.add(lblNewLabel_1_2);

		JCheckBox m14 = new JCheckBox("레몬 에이드 3,500");
		m14.setBackground(Color.LIGHT_GRAY);
		m14.setFont(new Font("굴림", Font.PLAIN, 16));
		m14.setBounds(692, 184, 180, 28);
		panel.add(m14);

		JCheckBox m15 = new JCheckBox("모히또 에이드 3,500");
		m15.setBackground(Color.LIGHT_GRAY);
		m15.setFont(new Font("굴림", Font.PLAIN, 16));
		m15.setBounds(692, 225, 197, 28);
		panel.add(m15);

		JCheckBox m16 = new JCheckBox("자몽 에이드 3,500");
		m16.setBackground(Color.LIGHT_GRAY);
		m16.setFont(new Font("굴림", Font.PLAIN, 16));
		m16.setBounds(692, 268, 180, 28);
		panel.add(m16);

		JCheckBox m17 = new JCheckBox("청포도 에이드 3,500");
		m17.setBackground(Color.LIGHT_GRAY);
		m17.setFont(new Font("굴림", Font.PLAIN, 16));
		m17.setBounds(692, 313, 197, 28);
		panel.add(m17);

		JCheckBox m18 = new JCheckBox("패션 후르츠 에이드 3,500");
		m18.setBackground(Color.LIGHT_GRAY);
		m18.setFont(new Font("굴림", Font.PLAIN, 16));
		m18.setBounds(692, 362, 236, 28);
		panel.add(m18);

		JCheckBox m19 = new JCheckBox("블루레몬 에이드 3,500");
		m19.setBackground(Color.LIGHT_GRAY);
		m19.setFont(new Font("굴림", Font.PLAIN, 16));
		m19.setBounds(692, 413, 217, 28);
		panel.add(m19);

		JLabel lblNewLabel_1_2_1 = new JLabel("프라페(Frappe)");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(977, 145, 180, 28);
		panel.add(lblNewLabel_1_2_1);

		JCheckBox m20 = new JCheckBox("초코칩 프라페 4,000");
		m20.setHorizontalAlignment(SwingConstants.LEFT);
		m20.setBackground(Color.LIGHT_GRAY);
		m20.setFont(new Font("굴림", Font.PLAIN, 16));
		m20.setBounds(977, 184, 197, 28);
		panel.add(m20);

		JCheckBox m21 = new JCheckBox("자바칩 프라페 4,000");
		m21.setHorizontalAlignment(SwingConstants.LEFT);
		m21.setBackground(Color.LIGHT_GRAY);
		m21.setFont(new Font("굴림", Font.PLAIN, 16));
		m21.setBounds(977, 223, 197, 28);
		panel.add(m21);

		JCheckBox m22 = new JCheckBox("민트칩 프라페 4,000");
		m22.setHorizontalAlignment(SwingConstants.LEFT);
		m22.setBackground(Color.LIGHT_GRAY);
		m22.setFont(new Font("굴림", Font.PLAIN, 16));
		m22.setBounds(977, 266, 197, 28);
		panel.add(m22);

		JCheckBox m23 = new JCheckBox("오레오 프라페 4,000");
		m23.setHorizontalAlignment(SwingConstants.LEFT);
		m23.setBackground(Color.LIGHT_GRAY);
		m23.setFont(new Font("굴림", Font.PLAIN, 16));
		m23.setBounds(977, 313, 197, 28);
		panel.add(m23);

		JCheckBox m24 = new JCheckBox("녹차 프라페 4,000");
		m24.setHorizontalAlignment(SwingConstants.LEFT);
		m24.setBackground(Color.LIGHT_GRAY);
		m24.setFont(new Font("굴림", Font.PLAIN, 16));
		m24.setBounds(977, 362, 197, 28);
		panel.add(m24);

		JCheckBox m25 = new JCheckBox("토피넛 프라페 4,000");
		m25.setHorizontalAlignment(SwingConstants.LEFT);
		m25.setBackground(Color.LIGHT_GRAY);
		m25.setFont(new Font("굴림", Font.PLAIN, 16));
		m25.setBounds(977, 406, 197, 28);
		panel.add(m25);

		JButton btnCancel = new JButton("주문 취소");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setFont(new Font("굴림", Font.BOLD, 20));
		btnCancel.setBounds(444, 574, 137, 154);
		panel.add(btnCancel);

		JButton btnOrder = new JButton("주문 완료");
		btnOrder.setBackground(Color.WHITE);
		btnOrder.setFont(new Font("굴림", Font.BOLD, 20));
		btnOrder.setBounds(251, 574, 137, 154);
		panel.add(btnOrder);

		JButton btnBack = new JButton("뒤로가기");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("굴림", Font.BOLD, 20));
		btnBack.setBounds(72, 574, 137, 154);
		panel.add(btnBack);

		JCheckBox m7 = new JCheckBox("헤이즐넛 / 시럽 추가 500");
		m7.setBackground(Color.LIGHT_GRAY);
		m7.setHorizontalAlignment(SwingConstants.LEFT);
		m7.setFont(new Font("굴림", Font.PLAIN, 16));
		m7.setBounds(69, 460, 266, 28);
		panel.add(m7);

		JCheckBox m8 = new JCheckBox("샷추가 / 휘핑추가 500");
		m8.setBackground(Color.LIGHT_GRAY);
		m8.setHorizontalAlignment(SwingConstants.LEFT);
		m8.setFont(new Font("굴림", Font.PLAIN, 16));
		m8.setBounds(69, 509, 277, 28);
		panel.add(m8);

		lblImage = new JLabel("");
		imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
		lblImage.setIcon(new ImageIcon(imgUrl));
		lblImage.setBounds(661, 460, 590, 301);
		panel.add(lblImage);

		comboBarista = new JComboBox();
		comboBarista.setFont(new Font("굴림", Font.BOLD, 20));
		comboBarista.setModel(new DefaultComboBoxModel(new String[] { "홍길동", "김말숙", "이기자" }));
		comboBarista.setBounds(240, 23, 137, 47);
		panel.add(comboBarista);

		JLabel lblNewLabel_2 = new JLabel("barista");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 22));
		lblNewLabel_2.setBounds(116, 21, 112, 47);
		panel.add(lblNewLabel_2);

		setVisible(true);

		/* 아래로 메소드 처리 */

		// 체크 박스
		m1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m1.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m2.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m3.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m4.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m5.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m6.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m6.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m7.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m8.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m8.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m9.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m9.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m10.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m10.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m11.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m11.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m12.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m12.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m13.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m13.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m14.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m14.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m15.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m15.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m16.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m16.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m17.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m17.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m18.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m18.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m19.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m19.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m20.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m20.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m21.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m21.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m22.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m22.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m23.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m23.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m24.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m24.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});
		m25.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					imgUrl = this.getClass().getClassLoader().getResource("m25.jpg");
				else
					imgUrl = this.getClass().getClassLoader().getResource("c2.jpg");
				lblImage.setIcon(new ImageIcon(imgUrl));
				lblImage.setBounds(692, 482, 587, 344);
				panel.add(lblImage);
			}
		});

		// 선택 취소하기
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1.setSelected(false);
				m2.setSelected(false);
				m3.setSelected(false);
				m4.setSelected(false);
				m5.setSelected(false);
				m6.setSelected(false);
				m7.setSelected(false);
				m8.setSelected(false);
				m9.setSelected(false);
				m10.setSelected(false);
				m11.setSelected(false);
				m12.setSelected(false);
				m13.setSelected(false);
				m14.setSelected(false);
				m15.setSelected(false);
				m16.setSelected(false);
				m17.setSelected(false);
				m18.setSelected(false);
				m19.setSelected(false);
				m20.setSelected(false);
				m21.setSelected(false);
				m22.setSelected(false);
				m23.setSelected(false);
				m24.setSelected(false);
				m25.setSelected(false);
//				

			}
		});

		// 주문버튼
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderList = new String[25];
				cnt = 0;

				while (true) {
					if (m1.isSelected()) {
						orderList[cnt] = m1.getText();
						cnt++;
					}
					if (m2.isSelected()) {
						orderList[cnt] = m2.getText();
						cnt++;
					}
					if (m3.isSelected()) {
						orderList[cnt] = m3.getText();
						cnt++;
					}
					if (m4.isSelected()) {
						orderList[cnt] = m4.getText();
						cnt++;
					}
					if (m5.isSelected()) {
						orderList[cnt] = m5.getText();
						cnt++;
					}
					if (m6.isSelected()) {
						orderList[cnt] = m6.getText();
						cnt++;
					}
					if (m7.isSelected()) {
						orderList[cnt] = m7.getText();
						cnt++;
					}
					if (m8.isSelected()) {
						orderList[cnt] = m8.getText();
						cnt++;
					}
					if (m9.isSelected()) {
						orderList[cnt] = m9.getText();
						cnt++;
					}
					if (m10.isSelected()) {
						orderList[cnt] = m10.getText();
						cnt++;
					}
					if (m11.isSelected()) {
						orderList[cnt] = m11.getText();
						cnt++;
					}
					if (m12.isSelected()) {
						orderList[cnt] = m12.getText();
						cnt++;
					}
					if (m13.isSelected()) {
						orderList[cnt] = m13.getText();
						cnt++;
					}
					if (m14.isSelected()) {
						orderList[cnt] = m14.getText();
						cnt++;
					}
					if (m15.isSelected()) {
						orderList[cnt] = m15.getText();
						cnt++;
					}
					if (m16.isSelected()) {
						orderList[cnt] = m16.getText();
						cnt++;
					}
					if (m17.isSelected()) {
						orderList[cnt] = m17.getText();
						cnt++;
					}
					if (m18.isSelected()) {
						orderList[cnt] = m18.getText();
						cnt++;
					}
					if (m19.isSelected()) {
						orderList[cnt] = m19.getText();
						cnt++;
					}
					if (m20.isSelected()) {
						orderList[cnt] = m20.getText();
						cnt++;
					}
					if (m21.isSelected()) {
						orderList[cnt] = m21.getText();
						cnt++;
					}
					if (m22.isSelected()) {
						orderList[cnt] = m22.getText();
						cnt++;
					}
					if (m23.isSelected()) {
						orderList[cnt] = m23.getText();
						cnt++;
					}
					if (m24.isSelected()) {
						orderList[cnt] = m24.getText();
						cnt++;
					}
					if (m25.isSelected()) {
						orderList[cnt] = m25.getText();
						cnt++;
					}
					break;
				}

				String select;
				int price1 = 0, price2 = 0, price3 = 0, price4 = 0, price5 = 0, price6 = 0, price7 = 0, price8 = 0,
						price9 = 0, price10 = 0, price11 = 0, price12 = 0, price13 = 0, price14 = 0, price15 = 0,
						price16 = 0, price17 = 0, price18 = 0, price19 = 0, price20 = 0, price21 = 0, price22 = 0,
						price23 = 0, price24 = 0, price25 = 0;
				total = 0;

				if (m1.isSelected()) {
					select = "아메리카노"; // 데이터베이스 메뉴명과 동일해야함.
					CafeVO vo = dao.pricePrint(select);
					price1 = vo.getPrice();
					total += price1;
				}
				if (m2.isSelected()) {
					select = "콜드브루 아메리카노";
					CafeVO vo = dao.pricePrint(select);
					price2 = vo.getPrice();
					total += price2;
				}
				if (m3.isSelected()) {
					select = "카페 라떼";
					CafeVO vo = dao.pricePrint(select);
					price3 = vo.getPrice();
					total += price3;
				}
				if (m4.isSelected()) {
					select = "콜드브루 라떼";
					CafeVO vo = dao.pricePrint(select);
					price4 = vo.getPrice();
					total += price4;
				}
				if (m5.isSelected()) {
					select = "바닐라 라떼";
					CafeVO vo = dao.pricePrint(select);
					price5 = vo.getPrice();
					total += price5;
				}
				if (m6.isSelected()) {
					select = "카라멜 마끼아또";
					CafeVO vo = dao.pricePrint(select);
					price6 = vo.getPrice();
					total += price6;
				}
				if (m7.isSelected()) {
					select = "헤이즐넛 / 시럽 추가";
					CafeVO vo = dao.pricePrint(select);
					price7 = vo.getPrice();
					total += price7;
				}
				if (m8.isSelected()) {
					select = "샷 추가/ 휘핑 추가";
					CafeVO vo = dao.pricePrint(select);
					price8 = vo.getPrice();
					total += price8;
				}
				if (m9.isSelected()) {
					select = "녹차라떼";
					CafeVO vo = dao.pricePrint(select);
					price9 = vo.getPrice();
					total += price9;
				}
				if (m10.isSelected()) {
					select = "카라멜 초코라떼";
					CafeVO vo = dao.pricePrint(select);
					price10 = vo.getPrice();
					total += price10;
				}
				if (m11.isSelected()) {
					select = "토피넛 라떼";
					CafeVO vo = dao.pricePrint(select);
					price11 = vo.getPrice();
					total += price11;
				}
				if (m12.isSelected()) {
					select = "로얄 밀크티";
					CafeVO vo = dao.pricePrint(select);
					price12 = vo.getPrice();
					total += price12;
				}
				if (m13.isSelected()) {
					select = "딸기 라떼";
					CafeVO vo = dao.pricePrint(select);
					price13 = vo.getPrice();
					total += price13;
				}
				if (m14.isSelected()) {
					select = "레몬 에이드";
					CafeVO vo = dao.pricePrint(select);
					price14 = vo.getPrice();
					total += price14;
				}
				if (m15.isSelected()) {
					select = "모히또 에이드";
					CafeVO vo = dao.pricePrint(select);
					price15 = vo.getPrice();
					total += price15;
				}
				if (m16.isSelected()) {
					select = "자몽 에이드";
					CafeVO vo = dao.pricePrint(select);
					price16 = vo.getPrice();
					total += price16;
				}
				if (m17.isSelected()) {
					select = "청포드 에이드";
					CafeVO vo = dao.pricePrint(select);
					price17 = vo.getPrice();
					total += price17;
				}
				if (m18.isSelected()) {
					select = "패션 후르츠 에이드";
					CafeVO vo = dao.pricePrint(select);
					price18 = vo.getPrice();
					total += price18;
				}
				if (m19.isSelected()) {
					select = "블루레몬 에이드";
					CafeVO vo = dao.pricePrint(select);
					price19 = vo.getPrice();
					total += price19;
				}
				if (m20.isSelected()) {
					select = "초코칩 프라페";
					CafeVO vo = dao.pricePrint(select);
					price20 = vo.getPrice();
					total += price20;
				}
				if (m21.isSelected()) {
					select = "자바칩 프라페";
					CafeVO vo = dao.pricePrint(select);
					price21 = vo.getPrice();
					total += price21;
				}
				if (m22.isSelected()) {
					select = "민트칩 프라페";
					CafeVO vo = dao.pricePrint(select);
					price22 = vo.getPrice();
					total += price22;
				}
				if (m23.isSelected()) {
					select = "오레오 프라페";
					CafeVO vo = dao.pricePrint(select);
					price23 = vo.getPrice();
					total += price23;
				}
				if (m24.isSelected()) {
					select = "녹차 프라페";
					CafeVO vo = dao.pricePrint(select);
					price24 = vo.getPrice();
					total += price24;
				}
				if (m25.isSelected()) {
					select = "토피넛 프라페";
					CafeVO vo = dao.pricePrint(select);
					price25 = vo.getPrice();
					total += price25;
				}
				new CafePay(comboBarista.getSelectedItem().toString());
			}
		});

		// 뒤로가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 뒤로가기 엔터키 처리
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		// new CafeOrder();
	}
}
