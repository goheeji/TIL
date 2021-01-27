package innerclass;

class Outer {
	int outNum = 100;
	static int sNum = 200;
	
	// �޼����̴�
	// Runable�� Ÿ���� ��ü�� ��ȯ�ض�
	Runnable getRunnable(final int i) {

		final int num=100;
		class MyRunnable implements Runnable {

			//run()�޼���� muRunnable()�� ��ȯ�Ǿ �������� �Ҹ��� �ִ�.
			//���� num�� i�� ���ú����⶧���� ��ȿ�������� ���Ұ�
			//�׷��� ���� ����Ŭ������ ���̴� Runnable�̶�� �޼��忡�� ������������ �� ������ȴ�(final)->���� �ٲ�������Ƿ�
			@Override
			public void run() {
				
				//�� ���� �Ұ�
//				num += 10;
//				i = 200;
				System.out.println(num); //������ ����
				System.out.println(i); 
				System.out.println(outNum);
				System.out.println(Outer.sNum);
			}
		}
		return new MyRunnable();
	}
}

public class LocalInnerClassTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Runnable runnable = outer.getRunnable(50);
		
		runnable.run();

	}

}
