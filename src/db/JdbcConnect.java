package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * �������ݿ�*/
public class JdbcConnect {
		private final static String MysqlName = "root"; 
		private final static String MysqlPassword = "wall"; 
		private final static String Url = "jdbc:mysql://localhost:3306/talk";
		private Statement statement = null;
		private Connection connection = null;
		public JdbcConnect() {
			// TODO Auto-generated constructor stub
		}
		//��ȡ���ݿ�����
		public Statement getStatement() {
			//1��ע�����ݾ�����
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//2����ȡ���ݿ�����
				connection = DriverManager.getConnection(Url, MysqlName, MysqlPassword);
				//3����ȡ������
				statement = connection.createStatement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return statement;
		}
		//�ͷ���Դ
		public void close(ResultSet eResultSet) {
			if (eResultSet != null) {
				try {
					eResultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//�رս��������
			}
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					statement = null;
				}//�رմ���������
			}
			if (connection!=null) {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					connection = null;
				}//�ر����ݿ�����
			}
		}
}
