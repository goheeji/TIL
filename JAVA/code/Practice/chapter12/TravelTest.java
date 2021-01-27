package chapter12;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {

	public static void main(String[] args) {
		
		TravelCustomer customerNeo = new TravelCustomer("�ʱ���", 6, 50);
		TravelCustomer customerHeo = new TravelCustomer("�㼺��", 16, 50);
		TravelCustomer customerKo = new TravelCustomer("������", 26, 100);
		
		List<TravelCustomer> customerList = new ArrayList<TravelCustomer>();
		customerList.add(customerNeo);
		customerList.add(customerHeo);
		customerList.add(customerKo);
		
		System.out.println(customerList);
		System.out.println();
		
		// 1. �� ����� ����մϴ�.
		System.out.println("1. �� ����� ����մϴ�.");
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		System.out.println();
		
		// 2. ������ �� ����� ����մϴ�.
		System.out.println("2. ������ �� ����� ����մϴ�.");
		int total = customerList.stream().mapToInt(c->c.getPrice()).sum();
		System.out.println(total);
		System.out.println();
		
		// 3. �� �� 20�� �̻��� ����� (�����ټ�) �����Ͽ� ����մϴ�.
		System.out.println("3. �� �� 20�� �̻��� ����� (�����ټ�) �����Ͽ� ����մϴ�.");
		customerList.stream().filter(c->c.getAge()>=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
	}

}
