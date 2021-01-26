package classex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
//		//1. 직접가져오기
//		Class c1 = String.class; 
//		
//		//2. 클래스로부터 인스턴스
//		String str = new String();
//		Class C2 = str.getClass();
		
		//3.동적 로딩 
		//클래스 정보를 알수있다.
		Class c3 = Class.forName("java.lang.String");
		
		Constructor[] cons = c3.getConstructors();
		for(Constructor con:cons){
			System.out.println(con);
		}
		
		System.out.println();
		
		Method [] methods = c3.getMethods();
		for(Method method: methods){
			System.out.println(method);
		}

	}

}
