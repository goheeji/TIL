package string;

public class StringBuilderTest {

	public static void main(String[] args) {
		String java = new String("java");
		String android = new String("android");
		
		StringBuilder buffer = new StringBuilder(java);
		System.out.println(System.identityHashCode(buffer)); //연결 전
		buffer.append("android");
		System.out.println(System.identityHashCode(buffer)); //연결 후
		
		java = buffer.toString();

	}

}
