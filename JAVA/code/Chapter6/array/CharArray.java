package array;

public class CharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� �Ѱ�
		char[] charArr = new char[26];

		for (int i = 0; i < charArr.length; i++) {
			charArr[i] = (char) (i + 65);
			System.out.println(charArr[i]);

		}

		// ������� �Ѱ�
		char[] alpahbets = new char[26];
		char ch = 'A';

		for (int i = 0; i < alpahbets.length; i++) {
			alpahbets[i] = ch++;
		}
		for (int i = 0; i < alpahbets.length; i++) {
			System.out.println(alpahbets[i] + "," + (int) alpahbets[i]);
		}

	}

}
