package user_message;



public class User_message {
	private int user_id;//用户ID
	private String user_name;//用户姓名
	private int user_age;//用户年龄
	private double user_money;//用户余额
	private String user_gender;//用户性别
	private String user_password;//用户密码
	private String user_Em;//用户邮箱
	private String user_phoneNumber;//用户手机号码
	//private ArrayList<Integer> user_favorite;//用户收藏的教师通过教师ID标识收藏的教师
	
	//构造方法
	public User_message(int user_id, String user_name, int user_age,
			double user_money, String user_gender, String user_password,
			String user_phoneNumber,String user_Em/*,ArrayList<Integer> user_favorite*/) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_money = user_money;
		this.user_gender = user_gender;
		this.user_password = user_password;
		this.user_phoneNumber = user_phoneNumber;
		this.user_Em = user_Em;
		//this.user_favorite = user_favorite;
	}
	//构造方法
	public User_message(String user_name, int user_age,
			double user_money, String user_gender, String user_password,
			String user_phoneNumber,String user_Em){
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_money = user_money;
		this.user_gender = user_gender;
		this.user_password = user_password;
		this.user_phoneNumber = user_phoneNumber;
		this.user_Em = user_Em;
	}
	//构造方法
	public User_message(){
		
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public double getUser_money() {
		return user_money;
	}
	public void setUser_money(double user_money) {
		this.user_money = user_money;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phoneNumber() {
		return user_phoneNumber;
	}
	public void setUser_phoneNumber(String user_phoneNumber) {
		this.user_phoneNumber = user_phoneNumber;
	}
	public String getUser_Em() {
		return user_Em;
	}
	public void setUser_Em(String user_Em) {
		this.user_Em = user_Em;
	}
	
/*	public ArrayList<Integer> getUser_favorite() {
		return user_favorite;
	}
	public void setUser_favorite(ArrayList<Integer> user_favorite) {
		this.user_favorite = user_favorite;
	}*/
}
