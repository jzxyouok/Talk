package test;

import java.util.ArrayList;

import teacher_message.Teacher;
import Utils.EncapsulationJson;
import dao.CRUD;

public class NewTest {
	public static void main(String[] args) {
		System.out.println("wall");
		CRUD crud = new CRUD();
		ArrayList<Teacher> teachers = crud.selectAll();
		System.out.println(teachers.size());
		String jsonString = (new EncapsulationJson()).getJson(teachers);
	}
}
