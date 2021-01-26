package collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("������");
		set.add("�㼺��");
		set.add("�ʱ���");
		set.add("������");
		
		System.out.println(set); //�Ѳ����� ��� ������� ��µ����ʴ´�. �ߺ��� �������ʴ´�.
		
		Iterator<String> ir = set.iterator(); //�ϳ��� ���
		
		while(ir.hasNext()){ //���� ������Ʈ�� �ִ���
			String str = ir.next();
			System.out.println(str);
		}
		

	}

}
