package dto;

public class MemberDTO {
	private String boardMemberId;
	private String boardMemberName;
	private String boardMemberPasswd;
	private String boardMemberNick;

	public MemberDTO() {
	}

	public MemberDTO(String boardMemberId, String boardMemberName, String boardMemberPasswd, String boardMemberNick) {
		this.boardMemberId = boardMemberId;
		this.boardMemberName = boardMemberName;
		this.boardMemberPasswd = boardMemberPasswd;
		this.boardMemberNick = boardMemberNick;
	}

	public String getBoardMemberId() {
		return boardMemberId;
	}

	public void setBoardMemberId(String boardMemberId) {
		this.boardMemberId = boardMemberId;
	}

	public String getBoardMemberName() {
		return boardMemberName;
	}

	public void setBoardMemberName(String boardMemberName) {
		this.boardMemberName = boardMemberName;
	}

	public String getBoardMemberPasswd() {
		return boardMemberPasswd;
	}

	public void setBoardMemberPasswd(String boardMemberPasswd) {
		this.boardMemberPasswd = boardMemberPasswd;
	}

	public String getBoardMemberNick() {
		return boardMemberNick;
	}

	public void setBoardMemberNick(String boardMemberNick) {
		this.boardMemberNick = boardMemberNick;
	}

	
	
}
