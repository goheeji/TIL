package chapter5.coffee;

public class StarCoffee {

	int money;

	public String brewing(int money) {

		this.money += money;
		if (money == 4000) {
			return "���ٹ� �Ƹ޸�ī�븦 �����߽��ϴ�.";
		} else if (money == 4500) {
			return "���ٹ� �󶼸� �����߽��ϴ�.";
		} else {
			return null;
		}
	}

}
