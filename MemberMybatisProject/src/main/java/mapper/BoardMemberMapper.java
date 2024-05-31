package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardMemberDTO;

public interface BoardMemberMapper {

	BoardMemberDTO login(Map<String, Object> map);
	List<BoardMemberDTO> selectAllMember();
	int deleteMember(String id);
	int insertMember(BoardMemberDTO boardMemberDTO);
	BoardMemberDTO selectMember(String id);
	int updateMember(BoardMemberDTO boardMemberDTO);
	List<BoardMemberDTO> selectNameMember(String search);

}
