package mapper;

import java.util.List;

import dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> selectBoardList();
	int insertBoard(BoardDTO boardDTO);

}
