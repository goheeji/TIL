# 자바 기본클래스 - Class 클래스
## Class 클래스
- 자바의 모든 클래스와 인터페이스는 컴파일 후 class파일로 생성됨
- class 파일에는 객체의 정보(멤버변수, 메서드, 생성자 등)가 포함되어있음
- Class클래스는 컴파일된 class파일에서 객체의 정보를 가져올 수 있음


## Class 클래스 가져오기

```java
1.	String s = new String();
	Class c = s.getClass();

2. Class c = String.Class;

3. Class c = Class.forName("java.lang.String"); //동적로딩 
```
JDBC를 사용할때 여러 DB lib를 install한 상태에서 내가 필요할때 부를수 있게끔. 컴파일 타임이아닌 런타임때 그때그때 상황에맞게 내가원하는 클래스, 라이브러리를 매칭을 시킬수있다.

## reflection 프로그래밍
- Class 클래스로 부터 객체의 정보를 가져와 프로그래밍 하는 방식
- 로컬에 객체가 없고 자료형을 알 수 없는 경우 유용한 프로그래밍
- java.lang.reflect 패키지에 있는 클래스 활용

```java
import java.lang.reflect.Constructor;

public class StringClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
//		//1. 직접가져오기
//		Class c1 = String.class; 
//		
//		//2. 클래스로부터 인스턴스
//		String str = new String();
//		Class C2 = str.getClass();
		
		//3.동적 로딩 
		//클래스 정보를 알수있다.
		Class c3 = Class.forName("java.lang.String");
//java안의 String에 관련된 Constructor출력
		Constructor[] cons = c3.getConstructors();
		for(Constructor con:cons){
			System.out.println(con);
		}
		
Method [] methods = c3.getMethods();
		for(Method method: methods){
			System.out.println(method);
		}

	}

}

```

## newInstance() 메서드
- Class 클래스 메서드
- new 키워드를 사용하지 않고 인스턴스를 생성

## forName() 메서드와 동적로딩
- Class 클래스 static 메서드
- **동적 로딩이란?** 컴파일 시에 데이터 타입이 모두 binding 되어 자료형이 로딩되는 것(static loading)이 아니라 실행 중에 데이터 타입을 알고 binding 되는 방식
- 실행 시에 로딩되므로 경우에 따라 다른 클래스가 사용될 수 있어 유용함
- 컴파일 타임에 체크할 수 없으므로 해당 문자열에 대한 클래스가 없는 경우 예외(ClassNotFoundException)이 발생 할 수 있음

# 코딩해보세요8
날짜를 구현한 클래스 MyDate가 있습니다.
날짜가 같으면 equals() 메서드의 결과가 true가 되도록 구현해 보세요.
hashCode() 메서드도 구현해 보세요

```java
class MyDate {
	int day;
	int month;
	int year;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyDate) {
			MyDate myDate = (MyDate) obj;
			if ((this.day == myDate.day) && (this.month == myDate.month)
					&& (this.year == myDate.year)) {
				return true;
			}
			return false;

		}
		return false;
	}

	@Override
	public int hashCode() {
		return day+ month + year;
	}
	
	

}

public class MyDateTest {

	public static void main(String[] args) {

		MyDate date1 = new MyDate(10, 12, 2020);
		MyDate date2 = new MyDate(10, 12, 2020);

		System.out.println(date1.equals(date2));
		System.out.println(date1.hashCode());
		System.out.println(date2.hashCode());
	}

}
```