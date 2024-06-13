package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Servlet implementation class NaverNewsServlet
 */
@WebServlet("/newsSerach.do")
public class NaverNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientId = "6UBhCfjedOpSOuhskcCF"; //애플리케이션 클라이언트 아이디
        String clientSecret = "GU3p5IZHHp"; //애플리케이션 클라이언트 시크릿

        
        String text = request.getParameter("txt");
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text;    // JSON 결과

        HttpURLConnection con = null;
		String result = null;
        try {
	        URL url = new URL(apiURL);
	        con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);


            int responseCode = con.getResponseCode();
            InputStreamReader ir = null;
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                ir = new InputStreamReader(con.getInputStream());
            } else { // 오류 발생
            	ir = new InputStreamReader(con.getErrorStream());
            }
            try (BufferedReader lineReader = new BufferedReader(ir)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	            result = responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
	        }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
