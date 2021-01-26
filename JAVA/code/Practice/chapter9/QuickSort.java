package chapter9;

public class QuickSort implements Sort{

	@Override
	public void asccending(int[] arr) {
		System.out.println("QuickSort asccending");
		
	}

	@Override
	public void desccending(int[] arr) {
		System.out.println("QuickSort desccending");
		
	}

	@Override
	public void description() {
		Sort.super.description();
		System.out.println("QuickSort ¿‘¥œ¥Ÿ");
	}

	
}
