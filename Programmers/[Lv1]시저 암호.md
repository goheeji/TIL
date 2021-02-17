# [프로그래머스]시저 암호 Level 1

```java
class Solution {
    public String solution(String s, int n) {
        String answer ="";
        for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isLowerCase(ch)) {
				if (ch + n > 'z')
					answer += (char) (ch + n - 26);
				else
					answer += (char) (ch + n);
			} else if(Character.isUpperCase(ch)) {
				if(ch + n > 'Z') 
                    answer += (char) (ch + n - 26);
				else 
                    answer += (char)(ch + n);
			} else answer += (char)ch;
		}
		
        return answer;
    }
}
```