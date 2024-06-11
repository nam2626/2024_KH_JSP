package controller;

import java.io.IOException;

import org.json.JSONObject;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BoardMemberDTO dto = (BoardMemberDTO) request.getSession().getAttribute("user");
		int cno = Integer.parseInt(request.getParameter("cno"));
		response.setContentType("text/html;charset=utf-8");
		JSONObject json = new JSONObject();
		try {
			BoardService.getInstance().insertBoardCommentHate(dto.getBoardMemberId(), cno);
			json.put("result", "insert");
			System.out.println(json.toString());
			response.getWriter().println(json.toString());
		}catch (Exception e) {
			BoardService.getInstance().deleteBoardCommentHate(dto.getBoardMemberId(), cno);
			json.put("result", "delete");
			System.out.println(json.toString());
			response.getWriter().println(json.toString());
		}
		return null;
	}

}
