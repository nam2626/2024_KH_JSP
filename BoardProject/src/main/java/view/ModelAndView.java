package view;

public class ModelAndView {
	//이동시 redirect? forward 인지 결정하는 필드
	private boolean redirect;
	//이동할 페이지 경로
	private String path;

	public ModelAndView(boolean redirect, String path) {
		this.redirect = redirect;
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
