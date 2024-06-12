package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import dto.BoardDTO;
import dto.BoardMemberDTO;
import dto.FileDTO;
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
		//첨부파일 삭제
		//1. 해당 게시글의 파일 목록을 받아옴
		List<FileDTO> list = BoardService.getInstance().selectBoardFileList(bno);
		//2. FileDTO에 있는 path에 해당하는 파일을 삭제
		list.forEach(item -> {
			File file = new File(item.getPath());
			file.delete();
		});
		
		int row = BoardService.getInstance().deleteBoard(bno);
		
		return new ModelAndView(true, "./main.do");
	}

}
