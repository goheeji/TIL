package array;

public class ArrayTest {

	// 1부터 10까지 배열에 넣고 합을 구해보기
	public static void main(String[] args) {
		/*
		 * int[] arr2 = new int[] { 1, 2, 3 }; // 선언과 동시에 초기화를 할때 갯수 값은 넣진않는다.
		 * 
		 * // 선언과 초기화를 따로 하는 법 int[] arr3; arr3 = new int[] { 1, 2, 3 };
		 */

		int[] arr = new int[10];
		int total = 0;
		// for (int i = 0, num= 1; i < arr.length; i++, num++) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			total += arr[i];
		}
		System.out.println(total);

		double[] dArr = new double[5];
		int count = 0;
		dArr[0] = 1.1; count++;
		dArr[1] = 2.1; count++;
		dArr[2] = 3.1; count++;

		double mtotal = 1;
		for (int i = 0; i < dArr.length; i++) {
			mtotal *= dArr[i];
		}
		System.out.println(mtotal); // 0
		// 유효한 값이 3개밖에없는데 총 5개(dArr.length)를 곱하니까
		// count 변수를 이용한다.

		double mtotal2 = 1;
		for (int i = 0; i < count; i++) {
			mtotal2 *= dArr[i];
			System.out.println(mtotal2);
		}
		System.out.println(mtotal2); //7.161

	}

}
