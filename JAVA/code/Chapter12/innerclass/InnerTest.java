package innerclass;

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
