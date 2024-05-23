package dao;

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

	
	
	
}
