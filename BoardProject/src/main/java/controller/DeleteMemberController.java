package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class DeleteMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String id = request.getParameter("memberId");
		int row = BoardMemberService.getInstance().deleteMember(id);
		
		if(row != 0) {
			view = new ModelAndView(true, "./memberList.do");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('데이터 삭제에 실패하였습니다.');"
					+ "history.back();"
					+ "</script>");
		}
		
		return view;
	}

}






