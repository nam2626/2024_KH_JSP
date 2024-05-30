package service;

import java.util.ArrayList;

import config.DBManager;
import dao.BoardMemberDAO;
import dto.BoardMemberDTO;
import mapper.BoardMemberMapper;

public class BoardMemberService {
	private static BoardMemberService instance = new BoardMemberService();
	private BoardMemberMapper mapper;
	private BoardMemberService() {
		mapper = DBManager.getInstance()
				.getSession().getMapper(BoardMemberMapper.class);
	
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


