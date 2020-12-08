## 인스턴스
- 클래스로부터 생성된 객체 힙 메모리에 멤버 변수의 크기에 따라 메모리가 생성.
클래스를 기반으로 new키워드를 이용하여 여러개의 인스턴스를 생성한다.


```java
package classpart;

public class StudentTest {

	public static void main(String[] args) {

		Student studentLee = new Student();
		studentLee.studentName = "이순신";
		studentLee.address = "서울";

		studentLee.showStudentInfo();

		Student studentKim = new Student();
		studentKim.studentName = "김유신";
		studentKim.address = "경주";

		studentKim.showStudentInfo();

	}

}

```
어떤 변수이름으로 객체를 생성하게되면 힙(Heap)이라는 메모리에 그 객체가 생성이된다. 객체가 가지는 멤버변수의 사이즈만큼 메모리가 잡힌다. 
이것들을 인스턴스라고한다. 인스턴스들은 각각의 멤버값을 갖게된다.

![Alt text](https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/Instance%26HeapMemory/1.png)

```java
package classpart;

public class Student {

	public int studentID;
	public String studentName;
	public String address;

	public void showStudentInfo() {
		System.out.println(studentName + ", " + address);

	}

	public String getStudentName() {
		return studentName;
	}

}

```
위의 Student클래스에서 studentID, studentName, address들은 클래스에서 전반적으로 쓰는 멤버변수이다. <br>
멤버변수의 생성시기?  new했을때<br> 
생성 위치 ? 힙(Heap)이라는 메모리에 생긴다.
힙(Heap)은 동적메모리라고한다.

![Alt text](https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/Instance%26HeapMemory/2.png)
`StudentLee`라는 값은 스택메모리에 어드레스 사이즈 만큼 생긴다.

힙(Heap)에  studentID, studentName, address가생기고
스택이 가르키는 값이 힙메모리의 주소값이다.

![Alt text](https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/Instance%26HeapMemory/3.png)
`StudentLee.` 했을때 이 주소가 가르키는 그 위치(힙)에있는 멤버변수들을 의미한다. 멤버변수값은 힙(Heap) Area에있다.

![Alt text](https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/Instance%26HeapMemory/4.png)
마찬가지로 `StudentKim`에 대해서도 같다.
힙(Heap) Area에 있는객체들을 인스턴스라고한다.
각각의 인스턴스는 별개의 메모리를 갖는다.

Heap메모리에 잡힌 값이 사라지는 시기
가비지콜렉터(GC)라는 스레드가 쓰지않는 메모리를 수거하는 역할을한다. 
적절한 타이밍에 한번씩 돌면서 더이상 참조되지 않는 메모리들은 가비지콜렉터가 알아서 수거한다. 따라서 메모리 free 할 일이 없다.

## 참조변수와 참조값
```java
Student studentLee = new Student();
System.out.println(studentLee); //참조변수를 출력

```
참조변수를 직접출력해보자.
참조변수에 대한 값을 출력하게되면 출력되는 값의 기본형은 

```
클래스의 풀네임@주소값
```
클래스의 풀네임은 패키지의 네임이 모두 포함된 클래스의 네임이고, 주소값은 힙의 주소를 가리키는 주소값이다. 실제는 아니고 가상 JVM이주는 해시코드값이다. 16진수로 32비트를 나타낸다.

이것을 참조값이라고 한다.

## 용어정리

용어 | 설명
---|---
객체 | 객체 지향 프로그램의 대상, 생성된 인스턴스
클래스 | 객체를 프로그래밍하기 위해 코드로 만든 상태 (코드의 상태)
인스턴스 | 클래스가 메모리에 생성된 상태
멤버변수 | 클래스의 속성, 특성
메서드 | 멤버 변수를 이용하여 클래스의 기능을 구현
참조 변수 | 메모리에 생성된 인스턴스를 가리키는 변수
참조값 | 생성된 인스턴스의 메모리 주소 값

