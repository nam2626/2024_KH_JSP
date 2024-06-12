package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;
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

	public int insertBoard(BoardDTO dto) {
		return mapper.insertBoard(dto);
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
	public int insertBoardHate(int bno, String boardMemberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", boardMemberId);
		return mapper.insertBoardHate(map);
	}
	public int deleteBoardHate(int bno, String boardMemberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", boardMemberId);
		return mapper.deleteBoardHate(map);
	}
	
	public int selectBoardHateCount(int bno) {
		return mapper.selectBoardHateCount(bno);
	}

	public List<BoardDTO> selectBoardList(int pageNo, int pageContentEa) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNo", pageNo);
		map.put("pageContentCount", pageContentEa);
		return mapper.selectBoardNewList(map);
	}

	public int selectBoardTotalCount() {
		return mapper.selectBoardTotalCount();
	}

	public int insertBoardComment(BoardCommentDTO boardCommentDTO) {
		return mapper.insertBoardComment(boardCommentDTO);
	}

	public List<BoardCommentDTO> selectBoardCommentList(int bno) {
		return mapper.selectBoardCommentList(bno);
	}

	public int deleteBoardComment(int cno) {
		return mapper.deleteBoardComment(cno);
	}

	public int insertBoardCommentLike(String boardMemberId, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", boardMemberId);
		map.put("cno", cno);
		return mapper.insertBoardCommentLike(map);
	}
	public int deleteBoardCommentLike(String boardMemberId, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", boardMemberId);
		map.put("cno", cno);
		return mapper.deleteBoardCommentLike(map);
	}
	public int insertBoardCommentHate(String boardMemberId, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", boardMemberId);
		map.put("cno", cno);
		return mapper.insertBoardCommentHate(map);
	}
	public int deleteBoardCommentHate(String boardMemberId, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", boardMemberId);
		map.put("cno", cno);
		return mapper.deleteBoardCommentHate(map);
	}

	public int updateBoardCount(int bno) {
		return mapper.updateBoardCount(bno);
	}

	public int getBoardNo() {
		return mapper.getBoardNo();
	}

	public int insertBoardFile(FileDTO t) {
		return mapper.insertBoardFile(t);
	}

	public List<FileDTO> selectBoardFileList(int bno) {
		return mapper.selectBoardFileList(bno);
	}

	public FileDTO selectFile(int bno, int fno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("fno", fno);
		return mapper.selectBoardFile(map);
	}

	
	
	
}
