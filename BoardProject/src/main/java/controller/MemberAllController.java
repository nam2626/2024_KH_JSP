package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class MemberAllController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		List<BoardMemberDTO> list = BoardMemberService.getInstance().selectAllMember();
		request.setAttribute("member_list", list);
		view = new ModelAndView(false, "./board_member_list_jstl.jsp");		
		
		return view;
	}

}



