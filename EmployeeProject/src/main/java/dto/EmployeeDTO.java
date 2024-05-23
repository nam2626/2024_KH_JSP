package dto;

public class EmployeeDTO {
	private String empNo;
	private String empName;
	private String empPosition;
	private String empDepartment;
	private int empSalary;
	private String empCourseDate;

	public EmployeeDTO() {	}

	public EmployeeDTO(String empNo, String empName, String empPosition, String empDepartment, int empSalary,
			String empCourseDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.empPosition = empPosition;
		this.empDepartment = empDepartment;
		this.empSalary = empSalary;
		this.empCourseDate = empCourseDate;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpCourseDate() {
		return empCourseDate;
	}

	public void setEmpCourseDate(String empCourseDate) {
		this.empCourseDate = empCourseDate;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empNo=" + empNo + ", empName=" + empName + ", empPosition=" + empPosition
				+ ", empDepartment=" + empDepartment + ", empSalary=" + empSalary + ", empCourseDate=" + empCourseDate
				+ "]";
	}
	
}
