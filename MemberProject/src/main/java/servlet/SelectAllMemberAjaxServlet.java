package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.BoardMemberDAO;
import dto.BoardMemberDTO;

/**
 * Servlet implementation class SelectAllMemberAjaxServlet
 */
@WebServlet("/member/list")
public class SelectAllMemberAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllMemberAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BoardMemberDTO> list = BoardMemberDAO.getInstance().selectAllMember();
		JSONArray array = new JSONArray(list);
		System.out.println(array.toString());
		//ajax의 결과로 json객체를 문자열로 데이터를 변환해서 전송
		response.setContentType("text/html;charset=utf-8");//문자코드 변경
		response.getWriter().println(array.toString());		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
