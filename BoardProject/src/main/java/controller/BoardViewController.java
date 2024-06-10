package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardCommentDTO;
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
		dto.setBoardContent(dto.getBoardContent().replaceAll("\n" , "<br>"));
		request.setAttribute("board", dto);
		//게시글 댓글 목록을 받아옴
		List<BoardCommentDTO> list =
				BoardService.getInstance().selectBoardCommentList(bno);
		request.setAttribute("commentList", list);
		
		return new ModelAndView(false, "./board_view.jsp");
	}

}





