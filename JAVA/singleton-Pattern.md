# static 응용-singleton Pattern
## 단 하나만 존재하는 인스턴스 - singleton pattern
ex) 학교, 회사, 날짜

- 생성자는 private으로 만든다.
- static으로 유일한 객체를 생성
- 외부에서 유일한 객체를 참조할 수 있는 public static get() 메서드 구현<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/singleton-pattern/1.png"><br><br>

```java
package staticex;

public class Company {

	private static Company instance = new Company(); // 자기자신의 타입을 가진 변수 인스턴스를 만든다.
	private Company() {
	}

	public static Company getInstance() { // 외부에서 인스턴스의 생성과 상관없이 호출하기위해 static으로 한다.
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

}

```

```java
package staticex;

public class CompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();
		
		System.out.println(company1);
		System.out.println(company2);
	

	}

}
```
단 하나만 생성이 되므로 company1 과 company2의 값은 같다.

날짜로 예를들면,

이렇게 하면 안된다.

```java
Calendar calendar = new Calendar();
```
이렇게 가져와야한다.

```java
Calendar calendar = Calendar.getInstance();
```