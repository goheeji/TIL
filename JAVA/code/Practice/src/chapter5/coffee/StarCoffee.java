package chapter5.coffee;

public class StarCoffee {

	int money;

	public String brewing(int money) {

		this.money += money;
		if (money == 4000) {
			return "별다방 아메리카노를 구입했습니다.";
		} else if (money == 4500) {
			return "별다방 라떼를 구입했습니다.";
		} else {
			return null;
		}
	}

}
