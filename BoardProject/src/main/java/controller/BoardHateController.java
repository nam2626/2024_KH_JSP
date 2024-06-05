package controller;

import java.io.IOException;

import org.json.JSONObject;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

public class BoardHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(
				request.getParameter("bno") == null ? "0" : request.getParameter("bno"));

		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		BoardMemberDTO dto = (BoardMemberDTO) session.getAttribute("user");
		if (bno == 0) {
			json.put("code", 1);
			json.put("msg", "게시글 번호가 없습니다.");
		}else if (dto == null) {
			json.put("code", 2);
			json.put("msg", "로그인 하셔야 이용할 수 있습니다.");
		}else {
			try {
				BoardService.getInstance().insertBoardHate(bno, dto.getBoardMemberId());
				json.put("code", 0);
				json.put("msg", "해당 게시글에 싫어요를 하셨습니다.");
			}catch (Exception e) {
				BoardService.getInstance().deleteBoardHate(bno, dto.getBoardMemberId());
				json.put("code", 0);
				json.put("msg", "해당 게시글에 싫어요를 취소 하셨습니다.");
			}
		}
		json.put("count", BoardService.getInstance().selectBoardHateCount(bno));
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json.toString());		
		return null;
	}

}
