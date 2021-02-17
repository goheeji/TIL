[프로그래머스] 문자열 다루기 기본 Level 1

```java
//숫자로만 구성되어있으면 true, 문자가 섞여있으면 false;
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() !=6){
            //문자열 s의 길이가 4도 아니고 6도 아니면 false반환
            return false;
        }else{
            for(int i=0; i<s.length();i++){
                char c = s.charAt(i); //문자열 s에 문자가 있는지 검사
                if(c<'0' || c>'9') return false;
            }
        }
        return answer;
    }
}
```