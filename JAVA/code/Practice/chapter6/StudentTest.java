package chapter6;

public class StudentTest {

	public static void main(String[] args) {
		Student Lee = new Student("Lee");
		Lee.addBook("태백산맥1");
		Lee.addBook("태백산맥2");
		Lee.showStudejtInfo();
		
		Student Kim = new Student("Kim");
		Kim.addBook("토지1");
		Kim.addBook("토지2");
		Kim.addBook("토지3");
		Kim.showStudejtInfo();
		
		Student Cho = new Student("Cho");
		Cho.addBook("해리포터1");
		Cho.addBook("해리포터2");
		Cho.addBook("해리포터3");
		Cho.addBook("해리포터4");
		Cho.addBook("해리포터5");
		Cho.addBook("해리포터6");
		Cho.showStudejtInfo();
		
		

	}

}
