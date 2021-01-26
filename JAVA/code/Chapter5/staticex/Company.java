package staticex;

public class Company {

	private static Company instance = new Company(); // �ڱ��ڽ��� Ÿ���� ���� ���� �ν��Ͻ���
														// �����.

	private Company() {
	}

	public static Company getInstance() { // �ܺο��� �ν��Ͻ��� ������ ������� ȣ���ϱ����� static����
											// �Ѵ�.
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

}
