package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		//id, passwd 뽑음
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		//service로 id, passwd 보냄
		BoardMemberDTO dto = BoardMemberService.getInstance().login(id, passwd);
		if(dto != null) {
			//세션에 로그인 정보 추가
			request.getSession().setAttribute("user", dto);
			//결과 받아서 페이지 이동할 정보를 ModelAndView를 생성해서 셋팅
			view = new ModelAndView(true, "./memberList.do");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('아이디와 비밀번호 확인하세요');"
					+ "history.back();"
					+ "</script>");
		}
		return view;
	}

}






