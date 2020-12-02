## 참조 자료형(reference data type)

 - 변수의 자료형
	- 기본자료형: int, long, float, double
	- 참조 자료형: String, Date, Student 등

변수는 크게 두가지 자료형으로 나눌수있다. 기본 자료형은 사용하는 메모리가 정해져 있지만, 참조 자료형은 클래스에 따라 다르다.

- 클래스형으로 변수를 선언한다
- 대표예) String name;

## 참조 자료형 직접 만들어 사용하기
학생클래스(Student)에 있는 과목 이름, 과목 성적 속성을 과목 클래스(Subject)로 분리하고 Subject 참조 자료형 멤버 변수를 Student에 정의하여 사용한다.
![Alt text](https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/referenceDataType/1.PNG)

```java
public class Student {
	
	int studentID;
	String studentName;
	
	int koreanScore;
	int mathScore;
	int engScore;
	
	String koreanName;
	String mathName;
	String engName;
}
```
위의 코드는 클래스의 성격상 좋은방법이아니다. 학생클래스인데 과목얘기가 더많이 있기 때문이다. Student클래스에서 Subject에 대한 속성은 Subject클래스를 만들자.

```java Student.java
package reference;

public class Student {

	int studentID;
	String studentName;

	Subject korea;
	Subject math; // 참조자료형 타입으로 변수를 선언하고

	public Student(int id, String name) {
		studentID = id;
		studentName = name;

		korea = new Subject();
		math = new Subject(); // 이 변수를 생성자에서 초기화를했다. 코리아와 메스가 생성이된것이다.
	}

	public void setKoreaSubject(String name, int score) {
		korea.score = score;
		korea.subjectName = name;

	}

	public void setMathSubject(String name, int score) {
		math.subjectName = name;
		math.score = score;
	}

}

```

```java Subject.java
package reference;

public class Subject {

	String subjectName;
	int score;
	int subjectID;

}

```




