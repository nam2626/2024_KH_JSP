package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class UpdateMemberViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String id = request.getParameter("memberId");
		BoardMemberDTO dto = BoardMemberService.getInstance().selectMember(id);
		
		if(dto != null) {
			request.setAttribute("dto", dto);
			view = new ModelAndView(false, "./update_member_jstl.jsp");
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('수정할 회원 데이터가 없습니다.');"
					+ "location.href='./memberList.do';"
					+ "</script>");
		}
		
		return view;
	}

}
