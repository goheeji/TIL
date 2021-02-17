# [프로그래머스]소수 찾기 Level 1

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] s = new boolean [n+1];
        for(int i =2; i<=n; i++)
            s[i] =true; //2~n 번째 수를 true로 초기화
        // 제곱근 구하기
        int root = (int)Math.sqrt(n);
        
        for(int i =2; i<=root; i++)
            if(s[i]==true){
                for(int j=i; i*j<=n; j++){
                    s[i*j]=false;
                }
            }
        for(int i=2; i<=n;i++){
            if(s[i]==true){
                answer++;
            }
        }
        
        return answer;
    }
}
```