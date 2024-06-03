package service;

import java.util.List;

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

	
	
	
}
