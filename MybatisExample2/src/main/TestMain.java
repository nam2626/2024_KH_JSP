package main;

import java.util.HashMap;
import java.util.List;

import config.DBManager;
import dto.MemberDTO;
import mapper.MemberMapper;

public class TestMain {

	public static void main(String[] args) {
		MemberMapper mapper = DBManager.getInstance().getSession().getMapper(MemberMapper.class);
		List<MemberDTO> list = mapper.selectAllMember();
		for(int i = 0; i < list.size();i++)
			System.out.println(list.get(i).getBoardMemberId());
		
		System.out.println("-----");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", "A0001");
		map.put("passwd", "123456");
		
		MemberDTO dto = mapper.login(map);
		System.out.println(dto);
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
