package chapter9;

public class BubbleSort implements Sort{

	@Override
	public void asccending(int[] arr) {
		System.out.println("BoubbleSort asccending");
		
	}

	@Override
	public void desccending(int[] arr) {
		System.out.println("BoubbleSort desccending");
		
	}

	@Override
	public void description() {
		Sort.super.description();
		System.out.println("BoubbleSort ¿‘¥œ¥Ÿ.");
	}
	
	

}
