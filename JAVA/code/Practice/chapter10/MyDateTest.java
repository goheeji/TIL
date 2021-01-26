package chapter10;

class MyDate {
	int day;
	int month;
	int year;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyDate) {
			MyDate myDate = (MyDate) obj;
			if ((this.day == myDate.day) && (this.month == myDate.month)
					&& (this.year == myDate.year)) {
				return true;
			}
			return false;

		}
		return false;
	}

	@Override
	public int hashCode() {
		return day+ month + year;
	}
	
	

}

public class MyDateTest {

	public static void main(String[] args) {

		MyDate date1 = new MyDate(10, 12, 2020);
		MyDate date2 = new MyDate(10, 12, 2020);

		System.out.println(date1.equals(date2));
		System.out.println(date1.hashCode());
		System.out.println(date2.hashCode());
	}

}
