package model;

import java.sql.*;

public class TestDAO {
	private static Connection conn;
	
	private static String url = "jdbc:mysql://wjgn0406.cafe24.com/wjgn0406";
	private static String id = "wjgn0406";
	private static String pw = "dhsfkdls0129!";
	
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
