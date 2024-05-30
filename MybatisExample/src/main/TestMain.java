package main;

import mapper.MemberMapper;

public class TestMain {

	public static void main(String[] args) {
		MemberMapper.getInstance().selectAllMember();
		System.out.println("프로그램 종료");
	}

}
