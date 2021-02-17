[프로그래머스] k번째 수 Level 1

- 문제 설명
- 생각
- 코드

```java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int arr_index = 0;
        int answer_index = 0;
        
        for(int i =0; i<commands.length; i++){
            int a = commands[i][1]-commands[i][0]+1;
            int arr[] = new int[a];
            for(int j = commands[i][0]-1; j< commands[i][1]; j++){
                arr[arr_index] = array[j];
                arr_index++;
            }
            
            Arrays.sort(arr);
            answer[answer_index] = arr[commands[i][2]-1];
            answer_index++;
            arr_index = 0;
        }
            return answer;
    }
}
```
- 알고리즘 풀이:

https://ju-nam2.tistory.com/3?category=861366
