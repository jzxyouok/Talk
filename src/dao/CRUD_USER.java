package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import user_message.User_message;
import db.JdbcConnect;

public class CRUD_USER {
	private int user_id;//�û�ID
	private String user_name;//�û�����
	private int user_age;//�û�����
	private double user_money;//�û����
	private String user_gender;//�û��Ա�
	private String user_password;//�û�����
	private String user_phoneNumber;//�û��ֻ�����
	private String user_Em;//�û�����
	private JdbcConnect jdbcConnect ;
	private Statement statement = null;
	private ResultSet eResultSet = null;
	private final static String SqlQuery_User = "select * from user";
	
	public CRUD_USER() {
		jdbcConnect = new JdbcConnect();
		statement = jdbcConnect.getStatement();
	}
	
	//��ȡ��ѯ���,���ҽ���ѯ�����װΪUser_message���󷵻�
	public User_message obtain(ResultSet eResultSet) {
			
		try {
			user_id = eResultSet.getInt("id_user");//�û�ID
			user_name = eResultSet.getString("user_name");//�û�����
			user_age = eResultSet.getInt("user_age");//�û�����
			user_money = eResultSet.getDouble("user_money");//�û����
			user_gender = eResultSet.getString("user_gender");//�û��Ա�
			user_password = eResultSet.getString("user_password");//�û�����
			user_phoneNumber = eResultSet.getString("user_phoneNumber");//�û��ֻ�����
			user_Em = eResultSet.getString("user_Em");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new User_message(user_id, user_name,
				user_age, user_money, user_gender, user_password, user_phoneNumber,user_Em);
	}
	//�û�ע��ʱ��������һ������
		public int insert(User_message user_message) {
			try {
				/*String mysql = "insert into user"
						+ "(user_name,user_money,user_age,user_gender,user_password,user_phoneNumber,user_Em) "
						+ "values('"+user_message.getUser_name() + "'"
								+ "' +,��,��,��,��,��,��)";
				Object [] valueStrings = {
						user_message.getUser_name(),user_message.getUser_money(),user_message.getUser_gender(),
						user_message.getUser_password(),user_message.getUser_phoneNumber(),user_message.getUser_Em()};*/
				StringBuilder sql = new StringBuilder();
				sql.append("insert into user"
						+ "(user_name,user_money,user_age,user_gender,user_password,user_phoneNumber,user_Em)"
						+ "values(");
				sql.append( "'" + user_message.getUser_name() + "',");
				sql.append(user_message.getUser_money() + ",");
				sql.append(user_message.getUser_age() + ",");
				sql.append( "'" + user_message.getUser_gender() + "',");
				sql.append( "'" + user_message.getUser_password() + "',");
				sql.append( "'" + user_message.getUser_phoneNumber() + "',");
				sql.append( "'" + user_message.getUser_Em() + "'");
				sql.append(")");
				//int a = statement.executeUpdate(mysql,valueStrings);
				int a  = statement.executeUpdate(sql.toString());
				return a;
				// TODO Auto-generated catch block
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				jdbcConnect.close(eResultSet);
				
			}
			return 0;
		}
	//��ѯ��ǰ�û�������Ϣ
	public User_message selectByID(int user_id){
		User_message user_message = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from user where id_user =");
			sql.append(user_id);
			eResultSet = statement.executeQuery(sql.toString());
			while (eResultSet.next()) {
				user_message = obtain(eResultSet);
			}
			return user_message;
			// TODO Auto-generated catch block
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			jdbcConnect.close(eResultSet);
		}
		return null;
	}
	//ͨ�������ѯ�û���Ϣ
	public User_message selectByEm(String em){
		User_message user_message = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from user where user_Em = '");
			sql.append(em + "'");
			eResultSet = statement.executeQuery(sql.toString());
			while (eResultSet.next()) {
				user_message = obtain(eResultSet);
			}
			return user_message;
			// TODO Auto-generated catch block
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			jdbcConnect.close(eResultSet);
		}
		return null;
	}
	//ͨ���ֻ����ǲ�ѯ�û���Ϣ
	public User_message selectByPoneNumber(String number){
		User_message user_message = null;
		try {
			String mysql  = "select * from user where user_phoneNumber = '" + number + "'";
			eResultSet = statement.executeQuery(mysql);
			while (eResultSet.next()) {
				user_message = obtain(eResultSet);
			}
			return user_message;
			// TODO Auto-generated catch block
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			jdbcConnect.close(eResultSet);
		}
		return null;
	}
}

