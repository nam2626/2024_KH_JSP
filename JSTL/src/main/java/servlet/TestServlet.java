package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import dto.BoardMemberDTO;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardMemberDTO 하나 생성
		BoardMemberDTO dto = new BoardMemberDTO("A0001", "홍길동", "123456", "HongKD");
		
		//session 생성
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		session.setAttribute("msg", "세션 메세지 내용");
		
		//ArrayList<BoardMemberDTO> 생성해서 데이터를 3건을 저장
		ArrayList<BoardMemberDTO> list = new ArrayList<BoardMemberDTO>();
		list.add(new BoardMemberDTO("A0002", "김철수", "123456", "Kim"));
		list.add(new BoardMemberDTO("A0003", "이영수", "123456", "Lee"));
		list.add(new BoardMemberDTO("A0004", "박영희", "123456", "Park"));
		
		request.setAttribute("list", list);
		request.setAttribute("age", 44);
		
		request.getRequestDispatcher("jstl_el.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
