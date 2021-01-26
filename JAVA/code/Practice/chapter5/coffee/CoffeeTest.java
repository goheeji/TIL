package chapter5.coffee;

public class CoffeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person goeasy = new Person("goeasy", 10000);
		Person heotuck = new Person("Heotuck",10000);
		StarCoffee starCoffee = new StarCoffee();
		BeanCoffee beanCoffee = new BeanCoffee();
		
		goeasy.buyStarCoffee(starCoffee, 4000);
		heotuck.buyBeanCoffee(beanCoffee, 4500);

	}

}
