package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardCommentDTO;
import dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> selectBoardList();
	int insertBoard(BoardDTO boardDTO);
	BoardDTO selectBoard(int bno);
	int updateBoard(BoardDTO dto);
	int deleteBoard(int bno);
	int insertBoardLike(Map<String, Object> map);
	int deleteBoardLike(Map<String, Object> map);
	int selectBoardLikeCount(int bno);
	int insertBoardHate(Map<String, Object> map);
	int deleteBoardHate(Map<String, Object> map);
	int selectBoardHateCount(int bno);
	List<BoardDTO> selectBoardNewList(Map<String, Object> map);
	int selectBoardTotalCount();
	int insertBoardComment(BoardCommentDTO boardCommentDTO);

}







