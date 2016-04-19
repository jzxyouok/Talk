package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user_message.User_message;
import dao.CRUD_USER;

public class LogInServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.println(name + "!!" + pass);
		LogIn log = new LogIn();
		int a = log.check_way(name, pass);
		/**返回码*
		 0:登录成功
		 1:没有匹配到帐号
		 2:错误的密码
		 3:非手机/邮箱
		 */
		
		switch (a){
			case 0:
				HttpSession session= request.getSession();
				/*CRUD_USER u = new CRUD_USER();*/
				if(new LogIn().isPhone(name)) {
					session.setAttribute("name", (new CRUD_USER().selectByPoneNumber(name)).getUser_name());
					session.setAttribute("id", (new CRUD_USER().selectByPoneNumber(name)).getUser_id());
				} else {
					session.setAttribute("name", (new CRUD_USER().selectByEm(name)).getUser_name());
					session.setAttribute("id", (new CRUD_USER().selectByEm(name)).getUser_id());
				}
				System.out.println(session);
				//response.sendRedirect("/html/first.html");
				response.setHeader("refresh", "0;url="+request.getContextPath()+"/html/first.jsp");
				break;
			case 1:
				response.getWriter().write("we can't find you,please registration,go to registration page on 2 seconds ....");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/sigin/ZhucePage.jsp");
				break;
			case 2:
				response.getWriter().write("your password is mistake,back on 3 seconds ....");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
				break;
			case 3:
				response.getWriter().write("your username is not an email or a Mobile phone number,back on 3 seconds ....");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
				break;
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
}
