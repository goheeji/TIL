package staticex;

public class Company {

	private static Company instance = new Company(); // 자기자신의 타입을 가진 변수 인스턴스를
														// 만든다.

	private Company() {
	}

	public static Company getInstance() { // 외부에서 인스턴스의 생성과 상관없이 호출하기위해 static으로
											// 한다.
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

}
