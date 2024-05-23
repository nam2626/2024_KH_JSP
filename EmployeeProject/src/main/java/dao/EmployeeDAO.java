package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.EmployeeDTO;
import oracle.jdbc.pool.OracleDataSource;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private OracleDataSource ods;
	
	private EmployeeDAO() {	
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521/xe");
			ods.setUser("c##scott");
			ods.setPassword("123456");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public ArrayList<EmployeeDTO> selectAllEmployee() {
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

		String sql = "select * from employee";
		
		try(Connection conn = ods.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String empNo = rs.getString("EMP_NO");
					String empName = rs.getString("EMP_NAME");
					String empPosition= rs.getString("EMP_POSITION");
					String empDepartment= rs.getString("EMP_DEPARTMENT");
					int empSalary = rs.getInt("EMP_SALARY");
					String empCourseDate= rs.getString("EMP_COURSE_DATE");
					
					list.add(new EmployeeDTO(empNo, empName, empPosition, empDepartment, empSalary, empCourseDate));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	
}








