package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

/**
 * Servlet implementation class InsertEmployeeServlet
 */
@WebServlet("/insertEmployee")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String empPosition = request.getParameter("empPosition");
		String empDepartment= request.getParameter("empDepartment");
		int empSalary = Integer.parseInt(request.getParameter("empSalary"));
		String empCourseDate = request.getParameter("empDate");
		
		int row = EmployeeDAO.getInstance().insertEmployee(new EmployeeDTO(empNo, empName, empPosition, empDepartment, empSalary, empCourseDate));
		
		if(row == 0) {
			System.out.println("사원 정보 등록 실패");
		}else {
			System.out.println("사원 정보 등록 성공");
		}
		
		response.sendRedirect("./allEmployee");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
