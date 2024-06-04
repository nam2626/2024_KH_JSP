package controller;

import java.io.IOException;

import dto.BoardDTO;
import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardDeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
			+ "alert('작성자만 게시글 삭제 할수 있습니다.');" 
			+ "location.href='./index.jsp'" 
			+ "</script>");
			return null;
		}
		
		int row = BoardService.getInstance().deleteBoard(bno);
		
		return new ModelAndView(true, "./main.do");
	}

}
