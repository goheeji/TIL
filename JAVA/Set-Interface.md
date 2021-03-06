# 컬렉션 프레임워크 - Set Interface
## Iterator로 순회하기
- Collection의 개체를 순회하는 인터페이스
- Iterator() 메서드 호출
그림1

- Iterator에 선언된 메서드
그림2

```java
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("고희지");
		set.add("허성현");
		set.add("너구리");
		set.add("고희지");
		
		System.out.println(set); //한꺼번에 출력 순서대로 출력되지않는다. 중복이 허용되지않는다.
		
		Iterator<String> ir = set.iterator(); //하나씩 출력
		
		while(ir.hasNext()){ //다음 엘리먼트가 있느냐
			String str = ir.next();
			System.out.println(str);
		}
		

	}

}

```

실행결과: 

```
[허성현, 너구리, 고희지]
허성현
너구리
고희지
```

## Set 인터페이스
- Collection 하위의 인터페이스
- 중복을 허용하지 않음
- List는 순서기반 인터페이스지만,  Set은 순서가 없음
- get(i) 메서드가 제공되지 않음(Itrator로 순회해야함)
- 저장된 순서와 출력순서는 다를 수 있음
- 아이디, 주민번호, 사번 등 유일한 값이나 객체를 관리할 때 사용
- HashSet, TreeSet 클래스

## HashSet 클래스
- Set인터페이스를 구현한 클래스
- 중복을 허용하지 않으므로 저장되는 객체의 동일함 여부를 알기 위해 equals()와 hashCode()메서드를 재정의 해야 함

## TreeSet 클래스
- 객체의 **정렬**에 사용되는 클래스
- 중복을 허용하지 않으면서 오름차순이나 내림차순으로 객체를 정렬 함
- 내부적으로 이진 검색 트리(binary search tree)로 구현되어있음
- 이진 검색 트리에 자료가 저장 될 때 비교하여 저장될 위치를 정함
- 객체 비교를 위해 Comparable이나 Comparator 인터페이스를 구현 해야 함(정렬에 대한 메서드를 구현해야함)

## Comparable 인터페이스와 Comparator 인터페이스
- 정렬 대상이 되는 클래스가 구현해야 하는 인터페이스
- Comparable은 compareTo() 메서드를 구현
	
	* 매개 변수와 객체 자신(this)를 비교
- Comparator는 compare() 메서드를 구현
	* 두 개의 매개 변수를 비교
	* TreeSet 생성자에 Comparator가 구현된 객체를 매개변수로 전달
	* 그림3
- 일반적으로 Comparable을 더 많이 사용
- 이미 Comparable이 구현된 경우Comparator를 이용하여 다른 정렬 방식을 정의 할 수 있음

```java
import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2)*(-1);
	}
	
}

public class ComparatorTest {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>(new MyCompare()); //new MyCompare()추가 -> 역순으로 출력됨
		treeSet.add("홍길동");
		treeSet.add("강감찬");
		treeSet.add("이순신");
		
		for(String str : treeSet){
			System.out.println(str); //오름차순으로 정렬이 되어 출력됨-> 역순으로 출력됨
		}

	}

}

```