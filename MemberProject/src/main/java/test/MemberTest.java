package test;

import dao.MemberDAO;

public class MemberTest {

	public static void main(String[] args) {
		MemberDAO.getInstance().selectAllMember();
	}

}
