[프로그래머스] 문자열 내 마음대로 정렬하기 Level 1

- 문제 설명
- 생각
- 코드

```java
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				char c1 = s1.charAt(n);
				char c2 = s2.charAt(n);
				//n번째 문자가 같을 경우에 원본 스트링을 사전순으로
				if(c1 == c2){
					return s1.compareTo(s2);
				}else return c1 -c2;//n번째 값이 작은 문자열로 정렬
			}
			
		});
        return strings;
    }
}
```
- 알고리즘 풀이:

primitive타입이란 https://gbsb.tistory.com/6
https://wave-m.tistory.com/53

Comparator는 기본적으로 Object를 매개변수로 받아서 비교한다. 
따라서, Comparator를 통해 정렬을 하고자할 때 정렬 대상이 primitive타입(기본형 타입)이라면 wrapper 클래스를 이용해 Object로 만들어서 매개변수로 넘겨야 한다.