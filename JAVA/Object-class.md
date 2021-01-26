# 자바 기본클래스 - Object 클래스
## Object 클래스
- 모든 클래스의 최상위 클래스
- java.lang.Object 클래스
- 모든 클래스는 Object 클래스에서 상속 받음
- 모든 클래스는 Object 클래스의 메서드를 사용할 수 있음
- 모든 클래스는 Object 클래스의 일부 메서드(final을 제외하고)를 재정의 하여 사용할 수 있음

## toString() 메서드
- toString() 메서드의 원형

```java
getClass().getName() + '@' + Integer.toHexString(hashCode())
```

- 객체의 정보를 String으로 바꾸어 사용할 때 유용함
- 자바 클래스 중에는 이미 정의된 클래스가 많음
예) String, Integer, Calendar 등

- 많은 클래스에서 재정의하여 사용

## equals() 메서드
- 두객체의 동일함을 논리적으로 재정의 할 수 있음

- 물리적 동일함: 같은 주소를 가지는 객체
- 논리적 동일함: 같은 학번의 학생, 같은 주문 번호의 주문

- 물리적으로 다른 메모리에 위치한 객체라도 논리적으로 동일함을 구현하기 위해 사용하는 메서드

그림1
- 물리적으로 다른위치에 있지만, 논리적으로는 같은 학생임을 구현해야함

```java
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
	}

}
```

## hashCode() 메서드
- hashCode() 메서드의 반환 값: 인스턴스가 저장된 가상머신의 주소를 10진수로 반환
- 두개의 서로 다른 메모리에 위치한 인스턴스가 동일하다는 것은?
	* 논리적으로 동일:equals()의 반환값이 ture
	* 동일한 hashCode값을 가짐: hashCode()의 반환 값이 동일

```java
class Student{
	int studentNum;
	String studentName;
	
	public Student(int studentNum, String studentName){
		this.studentNum = studentNum;
		this.studentName = studentName;
	}
@Override
	public int hashCode() {//위에 정의한 멤버들을 이용한다
	
		return studentNum;
	}
}
	public class hashCodeTest(){
	System.out.println(Lee.hashCode());
		System.out.println(Shin.hashCode());
		 //재정의 전: 값이다름. 재정의 후: 100 값이 같음.
	}
```

## clone() 메서드

- 객체의 복사본을 만듦
- 기본 틀(prototype)으로 부터 같은 속성 값을 가진 객체의 복사본을 생성할 수 있음
- 객체지향 프로그래밍의 정보은닉에 위배되는 가능성이 있으므로 복제할 객체는 cloneable인터페이스를 명시해야함
- 생성자와는 다르다.


 ```java
 package object;

class Book implements Cloneable{ //interface 명시 
	String title;
	String author;
	
	public Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return author+","+title;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		return super.clone();
	}
	
}

public class ToStringTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("토지", "박경리");
		System.out.println(book);
		
		String str = new String("토지");
		System.out.println(str.toString());

		Book book2 = (Book)book.clone();
		System.out.println(book2); //Cloneable interface명시안하면 오류남
	}

}
 ```


## finalize() 메서드

- 직접 불리는 메서드가 아니고 인스턴스가 힙메모리에서 해제될때 가비지 콜렉터에의해서 수행되는 코드부분이다


