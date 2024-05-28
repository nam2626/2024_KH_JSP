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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet 호출");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println(id + " " + passwd);
		
		//dao에 아이디 비밀번호 넘겨서 검색해서 검색 결과를 BoardMemberDTO로 받음
		BoardMemberDTO dto = BoardMemberDAO.getInstance().login(id, passwd);
		System.out.println(dto);
		
		if(dto != null) {
			//페이지 이동처리
			//   로그인 성공시 ./allMember
			//request.getRequestDispatcher("./allMember").forward(request, response);
			response.sendRedirect("./allMember");
		}else {
			// 로그인 실패시
			//	 아이디 비밀번호를 확인하세요, 이전페이지로 이동
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('아이디와 비밀번호 확인하세요');"
					+ "history.back();"
					+ "</script>");
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
