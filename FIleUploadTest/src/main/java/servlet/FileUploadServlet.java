package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 업로드할 기본 폴더 설정
		File userRoot = new File("c:\\fileupload\\");
		System.out.println(userRoot.getAbsolutePath());
		// 업로드할 기본 폴더가 없으면 경로까지의 폴더를 생성
		if (!userRoot.exists()) {
			System.out.println("파일 업로드할 폴더 생성");
			userRoot.mkdirs();
		}
		//업로드한 파일 정보 읽는 부분
		Iterator<Part> it = request.getParts().iterator();
		while (it.hasNext()) {
			Part part = it.next();
			//업로드한 파일이 없으면 건너뜀
			if(part.getSize() == 0) continue;
			String fileName = getFilename(part);
			if (!fileName.isEmpty()) {
				part.write(userRoot.getAbsolutePath() + "\\" + fileName);
			}
		}
		response.getWriter().append("{'result':'write finish'}");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
