package innerclass;

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
