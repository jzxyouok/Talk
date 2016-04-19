package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.CRUD;

import teacher_message.Teacher;

public class CRUDTest {

	@Test
	public void testSelectByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectById() {
		fail("Not yet implemented");
	}
	
	@Test
	public void SelectAll() {
		CRUD crud = new CRUD();
		ArrayList<Teacher> teachers = crud.selectAll();
		for (int i = 0; i < teachers.size(); i++) {
			Teacher teacher = teachers.get(i);
			System.out.println(teacher.getTeacher_id() + "|" + teacher.getTeacher_name());
		}
	}

}
