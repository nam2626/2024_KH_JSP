package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BoardMemberDTO dto = (BoardMemberDTO) request.getSession().getAttribute("user");
		int cno = Integer.parseInt(request.getParameter("cno"));
		response.setContentType("text/html;charset=utf-8");
		try {
			BoardService.getInstance().insertBoardCommentLike(dto.getBoardMemberId(), cno);
			response.getWriter().println("insert");
		}catch (Exception e) {
			BoardService.getInstance().deleteBoardCommentLike(dto.getBoardMemberId(), cno);
			response.getWriter().println("delete");
		}
		
		
		return null;
	}

}





