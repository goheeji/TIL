package chapter5.coffee;

public class BeanCoffee {

	int money;

	public String brewing(int money) {
		this.money += money;
		if (money == 4000) {
			return "콩다방 아메리카노를 구입했습니다.";
		} else if (money == 4500) {
			return "콩다방 라떼를 구입했습니다.";
		} else {
			return null;
		}
	}

}
