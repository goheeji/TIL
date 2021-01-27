package lambda;

public class TestStringConcat {

	public static void main(String[] args) {
		StringConcatImp1 imp1 = new StringConcatImp1();
		imp1.makeString("hello", "world");

		StringConcat concat = (s, v) -> System.out.println(s + "," + v);
		concat.makeString("hello", "world");
		
		StringConcat concat2 = new StringConcat(){

			@Override
			public void makeString(String s1, String s2) {
				System.out.println(s1 + "," + s2);	
			}
		};
		concat2.makeString("hello", "world");
	}

}
