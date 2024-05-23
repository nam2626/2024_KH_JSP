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
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 보낸 데이터를 받음 -> request.getParameter("input 태그의 네임속성값"); 
		String boardMemberId = request.getParameter("member_id");
		String boardMemberName = request.getParameter("member_name");
		String boardMemberPasswd = request.getParameter("member_passwd");
		String boardMemberNick= request.getParameter("member_nick");
		
		//2. BoardMemberDTO를 생성
		//	 콘솔에 생성한 DTO 출력
		BoardMemberDTO dto = new BoardMemberDTO(boardMemberId, boardMemberName, 
												boardMemberPasswd, boardMemberNick);
		System.out.println(dto.toString());
		
		//3. BoardMemberDAO에 회원정보 삽입하는 메서드 호출
		int row = BoardMemberDAO.getInstance().insertBoardMember(dto);
		if(row == 0) {
			System.out.println("데이터 등록 실패");
		}else {
			System.out.println("데이터 등록 성공");
		}
		//4. 전체회원정보 페이지로 이동
		response.sendRedirect("./allMember");//서블릿에서 다른 서블릿을 호출 가능
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 보내면 구버전 톰캣의 경우 한글처리가 안되서 깨짐, 다시 인코딩 해줘야함
//		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
