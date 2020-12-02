# 정보 은닉 information hiding
## 접근 제어자(access modifier)
- 변수 메서드, 생성자에 대한 접근 권한 지정
- public, private, protected, 아무것도 안쓰는 경우(기본 접근 제어자)
- private를 사용하면 클래스 외부에서는 접근 할 수 없음

- public은 외부에 모두 오픈하겠다. 
- private 클래스 내부에서만 사용하겠다. 
- protected 상위클래스가 가진 private 변수나 메소드를 하위클래스에 퍼블릭하게 오픈하고싶을때 사용겠다. (나중에 자세히 살펴봄!)
- 기본접근제어자는 같은 패키지 내에서만 참조가능

private 키워드를 통해서 정보은닉 구현이 가능하다
그방법에 대해서 알아보자

## 정보은닉(information hiding)
- 외부에서 클래스 내부의 정보에 접근하지 못하도록함
	private 키워드를 활용
- private 변수를 외부에서 접근하게 하려면 public 메서드를 제공할수 있다.
- 통상적으로 get set을 많이쓴다.
- 클래스 내부 데이터를 잘못 사용하는 오류를 방지 할 수 있음

```java
public class MyDate {

	private int day;
	private int month;
	private int year;

	private boolean isValid;

	public void setDay(int day) { // 값을 넣을때
		this.day = day;
	}

	public int getDay() { // 값을 가져갈때
		return day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {

		if (month < 1 || month > 12) {
			isValid = false;
		} else
			this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void showDate() {
		if (isValid) {
			System.out.println(year + "년" + month + "월" + day + "일");
		} else {
			System.out.println("유효하지 않은 날짜 입니다.");
		}
	}

}
```

```java
public class MyDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate date = new MyDate();
		
		date.setYear(2020);
		date.setMonth(1200);
		date.setDay(2);
		
		date.showDate();

	}

}

```