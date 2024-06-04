package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	
	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		switch(command) {
		case "login":
			controller = new LoginController();
			break;
		case "memberList":
			controller = new MemberAllController();
			break;
		case "logout":
			controller = new LogoutController();
			break;
		case "deleteMember":
			controller = new DeleteMemberController();
			break;
		case "updateMemberView":
			controller = new UpdateMemberViewController();
			break;
		case "updateMember":
			controller = new UpdateMemberController();
			break;
		case "insertMember":
			controller = new InsertMemberController();
			break;
		case "searchMember":
			controller = new SearchMemberController();
			break;
		case "main":
			controller = new MainController();
			break;
		case "boardWrite":
			controller = new BoardWriteController();
			break;
		case "boardView":
			controller = new BoardViewController();
			break;
		case "boardUpdateView":
			controller = new BoardUpdateViewController();
			break;
		case "boardUpdate":
			controller = new BoardUpdateController();
			break;
		case "boardDelete":
			controller = new BoardDeleteController();
			break;
		}
		return controller;
	}
	
	
}



