package array;

public class ArrayCopy {

	public static void main(String[] args) {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = { 1, 2, 3, 4, 5 };

		System.arraycopy(arr1, 0, arr2, 1, 3);
		// arr1의 0번째부터 3개(10, 20, 30)가
		// arr2의 1번째 부터 3개(2, 3, 4)자리로 copy된다.

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]); // 1, 10, 20, 30, 5
		}

	}

}
