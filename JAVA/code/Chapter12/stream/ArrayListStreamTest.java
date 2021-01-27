package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("�ʱ�");
		sList.add("�ʱ���");
		sList.add("�ʱ�");

		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.print(s + " ")); //�ʱ� �ʱ��� �ʱ� 
		System.out.println();
		
		sList.parallelStream().sorted().forEach(s->System.out.print(s + " "));//�ʱ��� �ʱ� �ʱ� 
		System.out.println();
		sList.stream().map(s->s.length()).forEach(s->System.out.print(s + " "));//2 3 2
		

	}

}
