package test;



import org.junit.Test;

import user_message.User_message;
import dao.CRUD_USER;

public class CRUD_USERTest {




	/*@Test
	public void testSelectByID() {
		User_message user_message = new CRUD_USER().selectByID(3);
		System.out.println(user_message.getUser_name());
	}

	@Test
	public void testSelectByEm() {
		User_message user_message = new CRUD_USER().selectByEm("lzz931308@yean.net");
		System.out.println(user_message.getUser_name());
	}
*/
	@Test
	public void testSelectByPoneNumber() {
		User_message user_message = new CRUD_USER().selectByPoneNumber("13588888888");
		System.out.println(user_message.getUser_name());
	}
	
	/*@Test
	public void testInsert() {
		User_message user_message = new User_message("rommel", 34,43,"ÄÐ","asd","13588888888","lzz931208@yeah.net");
		int a = new CRUD_USER().insert(user_message);
		System.out.println(a);
	}*/

}
