# [프로그래머스]정수 내림차순으로 배치하기 Level 1

```java
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
		String s = Long.toString(n);
	    String[] arr = s.split("");
	    Arrays.sort(arr);
	    Collections.reverse(Arrays.asList(arr));
	    s = String.join("", arr);
        answer = Long.valueOf(s);
        
        return answer;
    }
}
```