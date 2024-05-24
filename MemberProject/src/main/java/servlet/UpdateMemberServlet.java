package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BoardMemberDAO;
import dto.BoardMemberDTO;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardMemberId = request.getParameter("member_id");
		String boardMemberName = request.getParameter("member_name");
		String boardMemberPasswd = request.getParameter("member_passwd");
		String boardMemberNick= request.getParameter("member_nick");
		
		int row = BoardMemberDAO.getInstance().updateMember(new BoardMemberDTO(boardMemberId, boardMemberName, boardMemberPasswd, boardMemberNick));
		
		response.setContentType("text/html;charset=utf-8");
		
		if(row == 0) {
			response.getWriter().println("<script>alert('데이터 수정 실패');history.back();</script>");
		}else {
			response.getWriter().println("<script>alert('데이터 수정 성공');location.href='./allMember';</script>");
			
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
