package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.MemberDTO;
import mapper.MemberMapper;

public class TestMain {

	public static void main(String[] args) {
		/*
		 * List<MemberDTO> list = MemberMapper.getInstance().selectAllMember(); for(int
		 * i = 0; i < list.size();i++)
		 * System.out.println(list.get(i).getBoardMemberId());
		 */
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "A0001");
//		map.put("pass", "123456");
//		MemberDTO dto = MemberMapper.getInstance().login(map);
//		System.out.println(dto);
		
		//이름 일부분으로 검색해서 결과를 출력하는 코드 dto 클래스에 toString
//		String text = "A";
//		List<MemberDTO> list = MemberMapper.getInstance().selectNameMember(text);
//		System.out.println(list);
		
		//회원정보 추가하는 코드
//		MemberDTO dto = new MemberDTO("A0002","김철수","123456","KIM");
//		int result = MemberMapper.getInstance().insertMember(dto);
//		System.out.println(result);
		
		//아이디가 A0002인 데이터를 삭제하는 코드를 작성해서 실행
//		int result = MemberMapper.getInstance().deleteMember("A0002");
//		System.out.println(result);

		//이름에 'ar'이 포함되어 있는 회원들의 닉네임을 AAAA로 수정작업 실행
		String search = "ar";
		String update = "AAAA";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("nick", update);
		
		int result = MemberMapper.getInstance().updateMember(map);
		System.out.println(result);
	}

}





