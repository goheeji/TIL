# [프로그래머스] 문자열 내림차순으로 배치하기 Level 1

나의 풀이

Arrays.sort(배열)은 오름차순 정렬로 만들어 주는 것이고,

Collections.reverse(Arrays.asList(배열)); 은 일반 배열을 리스트로 변환해준 뒤 reverse 메소드를 활용하여 반전시키는 것이다.

String.join("추가할 문자", 배열); 은 예를 들어 String.join(",",str)이면 
"바나나,사과,망고" 이런식으로 ','가 추가되어 원소들이 나열된다.

```java
import java.util.*;
class Solution {
    public String solution(String s) {
        
        String[] str = s.split("");
        Arrays.sort(str);
        Collections.reverse(Arrays.asList(str));
        
        return String.join("",str);
        
    }
}
```