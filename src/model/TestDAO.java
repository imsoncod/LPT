package model;

import java.sql.*;

public class TestDAO {
	private static Connection conn;
	
	private static String url = "";
	private static String id = "";
	private static String pw = "";
	
	//데이터베이스 연결
	public TestDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다");
		}
		
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 접속 성공");
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getLocalizedMessage());
		}
	}
	
	//Test결과 DB삽입
	public boolean insertTest(TestDTO dto) {
		String query = "insert into Test values(num, ?, ?, ?)";
		boolean check = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getResult());
			
			int x = pstmt.executeUpdate();
			if(x < 1) {
				System.out.println("정상적으로 저장되지 않았습니다");
			}
			
			check = true;
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getLocalizedMessage());
		}
		
		return true;
	}
	
	//차트에 표시될 데이터 가져오기
	public int[] getTest() {
		int[] position = new int[5];
		String query = "select * from all_view";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			for(int i = 0; i < 5; i++) {
				if(rs.next()) position[i] = rs.getInt(2);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getLocalizedMessage());
		}
		
		return position;
	}
	
	//Connection 닫기
	public void close() {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			System.out.println("SQL Error : " + e.getLocalizedMessage());
		}
	}
}
