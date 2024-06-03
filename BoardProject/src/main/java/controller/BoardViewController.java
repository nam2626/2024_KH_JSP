package controller;

import java.io.IOException;

import dto.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		//서비스로 게시글 번호 보내서 게시글 받아옴
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		
		request.setAttribute("board", dto);
		
		return new ModelAndView(false, "./board_view.jsp");
	}

}





