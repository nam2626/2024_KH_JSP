package controller;

import java.io.IOException;

import org.json.JSONObject;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import view.ModelAndView;

public class BoardLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bno = request.getParameter("bno");
		JSONObject json = new JSONObject();

		HttpSession session = request.getSession();
		BoardMemberDTO dto = (BoardMemberDTO) session.getAttribute("user");
		if (bno == null) {
			json.put("code", 1);
			json.put("msg", "게시글 번호가 없습니다.");
		}
		if (dto == null) {
			json.put("code", 2);
			json.put("msg", "로그인 하셔야 이용할 수 있습니다.");
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json.toString());
		return null;
	}

}
