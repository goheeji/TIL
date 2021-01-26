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
			Student std = (Student)obj; //Student�� �ٿ�ĳ����
			return (this.studentNum == std.studentNum); //������ ture �ٸ��� flase ��ȯ
		}
		return false;
	}

	@Override
	public int hashCode() { //���� ������ ������� �̿��Ѵ�
	
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
											//������ ��: false ������ ��: true
		
		System.out.println(Lee.hashCode());
		System.out.println(Shin.hashCode());//hashcode() 
											//������ ��: ���̴ٸ�. ������ ��: ���� ����.
	}

}
