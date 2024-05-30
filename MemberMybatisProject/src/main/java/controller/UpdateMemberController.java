package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class UpdateMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String boardMemberId = request.getParameter("member_id");
		String boardMemberName = request.getParameter("member_name");
		String boardMemberPasswd = request.getParameter("member_passwd");
		String boardMemberNick= request.getParameter("member_nick");
		
		int row = BoardMemberService.getInstance().updateMember(new BoardMemberDTO(boardMemberId, boardMemberName, boardMemberPasswd, boardMemberNick));
		
		response.setContentType("text/html;charset=utf-8");
		if(row == 0) {
			response.getWriter().println("<script>"
					+ "alert('수정할 회원 데이터가 없습니다.');"
					+ "location.href='./memberList.do';"
					+ "</script>");
		}else {
			response.getWriter().println("<script>"
					+ "alert('회원데이터 수정 성공');"
					+ "location.href='./memberList.do';"
					+ "</script>");
		}
		
		return view;
	}

}
