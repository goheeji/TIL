 [프로그래머스] 가운데 글자 가져오기 Level1

```java
class Solution {
    public String solution(String s) {
        int len = s.length();
        if(len %2==1){
        s = s.substring(len/2,(len/2)+1);    
        }else{
            s=s.substring((len/2)-1,(len/2)+1);
        }    
        return s;
    }
}
```