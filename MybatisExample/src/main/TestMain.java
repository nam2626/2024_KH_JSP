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
		String text = "A";
		List<MemberDTO> list = MemberMapper.getInstance().selectNameMember(text);
		System.out.println(list);
		
	}

}





