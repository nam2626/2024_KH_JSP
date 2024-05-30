package mapper;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	private DBManager manager;
	
	private MemberMapper() {
		manager = DBManager.getInstance();
	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}
	
	public List<MemberDTO> selectAllMember() {
		List<MemberDTO> list = manager.getSession().selectList("selectAllMember"); 
		return list;
	}

	public MemberDTO login(Map<String, Object> map) {
		return manager.getSession().selectOne("login", map);
	}

	public List<MemberDTO> selectNameMember(String text) {
		return manager.getSession().selectList("selectNameMember",text);
	}

	public int insertMember(MemberDTO dto) {
		return manager.getSession().insert("insertMember", dto);
	}
	
	
}



