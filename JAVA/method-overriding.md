# 메서드 오버라이딩
## 하위 클래스에서 메서드 재정의 하기

**오버라이딩(overriding)**
: 상위 클래스에 정의된 메서드의 구현 내용이 하위 클래스에서 구현할 내용과 맞지 않는 경우 하위 클래스에서 동일한 이름의 메서드를 재정의 할 수 있음

- 예제의 Customer 클래스의 calcPrice()와 VIPCustomer의 calcPrice() 구현내용은 할인율과 보너스 포인트 적립내용부분의 구현이 다름
- 따라서 VIPCustomer클래스는 calcPrice()메서드를 재정의 해야함

Customer.java

```java
public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;// 보너스 포인트 적립
		return price;// 지불할 가격 리턴
	}
```

VIPCustomer.java

```java
@Override
	public int calcPrice(int price) {
		bonusPoint +=price * bonusRatio;
		return price - (int)(price * salesRatio);
	}
```

## @override 애노테이션(Annotation)
재정의된 메서드라는 의미로 선언부가 기존의 메서드와 다른 경우 에러 발생

- 애노테이션은 컴파일러에게 특정한 정보를 제공해주는 역할
- 주로 사용되는 자바에서 제공되는 애노테이션
그림[1]

## 형 변환과 오버라이딩 메서드 호출

```java
Customer vc = new VIPCustomer();
vc.calcPrice(10000);
```
위 코드에서 calcPrice() 메서드는 어느 메서드가 호출 될 것인가?

**자바에서는 항상 인스턴스 (여기서는 VIPCustomer) 의 메서드가 호출됨**
이것을 가상함수라고 한다.

코드실습

```java
public class OverridingTest {

	public static void main(String[] args) {
		Customer customerLee = new Customer(10010, "이순신");
		customerLee.bonusPoint = 1000;

		VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
		customerKim.bonusPoint = 10000;

		int priceLee = customerLee.calcPrice(10000);
		int priceKim = customerKim.calcPrice(10000);

		System.out.println(customerLee.showCustomerInfo() + "지불 금액은"+ priceLee + "원 입니다.");
		System.out.println(customerKim.showCustomerInfo() + "지불 금액은"+ priceKim + "원 입니다.");
		
		Customer customerNo = new VIPCustomer(10030, "나몰라");
		customerNo.bonusPoint = 10000;
		System.out.println(customerNo.showCustomerInfo() + "지불 금액은"+ customerNo.calcPrice(10000) + "원 입니다.");

	}

}
```

결과:

```
이순신님의 등급은 SILVER이며, 적립된 보너스 포인트는 1100점 입니다.지불 금액은10000원 입니다.
김유신님의 등급은 VIP이며, 적립된 보너스 포인트는 10500점 입니다.지불 금액은9000원 입니다.
나몰라님의 등급은 VIP이며, 적립된 보너스 포인트는 10000점 입니다.지불 금액은9000원 입니다.

```

## 가상 메서드(virtual method)
메서드의 이름과 메서드 주소를 가진 가상 메서드 테이블에서 호출될 메서드의 주소를 참조함

그림[2]

**타입에 기반되어 호출되는게아니라 생성된 인스턴스에 기반해서 호출되는것이 가상메서드 기법이다.**

## 재정의된 메서드의 호출 과정
그림[3]

