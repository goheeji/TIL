# [프로그래머스]핸드폰 번호 가리기 Level 1

```java
class Solution {
    public String solution(String phone_number) {
        String a = "";
        String answer = "";
        a = phone_number.substring(phone_number.length() - 4, phone_number.length());
		for (int i = 0; i < phone_number.length() - 4; i++) {
			answer += "*";
		}
		answer += a;
        return answer;
    }
}
```