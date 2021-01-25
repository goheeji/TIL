# 인터페이스란
## 인터페이스의 요소
- 추상 메서드
- 상수
- 디폴트 메서드
- 정적 메서드
- private 메서드

## 인터페이스 선언과 구현 
그림1
실선- 상속 점선-구현

## 타입 상속과 형 변환

```java
Calc calc = new CompleteCalc();
```
인터페이스를 구현한 클래스는 인터페이스 타입으로 변수를 선언하여 인스턴스를 생성할 수 있음

인터페이스는 구현 코드가 없기 때문에 타입 상속이라고도함

그림2

# 인터페이스를 활용한 다형성 구현
## 인터페이스의 역할은?
- 인터페이스는 클라이언트 프로그램에 어떤 메서드를 제공하는지 알려주는 명세(specification) 또는 약속
- 한 객체가 어떤 인터페이스의 타입이라 함은 그 인터페이스의 메서드를 구현했다는 의미
- 클라이언트 프로그램은 실제 구현내용을 몰라도 인터페이스의 정의만 알면 그 객체를 사용할 수 있음
- 인터페이스를 구현해 놓은 다양한 객체를 사용함 - 다형성
: JDBC를 구현한 오라클, MSSQL 라이브러리등

## 인터페이스와 다형성 구현하기
그림 3

```java
public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		System.out.println("전화 상담원 할당 방식을 선택하세요");
		System.out.println("R: 한명씩 차례대로");
		System.out.println("L: 대기가 적은 상담원 우선");
		System.out.println("P: 우선순위가 높은 고객 우선 숙련도 높은 상담원");
		
		int ch = System.in.read();
		Scheduler scheduler = null;
		
		if(ch =='R' || ch == 'r'){
			scheduler = new RoundRobin();
		}else if(ch == 'L' || ch == 'l'){
			scheduler = new LeastJob();
		}else if(ch == 'P' || ch == 'p'){
			scheduler = new PriorityAllocation();
		}else{
			System.out.println("지원되지 않는 기능입니다.");
			return;
		}
		scheduler.getNextCall();
		scheduler.sendCallToAgent();

	}

}

```

실행결과: 

```
전화 상담원 할당 방식을 선택하세요
R: 한명씩 차례대로
L: 대기가 적은 상담원 우선
P: 우선순위가 높은 고객 우선 숙련도 높은 상담원
p
고객등급이 높은 고객의 call을 먼저 가져옵니다.
업무 숙련도가 높은 상다뭔에게 먼저 배분합니다.

```

## 인터페이스와 strategy pattern
그림4

## 인터페이스의 사용 예
그림5

# 인터페이스의 요소들
## 인터페이스의 요소
- 상수: 선언된 모든 변수는 상수로 처리 됨
- 메서드: 모든 메서드는 추상 메서드
- 디폴트 메서드: 기본 구현을 가지는 메서드, 구현하는 클래스에서 재정의 할 수 있음(java 8)
- 정적 메서드: 인스턴스 생성과 상관없이 인터페이스 타입으로 호출하는 메서드(java 8)
- private 메서드: 인터페이스 내에서 사용하기 위해 구현한 메서드, 구현하는 클래스에서 재정의 할 수 없음(java 9)

## 여러 개의 인터페이스 구현하기
- 인터페이스는 구현 코드가 없으므로 하나의 클래스가 여러 인터페이스를 구현 할 수 있음
- 디폴트 메서드의 이름이 중복 되는 경우에는 재정의 함
- 그림6

## 인터페이스 상속
- 인터페이스 간에도 상속이 가능함
- 구현이 없으므로 extends뒤에 여러 인터페이스를 상속 받을 수 있음
- 구현 내용이 없으므로 타입 상속(type inheritance)라고 함
- 그림7

## 인터페이스 구현과 클래스 상속 함께 사용하기
그림8

```java
public class BookShelf extends Shelf implements Queue{

	@Override
	public void enQueue(String title) {
		shelf.add(title);
		
	}

	@Override
	public String deQueue() {
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		return getCount();	}

}
```

```java
import java.util.ArrayList;

public class Shelf {
	
	protected ArrayList<String> shelf;
	
	public Shelf(){
		shelf = new ArrayList<String>();
	}
	
	public ArrayList<String> getShelf(){
		return shelf;
	}

	public int getCount(){
		return shelf.size();
	}
}
```

```java
public interface Queue {
	void enQueue(String title);
	String deQueue();
	
	int getSize();

}

```

```java
public class BookShelfTest {

	public static void main(String[] args) {
		Queue bookQueue = new BookShelf();
		bookQueue.enQueue("태백산맥1");
		bookQueue.enQueue("태백산맥2");
		bookQueue.enQueue("태백산맥3");
		bookQueue.enQueue("태백산맥4");
		
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());

	}

}
```

# 코딩해보세요
## 정렬 알고리즘 구현하기
다음과 같이 여러 정렬 구현 알고리즘이 입력에 따라 실행될 수 있도록 구현해 보세요

그림9
그림10
