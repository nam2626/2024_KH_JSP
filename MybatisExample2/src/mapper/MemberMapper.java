package mapper;

import java.util.List;
import java.util.Map;

import dto.MemberDTO;

public interface MemberMapper {
	public List<MemberDTO> selectAllMember();
	public MemberDTO login(Map<String, Object> map);
}
