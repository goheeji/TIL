package chapter9;

public interface Sort {
	
	void asccending(int[] arr);
	void desccending(int[] arr);
	
	default void description(){
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
	}

}
