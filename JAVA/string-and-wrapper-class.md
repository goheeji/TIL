# 자바 기본 클래스 - String, Wrapper 클래스

## String 클래스
String 클래스 선언하기

```java
String str1 = new String("abc");	//인스턴스로 생성됨
String str2 = "abc";				//상수풀에 있는 문자열을 가리킴

```
그림1

```java
public class StringTest {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1 == str2); //false
		
		String str3 = "abc";
		String str4 = "abc";
		System.out.println(str3 == str4); //true

	}

}
```

## String은 immutable(불변)
- 한번 선언되거나 생성된 문자열을 변경 할 수 없음
- String클래스의 concat() 메서드 혹은 "+"를 이용하여 String을 연결하는 경우 문자열은 새로 생성됨
- 메모리가 낭비 될 수있음

그림2

```java
public class StringTest2 {

	public static void main(String[] args) {
		
		String java = new String("java");
		String android = new String("android");
		System.out.println(System.identityHashCode(java));//366712642
		
		java = java.concat(android);
		System.out.println(java);//javaandroid
		System.out.println(System.identityHashCode(java));//1829164700

	}

}

```
만약에 String을 계속 연결해서 쓰려면 StringBuilder 와 StringBuffer 사용

## StringBuilder 와 StringBuffer
- 가변적인 char[] 배열을 멤버변수라 가지고 있는 클래스
- 문자열을 변경하거나 연결하는 경우 사용하면 편리한 클래스
- StringBuffer는 멀티 쓰레드프로그래밍에서 동기화(Synchronization)이 보장됨
	* 단일 쓰레드 프로그래밍에서는 StringBuilder를 사용하는것이 더 좋음
- toString() 메서드로 String반환

```java
public class StringBuilderTest {

	public static void main(String[] args) {
		String java = new String("java");
		String android = new String("android");
		
		StringBuilder buffer = new StringBuilder(java);
		System.out.println(System.identityHashCode(buffer)); //연결 전 
		buffer.append("android");
		System.out.println(System.identityHashCode(buffer)); //연결 후
		
		java = buffer.toString();

	}

}
```

실행결과:

```
366712642
366712642
```

값이 같다

## Wrapper 클래스
- 기본 자료형에 대한 클래스
그림3