## 메서드(method)란? 
* 객체의 기능을 구현하기 위해 클래스 내부에 구현되는 함수
* 메서드를 구현함으로써 객체의 기능이 구현 됨
* 메서드의 이름은 사용하는 쪽(클라이언트 코드)에 맞게 명명하는 것이 좋음<br>
예) getStudentName() 

cf)<br>
클래스 이름은 대문자<br>
패키지이름은  소문자<br>
변수와 메서드 이름은 camelNotaion이 좋다.
{: .notice--info}


## 스택 메모리(Stack Memory)
> 함수 호출시 사용되는 메모리 종류

아래의 코드를 보며 스택 메모리의 의미를 알아보자.

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

위의 코드의 `main()`도 함수이다.<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/method/1.png" width="35%" height="35%"><br><br>
메인 함수에서 지역변수 args[], n1, n2가 쌓이고, 그 상태에서 `addNum()`을 부르게 되면 `addNum()`함수가 `main()`함수 위에 잡힌다.<br>
(물리적으로 반드시 위는 아니고 논리적으로 봤을때)<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/method/2.png" width="38%" height="38%"><br><br>

`addNum()`함수에서 사용되는 변수는 num1,num2,result가 있다.<br>
함수가 호출 되는순간 n1(10)에서 num1(10)으로 n2(10)에서 num2(10)로 값이 들어간다.<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/method/3.png" width="42%" height="42%"><br><br> 

`addNum()`함수가 수행이되고 리턴을 하게되면 스택메모리에는 `main()`함수 부분만 남고 `addNum()`함수가 사용한 부분은 사라진다.<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/method/4.png" width="20%" height="20%"><br>


> **스택메모리의 특징은 함수의 호출이 끝나면 자동으로 메모리가 반환된다.**

**지역변수**는 함수 호출시 스택메모리에 생성되서 함수의 호출이 끝나면 사라지는 변수들이다. 

함수의 일종으로 클래스의 메소드들을 계속쓸거다. 함수 사용하는 것에 대해서 익숙해져야한다!