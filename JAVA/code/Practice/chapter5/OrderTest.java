package chapter5;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Order order = new Order();

		order.id = "201907210001";
		order.userID = "abc123";
		order.date = "2019년 7월 21일";
		order.name = "고희지";
		order.number = "PD0345-12";
		order.address = "서울시 노원구";

		System.out.println("주문 번호: " + order.id);
		System.out.println("주문ID: " + order.userID);
		System.out.println("주문날짜: " + order.date);
		System.out.println("주문자 이름: " + order.name);
		System.out.println("물품번호: " + order.number);
		System.out.println("주문주소: " + order.address);

	}

}
