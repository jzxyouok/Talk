package sigin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CRUD_USER;

import user_message.User_message;

public class SigServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*// TODO Auto-generated method stub
			String username = request.getParameter("username");
			System.out.println(username);
			response.getWriter().write("恭喜您注册成功!3秒回到主页....");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");*/
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		System.out.println(username + "!");
		String password = request.getParameter("password");
		//String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		User_message user_message = new User_message(/*"nazi", 34,43,"男","987654","13569059897","lzz931208@yeah.net"*/);
		user_message.setUser_name(username);//昵称
		user_message.setUser_password(password);//密码
		user_message.setUser_Em(email);//邮箱
		user_message.setUser_phoneNumber(phone);//手机号码
		user_message.setUser_gender(gender);//性别
		user_message.setUser_money(15);//注册就送15元
		CRUD_USER c = new CRUD_USER();
		if(username.equals("") || password.equals("") || phone.equals("") || email.equals("")) {
			
				response.getWriter().write("please improvement your message,back on 3 seconds ....");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/sigin/ZhucePage.jsp");
			
		} else {
			int a = c.insert(user_message);
			System.out.println(a);
			if (a == 1) {
				response.getWriter().write("your registration" + phone + "is successful,back on 3 seconds ....");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
			}
		}
		
		//System.out.println(a);
		
	}

}
