# 객체배열
## 기본자료형 배열과 참조 자료형 배열(객체 배열)

```java
int[] arr = new int[10];
```
그림[1]

```java
Book[] library = new Book[5]; //선언 방법
```
그림[2]
나중에 생성할 객체의 주소값을 담는다.

```java
public class BookArrayTest {

	public static void main(String[] args) {

		Book[] library = new Book[5]; // 책이 5권이 생긴것이아니라 배열이 생긴것이다. 
		
		//책이 5권이 생기려면 다섯번 new를해야한다
		library[0] = new Book("태백산맥1","조정레");
		library[1] = new Book("태백산맥2","조정레");
		library[2] = new Book("태백산맥3","조정레");
		library[3] = new Book("태백산맥4","조정레");
		library[4] = new Book("태백산맥5","조정레");

		for (int i = 0; i < library.length; i++) {

			System.out.println(library[i]); //address값이 출력이된다.
			library[i].showBookInfo();//값이 출력된다.
		}

	}
}

```

## System.arraycopy(src, srcPos, dest, destPos, length); 예제

```java
public class ArrayCopy {

	public static void main(String[] args) {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = { 1, 2, 3, 4, 5 };

		System.arraycopy(arr1, 0, arr2, 1, 3);
		// arr1의 0번째부터 3개(10, 20, 30)가
		// arr2의 1번째 부터 3개(2, 3, 4)자리로 copy된다.

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]); // 1, 10, 20, 30, 5
		}

	}

}
```

## 향상된 for문(enhanced for)
배열 요소의 처음부터 끝까지 모든 요소를 참조 할 때 편리한 반복문

for(변수 : 배열)
배열의 length만큼 변수에 element 값을 넣겠다. 

```java
for(Book book : copyLibrary)
```


## 객체 배열 복사
### 얕은 복사
그림[3]
인스턴스가 같다

//얕은 복사 예제

```java
public class ObjectCopy {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		Book[] copyLibrary = new Book[5];

		library[0] = new Book("태백산맥1", "조정레");
		library[1] = new Book("태백산맥2", "조정레");
		library[2] = new Book("태백산맥3", "조정레");
		library[3] = new Book("태백산맥4", "조정레");
		library[4] = new Book("태백산맥5", "조정레");

		System.arraycopy(library, 0, copyLibrary, 0, 5);

		library[0].setTitle("나목");
		library[0].setAuthor("박완서");

		for (Book book : library) {
			book.showBookInfo();
		}

		System.out.println("===================");

		for (Book book : copyLibrary) {
			book.showBookInfo(); //같이 바뀌었다.
		}
	}

}
```
### 깊은 복사
그림[4]
인스턴스가 다르다.

//깊은복사 예제

```java
public class ObjectCopy2 {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		Book[] copyLibrary = new Book[5];

		library[0] = new Book("태백산맥1", "조정레");
		library[1] = new Book("태백산맥2", "조정레");
		library[2] = new Book("태백산맥3", "조정레");
		library[3] = new Book("태백산맥4", "조정레");
		library[4] = new Book("태백산맥5", "조정레");

		copyLibrary[0] = new Book();
		copyLibrary[1] = new Book();
		copyLibrary[2] = new Book();
		copyLibrary[3] = new Book();
		copyLibrary[4] = new Book();

		for (int i = 0; i < library.length; i++) {
			copyLibrary[i].setTitle(library[i].getTitle());
			copyLibrary[i].setAuthor(library[i].getAuthor());

		}

		library[0].setTitle("나목");
		library[0].setAuthor("박완서");

		for (Book book : library) {
			book.showBookInfo();
		}

		System.out.println("===================");

		for (Book book : copyLibrary) {
			book.showBookInfo(); // 바뀌지 않았다.
		}
	}

}


```
