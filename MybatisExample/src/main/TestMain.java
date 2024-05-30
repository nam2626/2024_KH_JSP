package main;

import java.util.List;

import dto.MemberDTO;
import mapper.MemberMapper;

public class TestMain {

	public static void main(String[] args) {
		List<MemberDTO> list = MemberMapper.getInstance().selectAllMember();
		for(int i = 0; i < list.size();i++)
			System.out.println(list.get(i).getBoardMemberId());
		
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
