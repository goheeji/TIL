# 내부클래스, 람다식, 스트림-내부클래스
## 내부 클래스란?
- 클래스 내부에 구현한 클래스(중첩된 클래스)
- 클래스 내부에서 사용하기 위해 선언하고 구현하는 클래스
- 주로 외부 클래스 생성자에서 내부 클래스를 생성

## 내부 클래스 유형
그림1

인스턴스 내부 클래스와 정적 내부 클래스의 예시

```java
class OutClass {

	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;

	public OutClass() {
		inClass = new InClass();
	}

	//인스턴스 내부 클래스
	class InClass {// 이게 이너클래스 
		int Num = 100;

		//Outclass생성 이후에 InClass가 생성되므로 static 사용 불가
		// static int sInNum = 200; 
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
		}
	}
	public void usingInner(){
		inClass.inTest();
	}
	
	//static InnerClass
	static class inStaticClass{ 
		int inNum = 100;
		static int sInNum = 200;
		
		//일반메서드
		void inTest(){ 
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
		//static 메서드
		static void sTest(){
			//사용불가 sTest는 생성과 상관없이 불리는데 inNum은 인스턴스 변수이므로 
			//System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
	}
}

public class InnerTest {

	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		outClass.usingInner();
		
		OutClass.InClass myInClass = outClass.new InClass();
		myInClass.inTest();
		
		System.out.println();
		
		//바로 staticClass를 생성할수 있다.
		OutClass.inStaticClass sInClass = new OutClass.inStaticClass();
		
		sInClass.inTest();

		//아무생성없이 사용가능
		OutClass.inStaticClass.sTest();
	}

}
```
지역 내부 클래스와 익명 내부 클래스 예시

- 지역내부 클래스

```java
class Outer {
	int outNum = 100;
	static int sNum = 200;
	
	// 메서드이다
	// Runable한 타입의 객체를 반환해라
	Runnable getRunnable(final int i) {

		final int num=100;
		class MyRunnable implements Runnable {

			//run()메서드는 muRunnable()가 반환되어도 언제든지 불릴수 있다.
			//따라서 num과 i는 로컬변수기때문에 유효하지않음 사용불가
			//그래서 지역 내부클래스가 쓰이는 Runnable이라는 메서드에서 지역변수들은 다 상수가된다(final)->값이 바뀔수없으므로
			@Override
			public void run() {
				
				//값 변경 불가
//				num += 10;
//				i = 200;
				System.out.println(num); //참조는 가능
				System.out.println(i); 
				System.out.println(outNum);
				System.out.println(Outer.sNum);
			}
		}
		return new MyRunnable();
	}
}

public class LocalInnerClassTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Runnable runnable = outer.getRunnable(50);
		
		runnable.run();

	}

}

```

- 익명 내부 클래스

위의 코드에서 MyRunnable클래스는 한번 쓰이므로 지운다.

```java
class Outer2 {
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(final int i) {
		
		int num = 100;
		//익명 이너클래스
		return new Runnable(){

			@Override
			public void run() {
				
				System.out.println(num); 
				System.out.println(i); 
				System.out.println(outNum);
				System.out.println(Outer2.sNum);
			}
		};	
	}
	
	//또 다른 익명이너클래스 사용법
	//단 하나의 인터페이스나 단 하나의 추상클래스인경우 클래스이름없이 new키워드를이용해서 바로 생성할 수 있다.
	Runnable runner = new Runnable() { 
		
		@Override
		public void run() {
			System.out.println("test");
			
		}
	};
}

public class AnonymousInnerClassTest {
	
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		outer.runner.run();
		Runnable runnable = outer.getRunnable(50);
		
		runnable.run();

	}

}
```