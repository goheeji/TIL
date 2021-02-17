# [프로그래머스]x만큼 간격이 있는 n개의 숫자 Level 1

```java
class Solution {
    public long[] solution(long x, int n) {
        long num = x;
        long[] answer = new long[n];
        for(int i =0; i<n; i++){
            answer[i]= num;
            num +=x;
        }
        return answer;
    }
}
```