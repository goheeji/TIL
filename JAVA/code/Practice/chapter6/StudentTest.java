package chapter6;

public class StudentTest {

	public static void main(String[] args) {
		Student Lee = new Student("Lee");
		Lee.addBook("�¹���1");
		Lee.addBook("�¹���2");
		Lee.showStudejtInfo();
		
		Student Kim = new Student("Kim");
		Kim.addBook("����1");
		Kim.addBook("����2");
		Kim.addBook("����3");
		Kim.showStudejtInfo();
		
		Student Cho = new Student("Cho");
		Cho.addBook("�ظ�����1");
		Cho.addBook("�ظ�����2");
		Cho.addBook("�ظ�����3");
		Cho.addBook("�ظ�����4");
		Cho.addBook("�ظ�����5");
		Cho.addBook("�ظ�����6");
		Cho.showStudejtInfo();
		
		

	}

}
