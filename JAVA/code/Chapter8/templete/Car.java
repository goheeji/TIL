package templete;

public abstract class Car {
	
	public void startCar(){
		
		System.out.println("�õ��� �մϴ�.");
		
	}
	
	public abstract void drive();
	public abstract void stop();
	
	public void turnOff(){
		
		System.out.println("�õ��� ���ϴ�.");
		
	}
	
	public void washCar(){} //�������ִ� �޼���  ����Ŭ������ �������ؾ� 
	
	final public void run(){ //���ø� �޼���. �������ִ�.
		startCar();
		drive();
		stop();
		turnOff();
		washCar();
	}

}
