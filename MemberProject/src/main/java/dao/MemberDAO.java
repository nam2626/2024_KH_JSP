package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private OracleDataSource ods;
	
	private MemberDAO() {
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521/xe");
			ods.setUser("c##scott");
			ods.setPassword("123456");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	//전체 회원정보 조회
	public void selectAllMember() {
		String sql = "select * from board_member";
		
		//접속 정보 획득 후 SQL 실행할 준비
		try(Connection conn = ods.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			//SQL문 실행
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}







