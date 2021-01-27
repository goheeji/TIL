package chapter12;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {

	public static void main(String[] args) {
		
		TravelCustomer customerNeo = new TravelCustomer("너구리", 6, 50);
		TravelCustomer customerHeo = new TravelCustomer("허성현", 16, 50);
		TravelCustomer customerKo = new TravelCustomer("고희지", 26, 100);
		
		List<TravelCustomer> customerList = new ArrayList<TravelCustomer>();
		customerList.add(customerNeo);
		customerList.add(customerHeo);
		customerList.add(customerKo);
		
		System.out.println(customerList);
		System.out.println();
		
		// 1. 고객 명단을 출력합니다.
		System.out.println("1. 고객 명단을 출력합니다.");
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		System.out.println();
		
		// 2. 여행의 총 비용을 계산합니다.
		System.out.println("2. 여행의 총 비용을 계산합니다.");
		int total = customerList.stream().mapToInt(c->c.getPrice()).sum();
		System.out.println(total);
		System.out.println();
		
		// 3. 고객 중 20세 이상인 사람을 (가나다순) 정렬하여 출력합니다.
		System.out.println("3. 고객 중 20세 이상인 사람을 (가나다순) 정렬하여 출력합니다.");
		customerList.stream().filter(c->c.getAge()>=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
	}

}
