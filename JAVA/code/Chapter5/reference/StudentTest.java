package reference;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student studentLee = new Student(100, "Lee");
		studentLee.setKoreaSubject("����", 100);
		studentLee.setMathSubject("����", 95);

		Student studentKim = new Student(200, "Kim");
		studentKim.setKoreaSubject("����", 80);
		studentKim.setMathSubject("����", 99);
		
		studentLee.showStudent();
		studentKim.showStudent();

	}

}
