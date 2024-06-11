package controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//로그인한 사람만 글쓰기를 수행하게끔 세션 정보 처리
		if(request.getSession().getAttribute("user") == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>"
					+ "alert('로그인 하셔야 이용하실수 있습니다');"
					+ "location.href='./index.jsp'"
					+ "</script>");
			return null;
		}
		//파일 업로드
		/*
		 * 1. 업로드할 경로, DiskFileItemFactory 생성
		 * 2. 사용자가 보낸 내용을 받아서, BoardDTO와 FileDTO를 생성
		 * 3. 파일 쓰기 수행
		 * 4. DB에 게시글을 등록하고 나서 파일목록을 테이블 등록
		*/
		//업로드할 기본 폴더 설정
		File userRoot = new File("c:\\fileupload\\");
		//업로드할 기본 폴더가 없으면 경로까지의 폴더를 생성
		if(!userRoot.exists()) {
			System.out.println("파일 업로드할 폴더 생성");
			userRoot.mkdirs();
		}
		System.out.println(userRoot.getAbsolutePath());
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		factory.setRepository(userRoot);//업로드할 폴더
		
		//게시글 추가
		//1. Parameter 받음
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//작성자 아이디는 세션에서 읽어옴
//		HttpSession session = request.getSession();
//		BoardMemberDTO dto = (BoardMemberDTO) session.getAttribute("user");
//		String writer = dto.getBoardMemberId();
		String writer = ((BoardMemberDTO) request.getSession().getAttribute("user")).getBoardMemberId();
		//2. Service 호출 
		BoardService.getInstance().insertBoard(title,content,writer);
		//3. 페이지 이동처리
		return new ModelAndView(true, "./main.do");
	}

}
