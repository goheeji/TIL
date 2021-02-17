# [프로그래머스]정수 제곱근 판별 Level 1

```java
class Solution {
    public long solution(long n) {
        long answer = 0;
        long x = (long) Math.sqrt(n); 
        
        if(n == x*x){
			answer =(long)Math.pow(x+1,2);
		}else
			answer = -1;
        return answer;
    }
}
```