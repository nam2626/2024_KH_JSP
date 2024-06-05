package vo;

public class PaggingVO {
	//전체 게시글 개수
	private int count;
	//현재 페이지 번호
	private int currentPage;
	//한 페이지당 출력할 게시글 개수
	private int pageOfContentCount;
	//게시판 하단에 나타낼 페이지 번호 개수
	private final int PAGE_GROUP_OF_COUNT = 4;
	
	public PaggingVO(int count, int currentPage, int pageOfContentCount) {
		this.count = count;
		this.currentPage = currentPage;
		this.pageOfContentCount = pageOfContentCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	//전체 페이지 개수
	public int getTotalPage() {
		
	}
	
	
	
}
