package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user_message.User_message;
import dao.CRUD_USER;
//用户登录
public class LogIn {
	private String user_password;//用户密码
	private CRUD_USER user = new CRUD_USER();
	public LogIn(){
	}
	/**返回码*
	 0:登录成功
	 1:没有匹配到帐号
	 2:错误的密码
	 3:非手机/邮箱
	 */

	//正则表达式，判断是否为手机号码
	public boolean isPhone(String mobiles) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("((13\\d)|(15[^4,\\d])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	//判断是否为邮箱
	public boolean isEm(String em) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
		Matcher m = p.matcher(em);
		return m.matches();
	}
	//登录同时检查登录方式为手机号码还是邮箱号
	public int check_way(String user_input,String password){
		if (isEm(user_input)) {
			int result  = LogInByEm(user_input,password);
			return result;
		} else if (isPhone(user_input)) {
			int result  = LogInByPhoneNubmber(user_input,password);
			return result;
		} else {
			return 3;
		}
	}
	//通过邮箱登录
	private int LogInByEm(String em,String password){
		User_message user_message = user.selectByEm(em);
		if(user_message !=null) {
			user_password = user_message.getUser_password();
			if (password.equals(user_password)) {
				return 0;//验证成功
			}else {
				return 2;//密码错误
			}
		}else {
			return 1;
		}
		
	}
	//通过手机号码登录
	private int LogInByPhoneNubmber(String number,String password){
			User_message user_message = user.selectByPoneNumber(number);
			if(user_message != null) {
				user_password = user_message.getUser_password();
				if (password.equals(user_password)) {
					return 0;//验证成功
				}else {
					return 2;//密码错误
				}
			} else {
				return 1;
			}
	}
}
