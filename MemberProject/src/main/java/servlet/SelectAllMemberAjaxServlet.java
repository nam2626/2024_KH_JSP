package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONObject;

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
		JSONObject jsonObject = new JSONObject();
		//json에 데이터 추가 방법 --> 맵 사용법이랑 비슷함
		jsonObject.put("msg", "SelectAllMemberAjaxServlet에서 셋팅한 메세지");
		jsonObject.put("age", 33);
		//회원정보하나 생성
		BoardMemberDTO dto = new BoardMemberDTO("A002","김철수","123456","KimCS");
		//jsonObject에 dto 내용을 추가
		//dto -> json으로 변환
		JSONObject member = new JSONObject(dto);
		//변환된것을 저장, 다이렉트로 저장 X
		jsonObject.put("dto", member);
		
		//BoardMemberDAO에서 전체 회원정보 가져오기
		
		
		String result = jsonObject.toString();
		
		//ajax의 결과로 json객체를 문자열로 데이터를 변환해서 전송
		response.setContentType("text/html;charset=utf-8");//문자코드 변경
		response.getWriter().println(result);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
