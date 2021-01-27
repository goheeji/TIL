package innerclass;

class OutClass {

	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;

	public OutClass() {
		inClass = new InClass();
	}

	//�ν��Ͻ� ���� Ŭ����
	class InClass {// �̰� �̳�Ŭ���� 
		int Num = 100;

		//Outclass���� ���Ŀ� InClass�� �����ǹǷ� static ��� �Ұ�
		// static int sInNum = 200; 
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
		}
	}
	public void usingInner(){
		inClass.inTest();
	}
	
	//static InnerClass
	static class inStaticClass{ 
		int inNum = 100;
		static int sInNum = 200;
		
		//�Ϲݸ޼���
		void inTest(){ 
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
		//static �޼���
		static void sTest(){
			//���Ұ� sTest�� ������ ������� �Ҹ��µ� inNum�� �ν��Ͻ� �����̹Ƿ� 
			//System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
	}
}

public class InnerTest {

	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		outClass.usingInner();
		
		OutClass.InClass myInClass = outClass.new InClass();
		myInClass.inTest();
		
		System.out.println();
		
		//�ٷ� staticClass�� �����Ҽ� �ִ�.
		OutClass.inStaticClass sInClass = new OutClass.inStaticClass();
		
		sInClass.inTest();

		//�ƹ��������� ��밡��
		OutClass.inStaticClass.sTest();
	}

}
