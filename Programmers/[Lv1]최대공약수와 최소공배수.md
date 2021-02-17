# [프로그래머스]최대공약수와 최소공배수 Level 1

```java
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int big;
		int small;
		if (n > m) {
			big = n;
			small = m;
		} else {
			big = m;
			small = n;
		}
		answer[0] = gcd(big, small);
		answer[1] = big * small / answer[0];
        return answer;
    }
public int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		} else
			return gcd(b, a % b);
	}
}
```