package chapter9;

public interface Sort {
	
	void asccending(int[] arr);
	void desccending(int[] arr);
	
	default void description(){
		System.out.println("���ڸ� �����ϴ� �˰����Դϴ�.");
	}

}
