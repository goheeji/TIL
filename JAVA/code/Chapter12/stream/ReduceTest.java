package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {

	@Override
	public String apply(String s1, String s2) {
		if (s1.getBytes().length >= s2.getBytes().length)
			return s1;
		else
			return s2;
	}

}

public class ReduceTest {

	public static void main(String[] args) {
		String[] greetings = { "æ»≥Á«œººø‰~~~", "hello", "Good morning", "π›∞©Ω¿¥œ¥Ÿ." };
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
			if (s1.getBytes().length >= s2.getBytes().length)
				return s1;
			else
				return s2;
		})); // æ»≥Á«œººø‰~~~
		
		System.out.println(Arrays.stream(greetings).reduce(new CompareString()).get());//æ»≥Á«œººø‰~~~

	}

}
