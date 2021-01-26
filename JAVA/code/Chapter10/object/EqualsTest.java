package object;

class Student{
	int studentNum;
	String studentName;
	
	public Student(int studentNum, String studentName){
		this.studentNum = studentNum;
		this.studentName = studentName;
	}

	@Override
	public boolean equals(Object obj) {
		 
		if(obj instanceof Student){
			Student std = (Student)obj; //Student로 다운캐스팅
			return (this.studentNum == std.studentNum); //같으면 ture 다르면 flase 반환
		}
		return false;
	}

	@Override
	public int hashCode() { //위에 정의한 멤버들을 이용한다
	
		return studentNum;
	}
	
	
	
	
}
public class EqualsTest {

	public static void main(String[] args) {
		Student Lee = new Student(100, "Lee");
		Student Lee2 = Lee;
		Student Shin = new Student(100,"Lee");
		
		System.out.println(Lee == Lee2);//true
		System.out.println(Lee == Shin);//false
		
		System.out.println(Lee.equals(Shin)); //elquals() 
											//재정의 전: false 재정의 후: true
		
		System.out.println(Lee.hashCode());
		System.out.println(Shin.hashCode());//hashcode() 
											//재정의 전: 값이다름. 재정의 후: 값이 같음.
	}

}
