package controller;

import java.io.IOException;

import dto.BoardCommentDTO;
import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentInsertController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String comment = request.getParameter("comment");
//		BoardMemberDTO dto = (BoardMemberDTO)request.getSession().getAttribute("use");
//		String writer = dto.getBoardMemberId();
		String writer = ((BoardMemberDTO)request.getSession().getAttribute("user")).getBoardMemberId();
		
		BoardService.getInstance().insertBoardComment(
				new BoardCommentDTO(bno, writer, comment));
		
		return new ModelAndView(true, "./boardView.do?bno="+bno);
	}

}






