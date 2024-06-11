package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		//게시글 조회수 증가
		HttpSession session = request.getSession();
		HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("history");
		if(set == null) {
			set = new HashSet<Integer>();
			session.setAttribute("history", set);
		}
		System.out.println(set);
		//추가가 되면 true, 안되면 false
		if(set.add(bno))
			BoardService.getInstance().updateBoardCount(bno);
		
		//서비스로 게시글 번호 보내서 게시글 받아옴
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		dto.setBoardContent(dto.getBoardContent().replaceAll("\n" , "<br>"));
		request.setAttribute("board", dto);
		//게시글 댓글 목록을 받아옴
		List<BoardCommentDTO> list =
				BoardService.getInstance().selectBoardCommentList(bno);
		System.out.println(list);
		request.setAttribute("commentList", list);
		//파일 목록을 받아옴
		List<FileDTO> flist = BoardService.getInstance().selectBoardFileList(bno);
		request.setAttribute("fileList", flist);
		
		
		return new ModelAndView(false, "./board_view.jsp");
	}

}





