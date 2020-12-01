package reference;

public class Student {

	int studentID;
	String studentName;

	Subject korea;
	Subject math;

	public Student(int id, String name) {
		studentID = id;
		studentName = name;

		korea = new Subject();
		math = new Subject();

	}

	public void setKoreaSubject(String name, int score) {
		korea.score = score;
		korea.subjectName = name;
	}

	public void setMathSubject(String name, int score) {
		math.score = score;
		math.subjectName = name;

	}

	public void showStudent() {
		System.out.println(studentName + "학생의 국어 점수는" + korea.score + "점 입니다.");
		System.out.println(studentName + "학생의 수학 점수는" + math.score + "점 입니다.");
	}

	/*
	 * 
	 * 
	 * 
	 * public void showStudent() { int total = korea.score + math.score;
	 * System.out.println(studentName + "학생의 총점은 " + total + "점 입니다."); }
	 */
}
