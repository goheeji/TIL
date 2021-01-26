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
