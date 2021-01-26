package cooperation;

public class TakeTransTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student studentGo = new Student("goeasy", 5000);
		Student studentHeo = new Student("Heotuck", 10000);

		Bus bus1155 = new Bus(1155);
		Bus bus73 = new Bus(73);
		Subway subwayGreen = new Subway(7);
		Subway subwayBlue = new Subway(4);

		studentGo.takeBus(bus1155);
		studentHeo.takeSubway(subwayBlue);

		studentGo.showInfo();
		studentHeo.showInfo();

		bus1155.showBusInfo();
		bus73.showBusInfo();
		subwayGreen.showSubwayInfo();
		subwayBlue.showSubwayInfo();

	}

}
