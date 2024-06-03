package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//로그인한 사람만 글쓰기를 수행하게끔 세션 정보 처리
		if(request.getSession().getAttribute("user") == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('로그인 하셔야 이용하실수 있습니다');"
					+ "location.href='./index.jsp'"
					+ "</script>");
			return null;
		}
		//1. Parameter 받음
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//작성자 아이디는 세션에서 읽어옴
//		HttpSession session = request.getSession();
//		BoardMemberDTO dto = (BoardMemberDTO) session.getAttribute("user");
//		String writer = dto.getBoardMemberId();
		String writer = ((BoardMemberDTO) request.getSession().getAttribute("user")).getBoardMemberId();
		//2. Service 호출 
		BoardService.getInstance().insertBoard(title,content,writer);
		//3. 페이지 이동처리
		return new ModelAndView(true, "./main.do");
	}

}
