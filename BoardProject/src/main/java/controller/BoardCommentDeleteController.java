package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentDeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		BoardService.getInstance().deleteBoardComment(cno);		
		
		return new ModelAndView(true, "./boardView.do?bno="+bno);
	}

}
