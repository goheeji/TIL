package generic;

public class GenericPrinterTest {

	public static void main(String[] args) {
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		Powder powder = new Powder(); // 持失
		powderPrinter.setMeterial(powder);
		System.out.println(powderPrinter);

		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		Plastic plastic = new Plastic(); // 持失
		plasticPrinter.setMeterial(plastic);
		System.out.println(plasticPrinter);
		
		powderPrinter.printing();
		plasticPrinter.printing();
		
		

	}

}
