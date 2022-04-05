package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CafeOrderList extends JFrame {
	DefaultTableModel defaultTableModel;

	private JTable jTable;
	CafeDAO dao = new CafeDAO();
	Vector vData, title;
	JComboBox comboBarista;

	public CafeOrderList() {
		super("주문 내역서");
		setSize(781, 599);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 743, 102);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("주문 내역서");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel.setBounds(12, 7, 159, 48);
		panel.add(lblNewLabel);

		// 성별을 Vector에 담아서 comboGender콤보상자에 뿌린다.(남/여)
		ArrayList<String> vDataOrder = dao.getOrderDate();

		JComboBox comboOrder = new JComboBox();
		comboOrder.setFont(new Font("굴림체", Font.PLAIN, 14));
		comboOrder.setBounds(197, 7, 145, 35);
		for (int i = 0; i < vDataOrder.size(); i++) {
			comboOrder.addItem(vDataOrder.get(i));
		}
		panel.add(comboOrder);

		JButton btnSearch = new JButton("날짜 조회");
		btnSearch.setFont(new Font("굴림체", Font.PLAIN, 14));
		btnSearch.setBounds(355, 7, 137, 35);
		panel.add(btnSearch);

		JButton btnList = new JButton("전체 조회");
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		btnList.setBounds(504, 7, 143, 80);
		panel.add(btnList);

		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(659, 7, 78, 80);
		panel.add(btnExit);

//		JComboBox comboOrder = new JComboBox();
//		comboOrder.setFont(new Font("Dialog", Font.PLAIN, 14));
//		comboOrder.setBounds(197, 7, 145, 35);
//		for (int i = 0; i < vDataOrder.size(); i++) {
//			comboOrder.addItem(vDataOrder.get(i));
//		}
//		panel.add(comboOrder);

		// 바리스타를 Vector에 담아서 comboBarista 콤보상자에 뿌린다.
		String[] vDataBarista = dao.getBarista();

		comboBarista = new JComboBox();
		comboBarista.setFont(new Font("굴림체", Font.PLAIN, 14));
		comboBarista.setBounds(197, 52, 145, 35);
		for (int i = 0; i < vDataBarista.length; i++) {
			comboBarista.addItem(vDataBarista[i]);
		}
		panel.add(comboBarista);

		JButton btnBarista = new JButton("바리스타 조회");
		btnBarista.setFont(new Font("굴림체", Font.PLAIN, 14));
		btnBarista.setBounds(355, 52, 137, 35);
		panel.add(btnBarista);

		JButton btnBarista_1 = new JButton("날짜 / 바리스타조회");
		btnBarista_1.setFont(new Font("굴림체", Font.PLAIN, 14));
		btnBarista_1.setBounds(12, 52, 173, 35);
		panel.add(btnBarista_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 122, 743, 430);

		Vector title = new Vector();
		title.add("번호");
		title.add("이름");
		title.add("메뉴명");
		title.add("가격");
		title.add("날짜");

		vData = dao.getList();
		// System.out.println("vData:" + vData);

		defaultTableModel = new DefaultTableModel(vData, title);
		panel_1.setLayout(null);
//	    jTable = new JTable(defaultTableModel);
//	    jScrollPane = new JScrollPane(jTable);
//	    jScrollPane.setBounds(0, 0, 454, 221);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 719, 242);
		// panel_1.add(scrollPane);

		jTable = new JTable(defaultTableModel);
		scrollPane.setViewportView(jTable);
		panel_1.add(scrollPane);
		getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 326, 740, 131);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 10, 740, 134);
		panel_2.add(scrollPane_1);

		JTextArea txtaOrder = new JTextArea();
		scrollPane_1.setViewportView(txtaOrder);

		JLabel lblNewLabel_1 = new JLabel("상세 주문 내역");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("굴림체", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 292, 183, 36);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("총 합계 금액 :");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 24));
		lblNewLabel_2.setBounds(357, 252, 175, 64);
		panel_1.add(lblNewLabel_2);

		JLabel lblTotal = new JLabel("");
		lblTotal.setFont(new Font("돋움", Font.BOLD, 25));
		lblTotal.setBounds(544, 252, 143, 64);
		panel_1.add(lblTotal);

		JLabel lblNewLabel_3 = new JLabel("원");
		lblNewLabel_3.setFont(new Font("굴림체", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(686, 262, 45, 44);
		panel_1.add(lblNewLabel_3);

		setVisible(true);

		// ===================메소드 작업영역=========================

		// 날짜, 바리스타 조회
		btnBarista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getSearchDayBarista(comboOrder.getSelectedItem().toString(),
						comboBarista.getSelectedItem().toString());
				defaultTableModel.setDataVector(vData, title);

				// 합계
				int sumPrice = dao.getSumDayBarista(comboOrder.getSelectedItem().toString(),
						comboBarista.getSelectedItem().toString());
				DecimalFormat formatter = new DecimalFormat("#,###");
				lblTotal.setText(formatter.format(sumPrice));

			}
		});
		
		// 날짜, 바리스타 조회 엔터키 처리
		btnBarista_1.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								vData = dao.getSearchDayBarista(comboOrder.getSelectedItem().toString(),
										comboBarista.getSelectedItem().toString());
								defaultTableModel.setDataVector(vData, title);

								// 합계
								int sumPrice = dao.getSumDayBarista(comboOrder.getSelectedItem().toString(),
										comboBarista.getSelectedItem().toString());
								DecimalFormat formatter = new DecimalFormat("#,###");
								lblTotal.setText(formatter.format(sumPrice));
							}
				});
		// 바리스타 조회
		btnBarista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getSearchBarista(comboBarista.getSelectedItem().toString());
				defaultTableModel.setDataVector(vData, title);

				// 합계
				int sumPrice = dao.getSumBarista(comboBarista.getSelectedItem().toString());
				DecimalFormat formatter = new DecimalFormat("#,###");
				lblTotal.setText(formatter.format(sumPrice));

			}
		});
		
		// 바리스타 조회 엔터키 처리
		btnBarista.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						vData = dao.getSearchBarista(comboBarista.getSelectedItem().toString());
						defaultTableModel.setDataVector(vData, title);

						// 합계
						int sumPrice = dao.getSumBarista(comboBarista.getSelectedItem().toString());
						DecimalFormat formatter = new DecimalFormat("#,###");
						lblTotal.setText(formatter.format(sumPrice));
					}
		});

		

		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 종료 버튼 엔터키 처리
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
			}
		});

		// 조건 검색
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderDay = comboOrder.getSelectedItem().toString();
				vData = dao.getOrderDay(orderDay);
				defaultTableModel.setDataVector(vData, title);

				// 합계
				int sumPrice = dao.getSumOrderDay(orderDay);
				DecimalFormat formatter = new DecimalFormat("#,###");
				lblTotal.setText(formatter.format(sumPrice));

			}
		});

		// 조건 검색 엔터키 처리
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String orderDay = comboOrder.getSelectedItem().toString();
				vData = dao.getOrderDay(orderDay);
				defaultTableModel.setDataVector(vData, title);

				// 합계
				int sumPrice = dao.getSumOrderDay(orderDay);
				DecimalFormat formatter = new DecimalFormat("#,###");
				lblTotal.setText(formatter.format(sumPrice));
			}
		});

		// 전체 조회
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getOrderAll();
				defaultTableModel.setDataVector(vData, title);
			}
		});

		// 전체 조회 엔터키 처리
		btnList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				vData = dao.getOrderAll();
				defaultTableModel.setDataVector(vData, title);

			}
		});

		// jTable클릭시 내용을 텍스트박스로 가져오기
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택한 셀의 행 번호계산
				int row = jTable.getSelectedRow();

				// 테이블의 모델객체 얻어오기
				TableModel data = jTable.getModel();

				String menuName = (String) data.getValueAt(row, 2);
				menuName = menuName.replace("&", "\n");
				txtaOrder.setText(menuName);
			}
		});
	}

	public static void main(String[] args) {
//		new CafeOrderList();

	}
}
