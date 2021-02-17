[프로그래머스]수박수박수박수박수박수? Level 1

```java
class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i=0; i<n/2; i++){
            answer+="수박";
            }
        if(n%2==0)return answer;
            else return answer+="수";
    }
}
```