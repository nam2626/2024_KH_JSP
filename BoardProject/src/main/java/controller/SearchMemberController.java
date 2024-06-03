package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;
import view.ModelAndView;

public class SearchMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String search = request.getParameter("search");
		System.out.println(search);
		
		List<BoardMemberDTO> list = 
				BoardMemberService.getInstance().selectNameMember(search);
		
		JSONArray array = new JSONArray(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(array.toString());
		
		return null;
	}

}
