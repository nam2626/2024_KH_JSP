package service;

import dao.BoardMemberDAO;
import dto.BoardMemberDTO;

public class BoardMemberService {
	private static BoardMemberService instance = new BoardMemberService();

	private BoardMemberService() {
	
	}

	public static BoardMemberService getInstance() {
		if(instance == null)
			instance = new BoardMemberService();
		return instance;
	}

	public BoardMemberDTO login(String id, String passwd) {
		return BoardMemberDAO.getInstance().login(id, passwd);
	}

	
}


