package service;

import java.util.ArrayList;

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

	public ArrayList<BoardMemberDTO> selectAllMember() {
		return BoardMemberDAO.getInstance().selectAllMember();
	}

	public int deleteMember(String id) {
		return BoardMemberDAO.getInstance().deleteMember(id);
	}

	public BoardMemberDTO selectMember(String id) {
		return BoardMemberDAO.getInstance().selectMember(id);
	}

	public int updateMember(BoardMemberDTO boardMemberDTO) {
		return BoardMemberDAO.getInstance().updateMember(boardMemberDTO);
	}

	
}


