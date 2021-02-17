# [프로그래머스]이상한 문자 만들기 Level 1

```java
class Solution {
    public String solution(String s) {
        String answer = "";
        char ch;
        String temp = "";
        // 1. 단어 분할
        String str[] = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            
            // temp 초기화
            temp = "";

            for (int j = 0; j < str[i].length(); j++) {
                ch = str[i].charAt(j);
                // 단어의 자리가 짝수이면 -> 대문자
                // 단어의 자리가 홀수이면 -> 소문자
                if (j % 2 == 0) {
                    if (ch >= 'a' && ch <= 'z')
                        temp += (char) (ch - 32);
                    else {
                        temp += ch;
                    }
                } else {
                    if (ch >= 'A' && ch <= 'Z')
                        temp += (char) (ch + 32);
                    else temp += ch;
                }
            }
            
            if(i != str.length - 1) temp += "";
            str[i] = temp;
            answer += str[i];
        }
        //answer = Arrays.toString(str);
        return answer;
}
}
```