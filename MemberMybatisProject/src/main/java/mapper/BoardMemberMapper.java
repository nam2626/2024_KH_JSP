package mapper;

import java.util.Map;

import dto.BoardMemberDTO;

public interface BoardMemberMapper {

	BoardMemberDTO login(Map<String, Object> map);

}
