package interfaceex;

public class CompleteCalc extends Calculator{

	@Override
	public int mul(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int div(int num1, int num2) {
		// TODO Auto-generated method stub
		if(num2 ==0){
		return ERROR;
		}else
		return num1 / num2;
	}
	public void showinfo(){
		System.out.println("��� �����Ͽ����ϴ�.");
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println("������ �� description");
	}
	

}
