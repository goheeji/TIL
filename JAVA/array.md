# 배열이란
동일한 자료형의 순차적 자료구조

- 배열 선언하기

```java
int[] arr = new int[10];
int arr[] = new int[10];
```

- 메모리 구조
사진[1]
배열은 물리적인위치와 논리적인 위치가 동일하다.
0번째 부터 시작한다.
배열의 길이: length
배열의 인덱스값 0 ~ length-1

## 배열 문제
문자 배열을 생성하고 출력해 보세요.
대문자를 A-Z까지 배열에 저장하고 이를 다시 출력하는 프로그램을 만들어 보세요.

- 내가 한것
```java
public class CharArray {

	public static void main(String[] args) {
		char[] charArr = new char[26];

		for (int i = 0; i < charArr.length; i++) {
			charArr[i] = (char) (i + 65);
			System.out.println(charArr[i]);

		}

	}

}

```

- 강사님이 한것
```java
public class CharArray {

	public static void main(String[] args) {
		char[] alpahbets = new char[26];
		char ch = 'A';

		for (int i = 0; i < alpahbets.length; i++) {
			alpahbets[i] = ch++;
		}
		for (int i = 0; i < alpahbets.length; i++) {
			System.out.println(alpahbets[i] + "," + (int) alpahbets[i]);
		}

	}

}

```