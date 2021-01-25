# 추상 클래스

## 추상클래스
- 추상 메서드를 포함한 클래스
- 추상 메서드
	- 구현 코드가 없이 선언부만 있는 메서드

- abstract 예약어 사용
	- 추상클래스는 new(인스턴스화) 할 수 없음

## 추상 클래스 구현

그림[1] 그림[2]

- 메서드와 클래스에 abstract 키워드 사용
- 추상 메서드가 포함된 클래스는 추상 클래스로 선언
-  문법적으로 모든 메서드가 구현되었다고 해도 클래스에 abstract키워드를 사용하면 추상 클래스 =>인스턴스화 하지 않기위해

## 추상 클래스 사용하기

- 추상 클래스는 주로 상속의 상위클래스로 사용됨
- 추상 메서드: 하위 클래스가 구현해야 하는 메서드
- 구현된 메서드: 하위 클래스가 공통으로 사용하는 기능의 메서드
	* 단, 하위클래스에 따라 재정의 할 수 있음

# 추상클래스 응용-템플릿 메서드

## 템플릿 메서드
- 템플릿: 틀이나 견본을 의미
- 템플릿 메서드: 추상 메서드나 구현된 메서드를 활용하여 전체의 흐름(시나리오)를 정의해 놓은 메서드(로직의 흐름은 변하지 않는다)
	* final로 선언하여 재정의 할 수 없게 함
- 템플릿 메서드 패턴: 디자인 패턴의 일종
	* 프레임 워크에서 많이 사용되는 설계 패턴
	* 추상 클래스로 선언된 상의 클래스에서 추상 메서드를 이용하여 전체 구현의 흐름을 정의하고 구체적인 각 메서드 구현은 하위 클래스에 위임함
	* 하위 클래스가 다른 구현을 했다고 해서 템플릿 메서드에 정의된 시나오 대로 수행됨

## 템플릿 메서드 구현하기 예제
그림3

```java
public class AICar extends Car {

	@Override
	public void drive() {
		System.out.println("자율 주행 합니다.");
		System.out.println("자동차가 스스로 방향을 바꿉니다.");

	}

	@Override
	public void stop() {
		System.out.println("스스로 멈춥니다.");

	}

}
```

```java
package templete;

public class ManualCar extends Car {

	@Override
	public void drive() {

		System.out.println("사람이 운전 합니다.");
		System.out.println("사람이 핸들을 조작합니다.");
	}

	@Override
	public void stop() {
		System.out.println("브레이크를 밟아서 정지합니다.");

	}

}

```

```java
public class CarTest {

	public static void main(String[] args) {
		Car aiCar = new AICar();
		aiCar.run();
		System.out.println("==============================");
		Car manualCar = new ManualCar();
		manualCar.run();

	}

}
```

실행결과: 

```
시동을 켭니다.
자율 주행 합니다.
자동차가 스스로 방향을 바꿉니다.
스스로 멈춥니다.
시동을 끕니다.
==============================
시동을 켭니다.
사람이 운전 합니다.
사람이 핸들을 조작합니다.
브레이크를 밟아서 정지합니다.
시동을 끕니다.

```

## final 예약어

- final 변수는 값이 변경 될 수 없는 상수임
	* public static final double pI = 3.14;
	* 오직 한번만 값을 할당할 수있음
- final 메서드는 하위 클래스에서 재정의(overriding) 할 수 없음
- final 클래스는 더 이상 상속되지 않음
	* 예) java의 String 클래스

## public static final 상수 값 정의하여 사용하기
- 프로젝트 구현시 여러 파일에서 공유해야 하는 상수 값은 하나의 파일에 선언하여 사용하면 편리 함

그림4
그림5

# 템플릿 메서드 활용하기
## 템플릿 메서드 활용 예제
Player가 있고 이 Player가 게임을 합니다. 게임에서 Player가 가지는 레벨에 따라 run(), jump(), turn() 세가지 기능을 할 수 있습니다. 각 레벨에 따라 기능가능 여부가 다음과 같습니다.

초보자 레벨: 천천히 달립니다.(run() 가능)
중급자 레벨: 빠르게 달리고(run() 가능), 점프(jump() 가능)할 수 있습니다.
고급자 레벨: 엄청 빠르게 달리고(run() 가능), 점프(jump() 가능)하고 한 바퀴 돌 수 있습니다.(turn() 가능)

플레이어는 go()명령어를 받으면 이 세가지 기능을 수행합니다.
이중 할 수 없는 것은 할 수 없다는 메시지를 보냅니다

실행결과:
그림 6

그림 7

# 코딩해보세요
## 자동차 주행 과정 구현하기

Car 추상클래스를 상속받는 Sonata, Avante, Grandeur, Genessis 클래스가 있습니다. 각 차는 주행하기 위해 다름 메서드의 순서로 움직입니다.

```java
run(){
	start();
	drive();
	stop();
	tunroff();
}
```

run()메서드를 템플릿 메서드로 구현하고 CarTest 클래스를 참고하여 프로그램을 완성하세요.

```java
public class CarTest {

	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();
		
		carList.add(new Sonata());
		carList.add(new Grandeur());
		carList.add(new Avante());
		carList.add(new Genesis());
		for(Car car : carList){
			car.run();
			System.out.println("=================");
		}

	}

}
```

실행결과:
```
Sonata 시동을 켭니다
Sonata 달립니다.
Sonata 멈춥니다.
Sonata 시동을 끕니다.
=================
Grandeur 시동을 켭니다.
Grandeur 달립니다.
Grandeur 멈춥니다.
Grandeur 시동을 끕니다.
=================
Avante 시동을 켭니다.
Avante 달립니다.
Avante 멈춥니다.
Avante 시동을 끕니다.
=================
Genesis 시동을 켭니다
Genesis 달립니다
Genesis 멈춥니다
Genesis 시동을 끕니다
=================

```