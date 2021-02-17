# [프로그래머스]자연수 뒤집어 배열로만들기 Level 1

```java
class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int [] answer = new int [s.length()];
        for(int i =0; i< s.length();i++){
			answer[i]=s.charAt(s.length()-1-i)-'0';
		}
        return answer;
    }
}
```