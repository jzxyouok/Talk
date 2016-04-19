package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import teacher_message.Teacher;
import db.JdbcConnect;
/*
 * 执行数据库各种操作*/
//代码未优化，复用率低下，用户查询的代码进行了优化。暂时不修改
public class CRUD {
	private int teacher_id;
	private String teacher_name;
	private String teacher_location;
	private double teacher_evaluate;
	private double teacher_charge;
	private int teacher_time;
	private String teacher_gender;
	private String teacherImageString;
	private JdbcConnect jdbcConnect ;
	
	private Statement statement = null;
	private ResultSet eResultSet = null;
	private final static String SqlQuery = "select * from message_teacher";
	private final static String SqlQuery_User = "select * from message_user";
	public CRUD() {
		jdbcConnect = new JdbcConnect();
		statement = jdbcConnect.getStatement();
	}
	//查询所有教师信息，返回Teacher类集合
	public ArrayList<Teacher> selectAll() {
		ArrayList<Teacher> teachers= new ArrayList<Teacher>();
		try {
			eResultSet = statement.executeQuery(SqlQuery);
			while (eResultSet.next()) {
				teacher_id = eResultSet.getInt("teacher_id");
				teacher_name = eResultSet.getString("teacher_name");
				teacher_location = eResultSet.getString("teacher_location");
				teacher_evaluate = eResultSet.getDouble("teacher_evaluate");
				teacher_charge = eResultSet.getDouble("teacher_charge");
				teacher_time = eResultSet.getInt("teacher_time");
				teacher_gender = eResultSet.getString("teacher_gender");
				teacherImageString = eResultSet.getString("teacher_image");
				Teacher teacher = new Teacher(teacher_id, teacher_name, teacher_location, 
						teacher_evaluate, teacher_charge, teacher_time, teacher_gender,teacherImageString);
				teachers.add(teacher);
			}
			return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			jdbcConnect.close(eResultSet);
		}
		return null;
	}
	//通过姓名查询教师,返回一个Teacher对象
	public Teacher selectByName(String name) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from message_teacher where teacher_name = '");
			sql.append(name + "'");
			eResultSet = statement.executeQuery(sql.toString());
			while (eResultSet.next()) {
				teacher_id = eResultSet.getInt("teacher_id");
				teacher_name = eResultSet.getString("teacher_name");
				teacher_location = eResultSet.getString("teacher_location");
				teacher_evaluate = eResultSet.getDouble("teacher_evaluate");
				teacher_charge = eResultSet.getDouble("teacher_charge");
				teacher_time = eResultSet.getInt("teacher_time");
				teacher_gender = eResultSet.getString("teacher_gender");
				
			}
			return new Teacher(teacher_id, teacher_name, teacher_location, 
					teacher_evaluate, teacher_charge, teacher_time, teacher_gender,teacherImageString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcConnect.close(eResultSet);
		}
		return null;
	}
	//通过ID批量查询教师信息(从用户表中获取用户收藏的教师ID，查询出用户收藏的教师信息<可以使用多表查询，但是，设计阶段的疏忽，修改太费劲！！！！
	//此处就继续使用低效率的方法)
	//多表查询（select * from message_teacher as mt,user_favorire_name as ufn where mt.teacher_name=ufn.user_favorite_name;）
	public ArrayList<Teacher> selectById(int [] _id) {
		ArrayList<Teacher> teachers= new ArrayList<Teacher>();
		try {
			for (int i = 0;i<_id.length;i++){
				eResultSet = statement.executeQuery("select * from message_teacher where teacher_id = " +
						  _id[i]);
				while (eResultSet.next()) {
					teacher_id = eResultSet.getInt("teacher_id");
					teacher_name = eResultSet.getString("teacher_name");
					teacher_location = eResultSet.getString("teacher_location");
					teacher_evaluate = eResultSet.getDouble("teacher_evaluate");
					teacher_charge = eResultSet.getDouble("teacher_charge");
					teacher_time = eResultSet.getInt("teacher_time");
					teacher_gender = eResultSet.getString("teacher_gender");
					Teacher teacher = new Teacher(teacher_id, teacher_name, teacher_location, 
							teacher_evaluate, teacher_charge, teacher_time, teacher_gender,teacherImageString);
					teachers.add(teacher);
				}
			}
			//System.out.println(teachers.size() + "!!");
			return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcConnect.close(eResultSet);
		}
		return null;
	}
}
