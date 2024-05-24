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
 * Servlet implementation class UpdateMemberViewServlet
 */
@WebServlet("/updateMemberView")
public class UpdateMemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 쿼리스트링에 있는 회원 아이디 받아와야함
		String id = request.getParameter("memberId");
		//2. DAO로 부터 해당 회원아이디를 보내서 해당 회원 정보를 읽어와야함
		BoardMemberDTO dto = BoardMemberDAO.getInstance().selectMember(id);
		//3. request영역에 회원 정보를 셋팅
		request.setAttribute("dto", dto);
		//4. 회원정보 수정페이지로 이동
		request.getRequestDispatcher("./update_member.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
