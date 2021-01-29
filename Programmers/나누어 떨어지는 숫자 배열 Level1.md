# [프로그래머스] 나누어 떨어지는 숫자 배열 Level1
```java
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrList = new ArrayList();
        int[] answer = {};
        answer = Arrays.stream(arr).filter(e -> e%divisor==0).sorted().toArray();
        if(answer.length ==0){
            arrList.add(-1);
         int [] result = new int[arrList.size()];
		for(int i =0; i<result.length;i++){
			result[i]= arrList.get(i).intValue();
		}
         return result;
		    
        }else return answer;
    }
}
```

```java
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        answer = Arrays.stream(arr).filter(e ->e%divisor==0).sorted().toArray();
        if(answer.length== 0){
            answer = new int[1];
            answer[0]=-1;
        }
        return answer;
    }
}
```