# [프로그래머스]제일 작은 수 제거하기 Level 1

```java
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int index = 0;
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		if (arr.length  > 1) {
            answer = new int[arr.length-1];
			for (int i = 0; i < arr.length; i++) {
                
				if (min != arr[i]) {
                    
					answer[index++] = arr[i];
				}
			}

		}else{
			answer = new int[index+1];
			answer[index] = -1;
            
		}
        return answer;
        
    }
}
```