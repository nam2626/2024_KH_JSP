package test;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.BoardMemberDAO;
import dto.BoardMemberDTO;

public class JsonTest {

	public static void main(String[] args) {
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
		ArrayList<BoardMemberDTO> list = BoardMemberDAO.getInstance().selectAllMember();
		JSONArray array = new JSONArray(list);
		jsonObject.put("list", array);
		
		String result = jsonObject.toString();
		
		System.out.println(result);
	}

}
