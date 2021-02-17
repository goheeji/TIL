[프로그래머스] 자릿수 더하기 Level 1

```java
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            int num = Character.getNumericValue(ch);
            answer +=num;
        }

        return answer;
    }
}
```