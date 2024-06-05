package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;
import vo.PaggingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//페이지 번호
		String pageNo = request.getParameter("pageNo");
		//한페이지당 조회할 게시글 개수
		String pageContentEa = request.getParameter("pageContentEa");
		
		//만약에 로그인해서 페이지 번호랑 게시글 개수 정보가 없을 경우
		pageNo = pageNo == null ? "1" : pageNo;
		pageContentEa = pageContentEa == null ? "20" : pageContentEa;
				
//		List<BoardDTO> list = BoardService.getInstance().selectBoardList();
		List<BoardDTO> list = 
				BoardService.getInstance().selectBoardList(Integer.parseInt(pageNo),Integer.parseInt(pageContentEa));
		
		//PaggingVO : 페이징 정보 저장
		int totalCount = BoardService.getInstance().selectBoardTotalCount();
		PaggingVO pagging = 
				new PaggingVO(totalCount, 
						Integer.parseInt(pageNo),Integer.parseInt(pageContentEa));
		request.setAttribute("boardList", list);
		request.setAttribute("pagging", pagging);
		
		return new ModelAndView(false, "./main.jsp");
	}

}
