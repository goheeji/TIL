package staticex;

public class StudentIDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student studentGo = new Student("Go");
		System.out.println(Student.getSerialNum());
		
		Student studentHeo = new Student("Heo");
		
		System.out.println(Student.getSerialNum());
		System.out.println(Student.getSerialNum());
		
		System.out.println(studentGo.getStudentID());
		System.out.println(studentHeo.getStudentID());

	}

}
