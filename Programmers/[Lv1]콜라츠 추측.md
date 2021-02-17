# [프로그래머스]콜라츠 추측 Level 1

```java
class Solution {
    public int solution(long num) {
        int answer = 0;
        while(num != 1)
        {
            if(num % 2 == 0){
                num /= 2;
                answer ++;
            }
            else{
                num = num*3 +1;
                answer ++;
            }
        }
        if(answer < 500){
            return answer;
        }else return answer = -1;
        
    }
}
```