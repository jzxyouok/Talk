package test;

import static org.junit.Assert.*;
import login.LogIn;

import org.junit.Test;

public class LogInTest {

	@Test
	public void testCheck_way() {
		//assertEquals(0, new LogIn().check_way("lzz931308@yean.net", "123"));
		assertEquals(0, new LogIn().check_way("13569029897", "123"));
	}

}
