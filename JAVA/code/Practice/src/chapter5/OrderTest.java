package chapter5;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Order order = new Order();

		order.id = "201907210001";
		order.userID = "abc123";
		order.date = "2019�� 7�� 21��";
		order.name = "ȫ���";
		order.number = "PD0345-12";
		order.address = "����� �������� ���ǵ��� 20����";

		System.out.println("�ֹ���ȣ: " + order.id);
		System.out.println("�ֹ��� ���̵�: " + order.userID);
		System.out.println("�ֹ� ��¥: " + order.date);
		System.out.println("�ֹ��� �̸�: " + order.name);
		System.out.println("�ֹ� ��ǰ ��ȣ: " + order.number);
		System.out.println("����ּ�: " + order.address);

	}

}
