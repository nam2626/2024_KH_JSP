package test;

import java.util.ArrayList;

import dao.MemberDAO;
import dto.BoardMemberDTO;

public class MemberTest {

	public static void main(String[] args) {
		ArrayList<BoardMemberDTO> list = MemberDAO.getInstance().selectAllMember();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

}
