# [프로그래머스]두 정수 사이의 합 Level1

```java
class Solution {
    public long solution(int a, int b) {
        long sum =0;
        if(a<b){
            for(int i=a; i<b+1; i++){
                sum+=i;
            }
        }else if(a>b){
            for(int i=b; i<a+1; i++){
                sum+=i;
            }
        }else sum = a;
        long answer = 0;
        answer = sum;
        return answer;
    }
}
```

