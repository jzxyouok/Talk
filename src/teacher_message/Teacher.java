package teacher_message;

public class Teacher {
	private int teacher_id;//��ʦID
	private String teacher_name;//��ʦ����
	private String teacher_location;//��ʦ����
	private double teacher_evaluate;//��ʦ����
	private double teacher_charge;//��ʦÿСʱ�۸�
	private int teacher_time;//��ʦ������ʱ��
	private String teacher_gender;//��ʦ�Ա�
	private String typeString;//��ʦ���
	private String teacherImageUrlString;//��ʦͼƬ·��
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public Teacher(int teacher_id, String teacher_name,
			String teacher_location, double teacher_evaluate,
			double teacher_charge, int teacher_time, String teacher_gender,String teacherImageUrlString) {
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_location = teacher_location;
		this.teacher_evaluate = teacher_evaluate;
		this.teacher_charge = teacher_charge;
		this.teacher_time = teacher_time;
		this.teacher_gender = teacher_gender;
		this.teacherImageUrlString = teacherImageUrlString;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_location() {
		return teacher_location;
	}

	public void setTeacher_location(String teacher_location) {
		this.teacher_location = teacher_location;
	}

	public double getTeacher_evaluate() {
		return teacher_evaluate;
	}

	public void setTeacher_evaluate(double teacher_evaluate) {
		this.teacher_evaluate = teacher_evaluate;
	}

	public double getTeacher_charge() {
		return teacher_charge;
	}

	public void setTeacher_charge(double teacher_charge) {
		this.teacher_charge = teacher_charge;
	}

	public int getTeacher_time() {
		return teacher_time;
	}

	public void setTeacher_time(int teacher_time) {
		this.teacher_time = teacher_time;
	}

	public String getTeacher_gender() {
		return teacher_gender;
	}

	public void setTeacher_gender(String teacher_gender) {
		this.teacher_gender = teacher_gender;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public String getTeacherImageUrlString() {
		return teacherImageUrlString;
	}

	public void setTeacherImageUrlString(String teacherImageUrlString) {
		this.teacherImageUrlString = teacherImageUrlString;
	}
	
	
}
