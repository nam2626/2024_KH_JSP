package controller;

import java.io.IOException;

import dto.BoardDTO;
import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. Parameter 받음
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
				
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		BoardMemberDTO member = (BoardMemberDTO) request.getSession().getAttribute("user");
		
		if (member == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>" 
			+ "alert('로그인 하셔야 이용하실수 있습니다');" 
			+ "location.href='./index.jsp'" 
			+ "</script>");
			return null;
		}else if(!member.getBoardMemberId().equals(dto.getBoardMemberId())) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>" 
			+ "alert('작성자만 게시글 수정을 할수 있습니다.');" 
			+ "location.href='./index.jsp'" 
			+ "</script>");
			return null;
		}
		dto.setBoardTitle(title);
		dto.setBoardContent(content);
		BoardService.getInstance().updateBoard(dto);
		// 3. 페이지 이동처리
		return new ModelAndView(true, "./boardView.do?bno="+dto.getBoardNo());
		

	}

}
