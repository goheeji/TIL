# 컬렉션 프레임 워크 -List 인터페이스
- Collection 하위 인터페이스
- 객체를 **순서**에 따라 저장하고 관리하는데 필요한 메서드가 선언된 인터페이스
- 배열의 기능을 구현하기 위한 메서드가 선언됨
- ArrayList, Vector, LinkedList

## ArrayList와 Vector
- 객체 배열 클래스
- Vector는 자바2부터 제공된 클래스
- 일반적으로 ArrayList를 더 많이 사용
- Vector는 멀티 쓰레드 프로그램에서 동기화를 지원
- 동기화(synchronization): 두개의 쓰레드가 동시에 하나의리소스에 접근할 때 순서를 맞추어 데이터의 오류가 방지하지 않도록 함
- capacity(용량)와 size(요소의 갯수)는 다른 의미임

## ArrayList와 LinkedList
- 둘다 자료의 순차적 구조를 구현한 클래스
- ArrayList는 배열을 구현한 클래스로 논리적 순서와 물리적 순서가 동일함
- LinkedList는 논리적으로 순차적인 구조지만, 물리적으로는 순차적이지 않을 수 있음
- LinkedList 구조
- 그림1
- LinkedList에서 자료의 추가와 삭제
- 그림2

```java
public class LinkedListTest {
	public static void main(String[] args){
		
		LinkedList<String> myList = new LinkedList<String>();
		
		myList.add("A");
		myList.add("B");
		myList.add("C");
		System.out.println(myList); //[A, B, C]
		
		myList.add(1, "D");
		System.out.println(myList); //[A, D, B, C]
		
		myList.removeLast();
		System.out.println(myList); //[A, D, B]
		
		for(int i=0; i<myList.size(); i++){
			String s = myList.get(i);
			System.out.println(s);
		}
	}

}
```