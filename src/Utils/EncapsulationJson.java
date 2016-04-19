package Utils;

import java.util.ArrayList;

import teacher_message.Teacher;

public class EncapsulationJson {
	private StringBuffer jsonOfOnCarBuffer;
	private Teacher teacher;
	public String getJson(ArrayList<Teacher> teachers) {
		jsonOfOnCarBuffer = new StringBuffer();
		jsonOfOnCarBuffer.append("[");
		for (int i = 0; i < teachers.size(); i++) {
			teacher = teachers.get(i);
			jsonOfOnCarBuffer.append("{");
			//teacher_id
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_id");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_id());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_name
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_name");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_name());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_location
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_location");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_location());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_evaluate
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_evaluate");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_evaluate());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_charge
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_charge");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_charge());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_time
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_time");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_time());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_gender
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_gender");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacher_gender());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(",");
			//封装teacher_image
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("teacher_image");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(":");
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append(teacher.getTeacherImageUrlString());
			jsonOfOnCarBuffer.append("\"");
			jsonOfOnCarBuffer.append("}");
			if (i < teachers.size() - 1) {
				jsonOfOnCarBuffer.append(",");
			}
		}
		jsonOfOnCarBuffer.append("]");
		return String.valueOf(jsonOfOnCarBuffer);
	}
}
