# function
## 함수란 무엇인가요?
**함수 (function)**

- 하나의 기능을 수행하는 일련의 코드

- 함수는 호출하여 사용하고 기능이 수행된 후 값을 반환 할 수 있음

- 함수로 구현된 기능은 여러 곳에서 호출되어 사용 될 수 있음

- 함수를 쓰는 것을 "함수를 호출한다"라고 한다.

- 이 결과를 나를 호출해준 함수에 돌려준다 라는것은 반환 값을 리턴할 수 있다는 것.

**함수(function)의 장점**

- 코드의 재사용 가능

- 기능이 분리되어있기 때문에 가독성이 좋다.

- 함수를 나누어서 코딩을 하게되면 디버깅, 코드 업데이트, 버전업을 할때 유용하다.

```
요약: 함수는 분리되어있고 호출해서 사용한다.
```

## 함수의 입력과 반환
**캡쳐 이미지**

들어가는 값을 매개변수라고하며 결과값을 반환값이라고한다. 

매개변수, 함수, 반환값이 함수의 요소지만 함수에 따라서 매개변수, 반환값이 없을수도 있다.

## 함수 정의 하기
함수는 이름, 매개변수, 반환 값, 함수 몸체(body)로 구성됨

```java
int add(int num1, int num2){ //만약에 반환되는 값이 없다면 void 라고 하기 반환값의 타입, 함수이름, 매개변수

int result;
result = num1 + num2;
return result;
}
```


## 실제 코드 쳐보기

```java
package classpart;

public class FuctionTest {

	public static int addNum(int num1, int num2) { // 왜 static이라고 정의했는지는 나중에 설명 여기서는 함수의 기능에 대해서만 얘기한다.
		int result;
		result = num1 + num2;
		return result;
	}

	// 반환값이 없을경우
	public static void sayHello(String greeting) {
		System.out.println(greeting);
	}

	// 매개변수 필요없는 경우
	public static int calcSum() {
		int sum = 0;
		int i;

		for (i = 0; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n1 = 10;
		int n2 = 20;

		// 함수는 호출되어야 사용가능하다.
		int total = addNum(n1, n2); // 함수호출
		// int로 넘어와서 int로 받았다. 반환값이 없으면 값을 받을수 없다.
		
		sayHello("안녕하세요");
		int num = calcSum();

		System.out.println(total);
		System.out.println(num);
	}

}

```

