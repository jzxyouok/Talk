package sigin;
//用户注册
public class SigIn {
	private int user_id;//用户ID
	private String user_name;//用户姓名
	private int user_age;//用户年龄
	private double user_money;//用户余额
	private String user_gender;//用户性别
	private String user_password;//用户密码
	private String user_Em;//用户邮箱
	private String user_phoneNumber;//用户手机号码
	public SigIn(int user_id, String user_name, int user_age,
			double user_money, String user_gender, String user_password,
			String user_phoneNumber,String user_Em){
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_money = user_money;
		this.user_gender = user_gender;
		this.user_password = user_password;
		this.user_phoneNumber = user_phoneNumber;
		this.user_Em = user_Em;
	}
	//判断邮箱和手机号码是否已经存在
	
	//如果不存在则插入数据
}
