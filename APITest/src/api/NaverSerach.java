package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NaverSerach {
	 public static void main(String[] args) {
	        String clientId = "Client-Id"; //애플리케이션 클라이언트 아이디
	        String clientSecret = "Client-Secret"; //애플리케이션 클라이언트 시크릿


	        String text = null;
	        try {
	            text = URLEncoder.encode("그린팩토리", "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("검색어 인코딩 실패",e);
	        }

	        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // JSON 결과
	        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과

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
	        System.out.println(result);
	    }
	

}
