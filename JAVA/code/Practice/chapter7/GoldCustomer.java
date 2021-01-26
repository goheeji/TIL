package chapter7;

public class GoldCustomer extends Customer{
	
	double saleRatio;
	
	public GoldCustomer(int customerID, String customerName){
		super(customerID, customerName);
		
		customerGrade = "GOLD";
		saleRatio = 0.1;
		bonusRatio = 0.02;
	}

	public int calcPrice(int price){
		return bonusPoint += (int)(price * bonusRatio);
	}

}
