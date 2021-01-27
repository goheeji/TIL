package lambda;

//함수형 인터페이스다. 람다식을 위한 인터페이스다.
@FunctionalInterface
public interface MyMaxNumber {
	//함수형 인터페이스는 메서드를 두개이상 선언할 수 없다.
	//익명함수로 처리되기때문에 자료형갯수가 같을때 어느 함수를 호출해야할지 모른다
	int getMaxNumber(int x, int Y);

}
