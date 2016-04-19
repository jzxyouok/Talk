package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 连接数据库*/
public class JdbcConnect {
		private final static String MysqlName = "root"; 
		private final static String MysqlPassword = "wall"; 
		private final static String Url = "jdbc:mysql://localhost:3306/talk";
		private Statement statement = null;
		private Connection connection = null;
		public JdbcConnect() {
			// TODO Auto-generated constructor stub
		}
		//获取数据库连接
		public Statement getStatement() {
			//1：注册数据据驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//2：获取数据库连接
				connection = DriverManager.getConnection(Url, MysqlName, MysqlPassword);
				//3：获取传输器
				statement = connection.createStatement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return statement;
		}
		//释放资源
		public void close(ResultSet eResultSet) {
			if (eResultSet != null) {
				try {
					eResultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//关闭结果集对象
			}
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					statement = null;
				}//关闭传输器对象
			}
			if (connection!=null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					connection = null;
				}//关闭数据库连接
			}
		}
}
