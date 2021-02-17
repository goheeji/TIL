# [프로그래머스]하샤드 수 Level 1

```java
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int mok = x;
		int sum =0;
        while(mok!=0){
			sum +=(mok%10);
			mok = mok/10;
		}
		if(x%sum == 0){
			answer = true;
		}else answer = false;
        return answer;
    }
}
```