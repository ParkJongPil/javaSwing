package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CafeDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "";

	CafeVO vo = null;

	// 처음 DAO생성시에 Database 연결한다.
	public CafeDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javagreen04";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~~~");
		}
	}

	// Database Close
	public void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	// preparedstatement객체 Close
	public void pstmtClose() {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
		}
	}

	// resultset객체 close
	public void rsClose() {
		try {
			if (rs != null) {
				rs.close();
				pstmtClose();
			}
		} catch (Exception e) {
		}
	}

	public CafeVO pricePrint(String select) {
		CafeVO vo = new CafeVO();
		try {
			sql = "select * from cafe where menuName = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, select);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("sql 에러 :" + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public void beforeList() {
		// TODO Auto-generated method stub

	}

	// 결제하기
	public void CafePay(CafeVO vo) {
		try {
			//System.out.println("CafePay(vo) : " + vo);
			sql = "insert into list values (default,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMenuName1());
			pstmt.setInt(3, vo.getPrice1());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}

	}

	public Vector getList() {
		Vector vData = new Vector();
		try {
			sql = "select * from list order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menuName"));
				vo.add(rs.getInt("price"));
				vo.add(rs.getString("saleDay").substring(0, 10));

				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// 주문 날짜별로 날짜만 가져오기
	public ArrayList<String> getOrderDate() {
		ArrayList<String> vDataOrder = new ArrayList<String>();
		try {
			sql = "select distinct substring(saleDay,1,10) as vOrder from list order by saleDay desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vDataOrder.add(rs.getString("vOrder"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vDataOrder;
	}

	// 날짜별 조건 검색
	public Vector getOrderDay(String orderDay) {
		Vector vData = new Vector();
		try {
			sql = "select * from list where substring(saleDay,1,10) = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderDay);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menuName"));
				vo.add(rs.getInt("price"));
				vo.add(rs.getString("saleDay").substring(0, 10));

				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;

	}

	// 날짜별 전체 검색
	public Vector getOrderAll() {
		Vector vData = new Vector();
		try {
			sql = "select * from list order by idx desc ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menuName"));
				vo.add(rs.getInt("price"));
				vo.add(rs.getString("saleDay").substring(0, 10));

				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// 합계
	public int getSumOrderDay(String orderDay) {
		int sumPrice = 0;
		try {
			sql = "select sum(price) as sumPrice from list where substring(saleDay,1,10) = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderDay);
			rs = pstmt.executeQuery();
			rs.next();
			sumPrice = rs.getInt("sumPrice");
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return sumPrice;
	}
	
	// 바리스타 조회
	public String[] getBarista() {
		String[] vosBarista = new String[3];
		try {
			sql = "select distinct name from list order by name ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			for(int i=0; i<3; i++) {
				rs.next();
				vosBarista[i]=rs.getString("name");
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vosBarista;
	}
//바리스타별 주문 조회
	public Vector getSearchBarista(String name) {
		Vector vData = new Vector();
		try {
			sql = "select * from list where name = ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menuName"));
				vo.add(rs.getInt("price"));
				vo.add(rs.getString("saleDay").substring(0, 10));

				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	// 바티스타별 합계
	public int getSumBarista(String name) {
		int sumPrice = 0;
		try {
			sql = "select sum(price) as sumPrice from list where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			rs.next();
			sumPrice = rs.getInt("sumPrice");
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return sumPrice;
	}
	// 날짜/바리스타 조회
	public Vector getSearchDayBarista(String comboOrder, String name) {
		Vector vData = new Vector();
		try {
			sql = "select * from list where substring(saleDay,1,10)=? and name = ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comboOrder);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menuName"));
				vo.add(rs.getInt("price"));
				vo.add(rs.getString("saleDay").substring(0, 10));

				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	// 날짜/바리스타 합계
	public int getSumDayBarista(String comboOrder, String name) {
		int sumPrice = 0;
		try {
			sql = "select sum(price) as sumPrice from list where substring(saleDay,1,10)=? and name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comboOrder);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			rs.next();
			sumPrice = rs.getInt("sumPrice");
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return sumPrice;
	}

}
