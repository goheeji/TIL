package array;

public class TwoDimension {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, 7 } }; // new���� �ʰ� �ٷ� �迭���� �ʱ�ȭ ����

		System.out.println(arr.length); // ���� ����: 2
		System.out.println(arr[0].length);// {1,2,3}: 3
		System.out.println(arr[1].length);// {4,5,6,7}: 4

		System.out.println("");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
