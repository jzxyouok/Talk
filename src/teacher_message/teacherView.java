package teacher_message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class teacherView extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String name = "wall";
		req.setAttribute("n", name);
		HttpSession session= req.getSession();
		session.setAttribute("n", name);*/
		String name = "wall";
		HttpSession session= req.getSession();
		session.setAttribute("n", name);
		response.sendRedirect(req.getContextPath()+"/html/friendlist.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String name = "wall";
		req.setAttribute("n", name);
		HttpSession session= req.getSession();
		session.setAttribute("n", name);
		response.sendRedirect("main.jsp");*/
	}
	
}
