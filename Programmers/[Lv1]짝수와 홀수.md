# [프로그래머스]짝수와 홀수 Level 1

```java
class Solution {
    public String solution(int num) {
         String answer = "";
       
        if (num%2 == 0){
            answer = "Even";
        }else answer= "Odd";
            
       
        return answer;
    }
}
```

