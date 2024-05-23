package test;

import java.util.ArrayList;

import dao.BoardMemberDAO;
import dto.BoardMemberDTO;

public class MemberTest {

	public static void main(String[] args) {
		ArrayList<BoardMemberDTO> list = BoardMemberDAO.getInstance().selectAllMember();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

}
