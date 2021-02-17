# [프로그래머스]행렬의 덧셈 Level 1

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;
       // answer = arr1;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				answer[i][j]  += arr2[i][j];
			}
		}
		
        return answer;
    }
}
```