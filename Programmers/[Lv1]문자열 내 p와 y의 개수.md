[프로그래머스] 문자열 내 p와 y의 개수 Level 1

```java
import java.util.*;
class Solution {
    boolean solution(String s) {
        int countP=0;
        int countY=0;
        String strArr[] = s.split("");
        for(int i =0; i< s.length(); i++){
            if(strArr[i].equals("p")||strArr[i].equals("P")){
	        	  countP++;
            }else if(strArr[i].equals("y")||strArr[i].equals("Y")){
                countY++;
            }
        }
        if(countP==countY)return true;
        else return false;
    }
}
```