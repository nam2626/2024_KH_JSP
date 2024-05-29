package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.BoardMemberDAO;
import dto.BoardMemberDTO;

/**
 * Servlet implementation class DeleteMemberAjaxServlet
 */
@WebServlet("/member/delete")
public class DeleteMemberAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str = br.readLine()) != null) {
			sb.append(str);
		}
		
		System.out.println(sb);
		//사용자가 보낸 문자열을 json으로 변환
		JSONObject json = new JSONObject(sb.toString());
		System.out.println(json.getString("memberId"));
			
		//해당 회원아이디를 삭제하는 코드 추가
		int row = BoardMemberDAO.getInstance().deleteMember(json.getString("memberId"));
		//결과값을 json으로 만들어서 전송
		JSONObject result = new JSONObject();
		result.put("resultCode",row);
		if(row == 0) {
			result.put("resultMessage", "회원정보 삭제에 실패했습니다.");
		}else {
			result.put("resultMessage", "회원정보 삭제에 성공했습니다.");
		}
		ArrayList<BoardMemberDTO> list = BoardMemberDAO.getInstance().selectAllMember();
		result.put("list", new JSONArray(list));
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(result.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
