# 상속이란?
상속을 잘 배워놓으면 유지보수와 확장성에좋다.
## 클래스에서 상속의 의미
새로운 클래스를 정의 할 때 이미 구현된 클래스를 상속(inheritance)받아서 속성이나 기능이 확장되는 클래스를 구현함

그림[1]

코드의 재사용의 방법이라고 이해하면 안된다. 조금 다르다. 

## 상속을 사용하는 경우
* 상위 클래스는 하위 클래스보다 일반적인 개념과 기능을 가짐
* 하위 클래스는 상위 클래스보다 구체적인 개념과 기능을 가짐

그림[2]

extends 뒤에는 단 하나의 class만 사용할 수 있음 
자바는 single inheritance만을 지원함
(자바에서는 다중상속이 불가능하다.)

## 상속을 사용하여 고객관리 프로그램 구현하기
고객에 등급에 따른 차별화된 서비스를 제공할 수 있습니다. 고객의 등급에 따라 할인율, 적립금이 다르게 적용됩니다. 이러한 경우에 대한 구현을 해보도록 합시다.
그림[3]

### Customer 클래스의 속성
그림[4]

//Customer.java Getter,Setter생략

```java
public class Customer {

	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;

	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;// 보너스 포인트 적립
		return price;// 지불할 가격 리턴
	}
	
	public String showCustomerInfo(){
		return customerName + "님의 등급은" + customerGrade + "이며, 적립된 보너스 포인트는" + bonusPoint + "점 입니다.";
	}

}

```

### Customer를 상속받아 구현하는 VIPCustomer 클래스

VIPCustomer 클래스의 기능:
- 단골고객으로 혜택이 더 다양해짐
- 제품 구매시 10% 할인
- 보너스 포인트 5% 적립
- 담당 상담원 배정
Customer 클래스와 유사하지만, 그보다 더 많은 속성과 기능이 필요
그림[5]

```java
public class VIPCustomer extends Customer {

	double salesRatio;
	private int agentID;

	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
	}

}

```

#### protected  예약어
* 외부클래스에서는 private으로 하위클래스에서 public의 기능을 구현한 키워드
* 상위 클래스에 protected로 선언된 변수나 메서드는 다른 외부 클래스에서는 사용할 수 없지만 하위 클래스에서는 사용가능

#### 접근 제한자(access modifier)의 가시성
그림[6]

### 테스트 시나리오
일반 고객 1명과 VIP고객 1명이 있습니다. 일반 고객의 이름은 이순신, 아이디는 10010, 보너스 포인트는 1000점입니다. VIP 고객의 이름은 김유신 아이디는 10020, 보너스 포인트는 10000점입니다. 

두 고객을 생성하고 이에 대한 고객 정보를 출력해 보세요.

```java
public class CustomerTest {

	public static void main(String[] args) {

		Customer customerLee = new Customer();
		customerLee.setCustomerName("이순신");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());

		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerName("김유신");
		customerKim.setCustomerID(10020);
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());

	}

}

```

상속받은것이 잘 보여지는걸 알수 있다.
