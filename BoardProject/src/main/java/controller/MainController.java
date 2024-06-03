package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<BoardDTO> list = BoardService.getInstance().selectBoardList();
		
		request.setAttribute("boardList", list);
		
		return new ModelAndView(false, "./main.jsp");
	}

}
