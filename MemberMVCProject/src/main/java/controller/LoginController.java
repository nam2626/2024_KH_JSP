package controller;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		//id, passwd 뽑음
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		//service로 id, passwd 보냄
		BoardMemberDTO dto = BoardMemberService.getInstance().login(id, passwd);
		//세션에 로그인 정보 추가
		request.getSession().setAttribute("dto", dto);
		//결과 받아서 페이지 이동할 정보를 ModelAndView를 생성해서 셋팅
		view = new ModelAndView(true, "./memberList.do");
		return view;
	}

}






