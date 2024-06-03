package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class InsertMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String boardMemberId = request.getParameter("member_id");
		String boardMemberName = request.getParameter("member_name");
		String boardMemberPasswd = request.getParameter("member_passwd");
		String boardMemberNick = request.getParameter("member_nick");
		
		int count = BoardMemberService.getInstance().insertMember(
				new BoardMemberDTO(boardMemberId, boardMemberName, 
						boardMemberPasswd, boardMemberNick));
		ModelAndView view = null;
		if(count == 1) {
			view = new ModelAndView(true,"./login.jsp");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('회원정보 등록에 실패하였습니다');"
					+ "history.back();"
					+ "</script>");
		}
		
		return view;
	}

}
