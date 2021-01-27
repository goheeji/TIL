# 컬렉션 프레임 워크 -Stack과 Queue 구현하기
## Stack구현하기
- Last In First Out(LIFO): 맨 마지막에 추가 된 요소가 가장 먼저 꺼내지는 자료구조
- 이미 구현된 클래스가 제공 됨
- ArrayList나 LinkedList로 구현 할 수 있음
- 게임에서 무르기, 최근 자료 가져오기 등에 구현

그림1

```java
import java.util.ArrayList;

class MyStack {

	private ArrayList<String> arrayStack = new ArrayList<String>();

	public void push(String data) {
		arrayStack.add(data);
	}

	public String pop() {
		int len = arrayStack.size();
		if (len == 0) {
			System.out.println("스택이 비었습니다");
			return null;

		}
		return arrayStack.remove(len - 1);
	}

}

public class StackTest {
	public static void main(String[] args) {

		MyStack stack = new MyStack();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}
```

실행결과: 

```
C
B
A
스택이 비었습니다
null

```

## Queue 구현하기
- First In First Out(FIFO): 먼저 저장된 자료가 먼저 꺼내지는 자료구조
- 선착순, 대기열등을 구현할 때 가장 많이 사용되는 자료 구조
- ArrayList나 LinkedList로 구현 할 수 있음
- 그림2

```java
package collection;

import java.util.ArrayList;

class MyQueue {

	private ArrayList<String> arrayQueue = new ArrayList<String>();

	public void enqueue(String data) {
		arrayQueue.add(data);
	}

	public String dequeue() {
		int len = arrayQueue.size();
		if (len == 0) {
			System.out.println("더 이상 꺼낼 데이터가 없습니다.");
			return null;
		}
		return arrayQueue.remove(0);
	}

}

public class QueueTest {

	public static void main(String[] args) {

		MyQueue myQueue = new MyQueue();
		myQueue.enqueue("A");
		myQueue.enqueue("B");
		myQueue.enqueue("C");

		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());

	}

}

```

실행결과:

```
A
B
C
더 이상 꺼낼 데이터가 없습니다.
null
```