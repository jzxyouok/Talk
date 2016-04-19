package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user_message.User_message;
import dao.CRUD_USER;
//�û���¼
public class LogIn {
	private String user_password;//�û�����
	private CRUD_USER user = new CRUD_USER();
	public LogIn(){
	}
	/**������*
	 0:��¼�ɹ�
	 1:û��ƥ�䵽�ʺ�
	 2:���������
	 3:���ֻ�/����
	 */

	//������ʽ���ж��Ƿ�Ϊ�ֻ�����
	public boolean isPhone(String mobiles) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("((13\\d)|(15[^4,\\d])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	//�ж��Ƿ�Ϊ����
	public boolean isEm(String em) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
		Matcher m = p.matcher(em);
		return m.matches();
	}
	//��¼ͬʱ����¼��ʽΪ�ֻ����뻹�������
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
	//ͨ�������¼
	private int LogInByEm(String em,String password){
		User_message user_message = user.selectByEm(em);
		if(user_message !=null) {
			user_password = user_message.getUser_password();
			if (password.equals(user_password)) {
				return 0;//��֤�ɹ�
			}else {
				return 2;//�������
			}
		}else {
			return 1;
		}
		
	}
	//ͨ���ֻ������¼
	private int LogInByPhoneNubmber(String number,String password){
			User_message user_message = user.selectByPoneNumber(number);
			if(user_message != null) {
				user_password = user_message.getUser_password();
				if (password.equals(user_password)) {
					return 0;//��֤�ɹ�
				}else {
					return 2;//�������
				}
			} else {
				return 1;
			}
	}
}
