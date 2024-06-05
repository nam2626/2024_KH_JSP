package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.BoardDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardMapper mapper;
	
	private BoardService() {
		mapper = DBManager.getInstance().getSession().getMapper(BoardMapper.class);
	}

	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}

	public List<BoardDTO> selectBoardList() {
		return mapper.selectBoardList();
	}

	public int insertBoard(String title, String content, String writer) {
		return mapper.insertBoard(new BoardDTO(title, writer, content));
	}

	public BoardDTO selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	public int updateBoard(BoardDTO dto) {
		return mapper.updateBoard(dto);
	}

	public int deleteBoard(int bno) {
		return mapper.deleteBoard(bno);
	}

	public int insertBoardLike(int bno, String boardMemberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", boardMemberId);
		return mapper.insertBoardLike(map);
	}
	public int deleteBoardLike(int bno, String boardMemberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", boardMemberId);
		return mapper.deleteBoardLike(map);
	}

	public int selectBoardLikeCount(int bno) {
		return mapper.selectBoardLikeCount(bno);
	}

	
	
	
}
