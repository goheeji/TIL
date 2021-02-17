# [프로그래머스] 서울에서 김서방 찾기 Level 1

```java
import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        
        int index = Arrays.asList(seoul).indexOf("Kim"); 
        return "김서방은 "+index+"에 있다";
    }
}
```