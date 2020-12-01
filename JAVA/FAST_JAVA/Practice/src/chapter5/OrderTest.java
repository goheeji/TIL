package chapter5;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Order order = new Order();

		order.id = "201907210001";
		order.userID = "abc123";
		order.date = "2019년 7월 21일";
		order.name = "홍길순";
		order.number = "PD0345-12";
		order.address = "서울시 영등포구 여의도동 20번지";

		System.out.println("주문번호: " + order.id);
		System.out.println("주문자 아이디: " + order.userID);
		System.out.println("주문 날짜: " + order.date);
		System.out.println("주문자 이름: " + order.name);
		System.out.println("주문 상품 번호: " + order.number);
		System.out.println("배송주소: " + order.address);

	}

}
