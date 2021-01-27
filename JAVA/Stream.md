# 내부식, 람다식, 스트림-스트림
## 스트림(Stream)
cf) java.io의 스트림(입출력을 위한)과는 다르다. 여기서의 스트림은 자료의 연산을 위해 사용하는 객체이다.

- 자료의 대상과 관계없이 동일한 연산을 수행할 수 있는 기능(자료의 추상화)
- 배열, 컬렉션에 동일한 연산이 수행되어 일관성있는 처리 가능
- 한번 생성하고 사용한 스트림은 재사용할 수 없음
- 스트림 연산은 기존 자료를 변경하지 않음
- 중간 연산과 최종 연산으로 구분됨
- 최종 연산이 수행되어야 모든 연산이 적용되는 지연 연산

## 스트림 연산-중간연산
- 중간연산 - filter(), map()
- 조건에 맞는 요소를 추출(filter()) 하거나 요소를 변환함(map())
- 문자열 길이가 5이상인 요소만 출력하기
- 그림1
- 고객 클래스에서 고객 이름만 가져오기
- 그림2

## 스트림 연산-최종연산
- 스트림의 자료를 소모하면서 연산을 수행
- 최종 연산 후에 스트림은 더 이상 다른 연산을 적용할 수 없음<br>

- forEach(): 요소를 하나씩 꺼내 옴
- count(): 요소의 개수
- sum(): 요소의 합

이 외에도 여러가지 최종연산이 있음

## 스트림 사용법

- Arrays에서

```java
import java.util.Arrays;

public class IntArrayTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		int sum = Arrays.stream(arr).sum();
		int count = (int) Arrays.stream(arr).count();
		
		System.out.println(sum); //15
		System.out.println(count); //5
	}

}
```

- Collection에서

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("너구");
		sList.add("너구리");
		sList.add("너궁");

		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.print(s + " ")); //너구 너구리 너궁 
		System.out.println();
		
		sList.parallelStream().sorted().forEach(s->System.out.print(s + " "));//너구리 너궁 너구 
		System.out.println();
		sList.stream().map(s->s.length()).forEach(s->System.out.print(s + " "));//2 3 2
		

	}

}
```

## reduce() 연산
- 정의된 연산이 아닌 프로그래머가 **직접 지정하는 연산**을 적용
- 최종 연산으로 스트림의 요소를 소모하며 연산 수행
- 배열의 모든 요소의 합을 구하는 reduce()연산

그림3

- 두번째 요소로 전달되는 람다식에 따라 다양한 기능을 수행

```java
import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {

	@Override
	public String apply(String s1, String s2) {
		if (s1.getBytes().length >= s2.getBytes().length)
			return s1;
		else
			return s2;
	}

}

public class ReduceTest {

	public static void main(String[] args) {
		String[] greetings = { "안녕하세요~~~", "hello", "Good morning", "반갑습니다." };
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
			if (s1.getBytes().length >= s2.getBytes().length)
				return s1;
			else
				return s2;
		})); // 안녕하세요~~~
		
		System.out.println(Arrays.stream(greetings).reduce(new CompareString()).get());//안녕하세요~~~

	}

}

```

# 내부클래스, 람다식, 스트림-코딩해보세요

패키지 여행을 떠나는 고객들이 있습니다. 여행 비용은 20세 이상은 100만원, 그 미만은 50만원입니다. 다음과 같이 고객 세 명이 여행을 간다고 했을 때, 비용과 고객 명단에 대한 출력을 스트림을 활용하여 만들어 보세요

고객리스트:
그림1

1. 고객 명단을 출력합니다.
2. 여행의 총 비용을 계산합니다.
3. 고객 중 20세 이상인 사람을 (가나다순) 정렬하여 출력합니다.

```java
public class TravelCustomer {

	private String name;
	private int age;
	private int price;

	public TravelCustomer(String name, int age, int price) {
		this.name = name;
		this.age = age;
		this.price = price;
	}

	//getter(), setter() 생략

	public String toString() {
		return name + "," + age + "," + price;
	}

}
```

```java
import java.util.ArrayList;
import java.util.List;

public class TravelTest {

	public static void main(String[] args) {
		
		TravelCustomer customerNeo = new TravelCustomer("너구리", 6, 50);
		TravelCustomer customerHeo = new TravelCustomer("허성현", 16, 50);
		TravelCustomer customerKo = new TravelCustomer("고희지", 26, 100);
		
		List<TravelCustomer> customerList = new ArrayList<TravelCustomer>();
		customerList.add(customerNeo);
		customerList.add(customerHeo);
		customerList.add(customerKo);
		
		System.out.println(customerList);
		System.out.println();
		
		// 1. 고객 명단을 출력합니다.
		System.out.println("1. 고객 명단을 출력합니다.");
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		System.out.println();
		
		// 2. 여행의 총 비용을 계산합니다.
		System.out.println("2. 여행의 총 비용을 계산합니다.");
		int total = customerList.stream().mapToInt(c->c.getPrice()).sum();
		System.out.println(total);
		System.out.println();
		
		// 3. 고객 중 20세 이상인 사람을 (가나다순) 정렬하여 출력합니다.
		System.out.println("3. 고객 중 20세 이상인 사람을 (가나다순) 정렬하여 출력합니다.");
		customerList.stream().filter(c->c.getAge()>=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
	}

}

```