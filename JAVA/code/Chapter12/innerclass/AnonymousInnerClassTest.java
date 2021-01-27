package innerclass;

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
	
	//또다른 익명이너클래스 사용법
	//단하나의 인터페이스나 단 하나의 추상클래스인경우 클래스이름없이 new키워드를이용해서 바로 생성할 수 있다.
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
