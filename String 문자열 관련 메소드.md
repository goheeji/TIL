# String 문자열 관련 메소드
## charAt
- 문장중 인덱스 위치에 해당하는 문자 추출

```java
public class CharAtTest{
	public static void main(String[] args){
	String str = "안녕하세요";
	char ch = str.charAt(2);
	
	System.out.println(ch) //하
	}
}
```

## subString 
- 원하는 범위만큼 문자열 잘라내기

```java
public class SubStringTest{
	public static void main(String[] args){
	String str = "반갑습니다";
	str = str.subString(1,3)
	
	System.out.println(str) //갑습
	}
}
```

## split
주어진 문자로 분리하여 배열에 저장

```java
public class SplitTest{
	public static void main(String[] args){
	String str = "환영 합 니다"; //띄어쓰기를 포함한 문장
	String strArr[] = str.split(" "); 
	String strArr2[] = str.split(""); 
	
	for (String arr : strArr) {
			System.out.print(arr); // 1
		}
		System.out.println();
		for (String arr : strArr) {
			System.out.println(arr); // 2
		}

		for (String arr : strArr2) {
			System.out.print(arr); // 3
		}
		System.out.println();
		for (String arr : strArr2) {
			System.out.println(arr); // 4
		}
	}
}
```

실행결과:
1. 
```
환영합니다
```
2. 
```
환영
합
니다
```
3. 
```
환영 합 니다
```
4. 
```
환
영

합

니
다
```

# StringTokenizer 클래스
- split은 String클래스의 메소드로 추출한 문자를 배열로 저장
- StringTokenizer는 메소드가 아니라 java.util에 포함되어 있는 자체 클래스임 
- StringTokenizer클래스는 내부에 꼭 넣어야 하는 메소드가 존재함
- 문자열을 토큰이라고 부른다.
- 사용법: 메소드를 이용하여 전체 토큰의 수, 사용할 토큰이 있는지를 판단하여 토큰을 읽어온다.

## StringTokenizer의 3가지 메소드

리턴타입 | 메소드 | 기능
:---: | :---: | ---
int | countTokens | 마지막으로 토큰을 읽어오기전 남아있는 토큰의 수
boolean | hasMoreTokens | 토큰이 남아있으면 true 없으면 false
String | nextToken | 토큰 읽어오기


* 예제1(countTokens과 nextToken 사용 )

```java
import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
	String str = "안녕하세요.반갑습니다.너구리입니다.";
		StringTokenizer s = new StringTokenizer(str,".");
		int cntTokens = s.countTokens();
		for(int i =0 ; i<cntTokens; i++){
			str = s.nextToken();
			System.out.println(str);
		}
	}
}

```

실행결과:

```
안녕하세요
반갑습니다
너구리입니다
```

* 예제2(hasMoreTokens과 nextToken 사용 )

```java
import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
	String str = "안녕하세요.반갑습니다.너구리입니다.";
		StringTokenizer s = new StringTokenizer(str,".");
		while(s.hasMoreTokens()){
			str = s.nextToken();
			System.out.println(str);
		}
	}
}
```
실행결과:

```
안녕하세요
반갑습니다
너구리입니다
```

## indexOf()

String[] strings = new String[] { "A", "B", "C" };
int index = Arrays.asList(strings).indexOf("A"); //0

## refernece
https://hunit.tistory.com/166