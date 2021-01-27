package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("너구");
		sList.add("너구리");
		sList.add("너궁");

		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.print(s + " ")); //너구 너구리 너궁 
		System.out.println();
		
		sList.parallelStream().sorted().forEach(s->System.out.print(s + " "));//너구리 너궁 너구 
		System.out.println();
		sList.stream().map(s->s.length()).forEach(s->System.out.print(s + " "));//2 3 2
		

	}

}
