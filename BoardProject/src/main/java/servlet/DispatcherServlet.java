package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

import java.io.IOException;

import controller.Controller;
import controller.HandlerMapping;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 50)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] path = request.getRequestURI().split("/");
		String command = path[path.length-1].replace(".do", "");
		
		//작업을 진행
		Controller controller = HandlerMapping.getInstance().createController(command);
		ModelAndView view = null;
		
		if(controller != null)
			view = controller.execute(request, response);
		
		//페이지 이동 처리
		if(view != null) {
			if(view.isRedirect())
				response.sendRedirect(view.getPath());
			else
				request.getRequestDispatcher(view.getPath()).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
