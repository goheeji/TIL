package lambda;

interface PrintString{
	void showString(String str);
}
public class TestLambda {

	//�ڷ������� ����
	public static void main(String[] args) {

		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("Test");
		
		showMyString(lambdaStr);
		
		//�Լ��� �����ΰ� ��ġ ���� ó�� ��ȯ�Ǿ �������� ���ԵǾ� �޼��尡 ȣ��ȴ�.
		PrintString test = returnString();
		test.showString("Test3");
	}
	
	//�Ű������� PrintString type�� �����Ŵ�
	public static void showMyString(PrintString p){
		p.showString("Test2");
	}
	
	//�޼����� ��ȯ ������ ���
	public static PrintString returnString() {
		return s->System.out.println(s + "!!!"); //���ٽ� ��ü�� ��ȯ�� �ȴ�.
	}

}
