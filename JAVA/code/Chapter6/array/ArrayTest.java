package array;

public class ArrayTest {

	// 1���� 10���� �迭�� �ְ� ���� ���غ���
	public static void main(String[] args) {
		/*
		 * int[] arr2 = new int[] { 1, 2, 3 }; // ����� ���ÿ� �ʱ�ȭ�� �Ҷ� ���� ���� �����ʴ´�.
		 * 
		 * // ����� �ʱ�ȭ�� ���� �ϴ� �� int[] arr3; arr3 = new int[] { 1, 2, 3 };
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
		// ��ȿ�� ���� 3���ۿ����µ� �� 5��(dArr.length)�� ���ϴϱ�
		// count ������ �̿��Ѵ�.

		double mtotal2 = 1;
		for (int i = 0; i < count; i++) {
			mtotal2 *= dArr[i];
			System.out.println(mtotal2);
		}
		System.out.println(mtotal2); //7.161

	}

}
