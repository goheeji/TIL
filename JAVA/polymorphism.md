# 다형성(polymorphism)
## 다형성이란?
- 하나의 코드가 여러 자료형으로 구현되어 실행되는 것
- 같은 코드에서 여러 실행 결과가 나옴

- 정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징중 하나
- 객체지향 프로그래밍의 유연성, 재활용성, 유지보수성에 기본이 되는 특징임

```java
class Animal {

	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal {
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
}

class Tiger extends Animal {
	public void move() {
		System.out.println("호랑이가 네 발로 뜁니다.");
	}
}

class Eagle extends Animal {
	public void move() {
		System.out.println("독수리가가 하늘을 날아갑니다.");
	}
}

public class AnimalTest {

	public static void main(String[] args) {

		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		AnimalTest test = new AnimalTest();
		test.moveAnimal(hAnimal);
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);


	}

	public void moveAnimal(Animal animal) {
		animal.move();

	}

}
```

실행결과:

```
사람이 두발로 걷습니다.
호랑이가 네 발로 뜁니다.
독수리가가 하늘을 날아갑니다.
```

하나의 코드가  다양한 구현을 가질수있는 다형성

## 다형성을 사용함으로써 갖는 장점
- 다양한 여러 클래스를 하나의 자료현(상위 클래스)으로 선언하거나 형변환 하여 각 클래스가 동일한 메서드를 오버라이딩 한 경우, 하나의 코드가 다양한 구현을 실행 할 수 있음

- 유사한 클래스가 추가되는 경우 유지보수에 용이하고 각 자료형마다 다른 메서드를 호출하지 않으므로 코드에 많ㄴ은 if문이 사라짐 3:33
