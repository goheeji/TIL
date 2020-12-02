# this에 대하여
## this의 역할
- 자기자신의 메모리를 가리킴
- 생성자에서 다른 생성자를 호출 함
- 인스턴스 자신의 주소를 반환
## 자기 자신의 메모리를 가리키는 this
[그림1]

## 생성자에서 다른 생성자를 호출

이렇게 사용하지않고,

```java
public Person(){
	this.name = "이름없음"
	this.age = 1;
}
```
이렇게 사용함 

```java
public Person(){
	this("이름없음", 1);
}

public Person(String name, int age){
	this.name = name;
	this.age = age;
}
```
주의점은 this로 다른 생성자를 호출할때 this()가 first statement여야 한다.

## 인스턴스 자신의 주소를 반환

```java
public Person getSelf() {// 이때 반환타입은 자기 클래스타입
		return this; 
	}
```

```java
public class PersonTest {

	public static void main(String[] args) {
		
		Person personKo = new Person("Ko", 25);
		personKo.showInfo();
		System.out.println(personKo);

		Person p = personKo.getSelf();
		System.out.println(p);
	}

}
```
personKo의 출력값과 p의 출력값이 같다

