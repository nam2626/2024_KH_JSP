package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BoardMemberDAO;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("memberId");
		
		int row = BoardMemberDAO.getInstance().deleteMember(id);
		
		response.setContentType("text/html;charset=utf-8");
		
		if(row == 0) {
			response.getWriter().println("<script>alert('데이터 삭제 실패');history.back();</script>");
		}else {
			response.getWriter().println("<script>alert('데이터 삭제 성공');location.href='./index.jsp';</script>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
