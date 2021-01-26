package classex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
//		//1. ������������
//		Class c1 = String.class; 
//		
//		//2. Ŭ�����κ��� �ν��Ͻ�
//		String str = new String();
//		Class C2 = str.getClass();
		
		//3.���� �ε� 
		//Ŭ���� ������ �˼��ִ�.
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
