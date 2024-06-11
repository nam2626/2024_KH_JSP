package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;

import dto.BoardMemberDTO;
import dto.FileDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
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
		//업로드할 기본 폴더 설정
		File userRoot = new File("c:\\fileupload\\");
		//업로드할 기본 폴더가 없으면 경로까지의 폴더를 생성
		if(!userRoot.exists()) {
			System.out.println("파일 업로드할 폴더 생성");
			userRoot.mkdirs();
		}
		//업로드한 파일 정보 읽는 부분
		List<FileDTO> list = new ArrayList<FileDTO>();
		try {
			Iterator<Part> it = request.getParts().iterator();
			int fno = 0;
			while (it.hasNext()) {
				Part part = it.next();
				System.out.println(part.getSize());
				String fileName = getFilename(part);
				System.out.println(fileName);
				if (!fileName.isEmpty()) {
					//실제 파일 쓰기 부분
					String path = userRoot.getAbsolutePath() + "\\" + fileName;
					part.write(path);
					//DB에 저장할 파일 정보
					list.add(new FileDTO(new File(path),0,++fno));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		//게시글 추가
		//0. 글번호 받음
		int bno = BoardService.getInstance().getBoardNo();
		//파일 정보 리스트에 글번호를 저장
		list.forEach(t -> t.setBno(bno));
		
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
	
	//파일명 가져오는 메서드
		private String getFilename(Part part) {
			String contentDisp = part.getHeader("content-disposition");
			System.out.println(contentDisp);
			String[] split = contentDisp.split(";");
			for (int i = 0; i < split.length; i++) {
				String temp = split[i];
				if (temp.trim().startsWith("filename")) {
					return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
				}
			}
			return "";
		}

}
