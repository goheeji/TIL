package thisex;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person personNoname = new Person();
		personNoname.showInfo();

		Person personKo = new Person("Ko", 25);
		personKo.showInfo();
		System.out.println(personKo);

		Person p = personKo.getSelf();
		System.out.println(p);
	}

}
