# ArrayList
## ArrayList 클래스
- 자바에서 제공되는 객체 배열이 구현된 클래스
- 객체 배열을 사용하는데 필요한 여러 메서드들이 구현되어 있음
- 주요메서드
<img src="https://github.com/goheeji/TIL/blob/master/JAVA/arrayList/1.png"><br>

메서드 사용 예제

```java
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("aaa"); //값 넣기
		list.add("bbb");
		list.add("ccc");

		for (int i = 0; i < list.size(); i++) {// 배열의 크기 list.length와 다르다. 
			String str = list.get(i); //값 꺼내오기
			System.out.println(str);
		}

		for (String s : list) { //enhanced for

			System.out.println(s);
		}

	}

}
```

## 학생의 수강과목 학점 출력하기
Lee 학생은 두 과목을 수강하고, Kim 학생은 세 과목을 수강합니다. 각 학생의 학점과 총점을 다음과 같이 출력해봅시다.

Student  클래스에 ArrayList 멤버변수를 하나 가지고 각 학생이 수강하는 과목을 관리 하도록 합니다.

출력예시:<br>
<img src="https://github.com/goheeji/TIL/blob/master/JAVA/arrayList/2.png"><br>

- Student.java

```java
package array;

import java.util.ArrayList;

public class Student {

	int studentID;
	String studentName;
	ArrayList<Subject> subjectList;

	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;

		subjectList = new ArrayList<Subject>();
	}

	public void addSubject(String name, int score) {
		Subject subject = new Subject(name, score);

		subjectList.add(subject);
	}

	public void showStudentInfo() {
		int total = 0;

		for (Subject subject : subjectList) {

			total += subject.getScore();
			System.out.println(studentName + "학생의 " + subject.getName()
					+ "과목의 성적은" + subject.getScore() + "점 입니다.");
		}
		System.out.println(studentName + "학생의  총 점은" + total + "점 입니다.");
	}

}

```

- Subject.java

```java
package array;

public class Subject {

	private String name;
	private int score;
	
	public Subject(String name, int score){
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

```

- StudentTest.java

```java
package array;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student(1001, "Lee");
		
		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 90);
		
		Student studentKim = new Student(1002, "Kim");
		
		studentKim.addSubject("국어", 100);
		studentKim.addSubject("수학", 90);
		studentKim.addSubject("영어", 80);
		
		studentLee.showStudentInfo();
		System.out.println("==========================");
		studentKim.showStudentInfo();

	}

}

```