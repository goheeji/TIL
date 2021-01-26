package abstractex;

public abstract class Computer { //추상 클래스는 상위클래스용 (하위클래스에서 구현이 된다.)
	
	public abstract void display();
	public abstract void typing();
	
	public void turnOn(){
		System.out.println("전원을 켭니다.");
	}

	public void turnOff(){
	System.out.println("전원을 끕니다.");
	}
}
