package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DBManager;
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", passwd);
		return mapper.login(map);
	}

	public List<BoardMemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	public int deleteMember(String id) {
		return mapper.deleteMember(id);
	}

	public BoardMemberDTO selectMember(String id) {
		return mapper.selectMember(id);
	}

	public int updateMember(BoardMemberDTO boardMemberDTO) {
		return mapper.updateMember(boardMemberDTO);
	}

	public int insertMember(BoardMemberDTO boardMemberDTO) {
		return mapper.insertMember(boardMemberDTO);
	}

	
}


