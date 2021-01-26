package collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("고희지");
		set.add("허성현");
		set.add("너구리");
		set.add("고희지");
		
		System.out.println(set); //한꺼번에 출력 순서대로 출력되지않는다. 중복이 허용되지않는다.
		
		Iterator<String> ir = set.iterator(); //하나씩 출력
		
		while(ir.hasNext()){ //다음 엘리먼트가 있느냐
			String str = ir.next();
			System.out.println(str);
		}
		

	}

}
