package service;

public class BoardMemberService {
	private static BoardMemberService instance = new BoardMemberService();

	private BoardMemberService() {
	
	}

	public static BoardMemberService getInstance() {
		if(instance == null)
			instance = new BoardMemberService();
		return instance;
	}

	
}
