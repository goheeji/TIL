package lambda;

interface PrintString{
	void showString(String str);
}
public class TestLambda {

	//자료형으로 선언
	public static void main(String[] args) {

		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("Test");
		
		showMyString(lambdaStr);
		
		//함수의 구현부가 마치 변수 처럼 반환되어서 변수값에 대입되어 메서드가 호출된다.
		PrintString test = returnString();
		test.showString("Test3");
	}
	
	//매개변수로 PrintString type을 받을거다
	public static void showMyString(PrintString p){
		p.showString("Test2");
	}
	
	//메서드의 반환 값으로 사용
	public static PrintString returnString() {
		return s->System.out.println(s + "!!!"); //람다식 자체가 반환이 된다.
	}

}
