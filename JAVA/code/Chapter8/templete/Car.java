package templete;

public abstract class Car {
	
	public void startCar(){
		
		System.out.println("시동을 켭니다.");
		
	}
	
	public abstract void drive();
	public abstract void stop();
	
	public void turnOff(){
		
		System.out.println("시동을 끕니다.");
		
	}
	
	public void washCar(){} //구현이있는 메서드  하위클래스가 재정의해야 
	
	final public void run(){ //텀플릿 메서드. 순서가있다.
		startCar();
		drive();
		stop();
		turnOff();
		washCar();
	}

}
