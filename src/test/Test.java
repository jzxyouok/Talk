package test;

import java.util.ArrayList;

import Utils.EncapsulationJson;
import teacher_message.Teacher;
import dao.CRUD;



public class Test {

	public static void main(String[] args) {
		CRUD crud = new CRUD();
		ArrayList<Teacher> teachers = crud.selectAll();
		EncapsulationJson encapsulationJson = new EncapsulationJson();
		String json = encapsulationJson.getJson(teachers);
		System.out.println(teachers.get(0).getTeacherImageUrlString());
		System.out.println(json);
	}

}
