

마크다운(markdown) 문법 총정리(수시 업데이트)
================

## 1. 헤더 Headers
* 큰제목: 문서제목

```markdown
This is a H1
=============
```

**적용예**:

This is a H1
=========

* 작은제목: 문서 부제목

```markdown
This is a H2
----------------
```

**적용예**:

This is an H2
----------------



* 글머리: 1~6까지만 지원

```markdown
# This is a H1
## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6
```

**적용예**:

# This is a H1

## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6



## 2.  블럭인용
이메일에서 사용하는 `>` 블럭인용문자를 이용한다.

```markdown
> This is a first blockqoute.
> >This is a second blockquote.
> > > This is a third blockquote.
```
**적용예**:

> This is a first blockquote.
> > This is a second blockquote.
> > > This is a third blockquote.


이 안에서는 다른 마크다운 요소를 포함 할 수 있다.

```markdown
> ### This is a H3
> * List
>  	```
>  	code
> 	```
```

**적용예**:

> ### This is a H3
> * List
> 	```markdown
> 	code
> 	```



## 3. 목록

* 순서 있는 목록(번호)
순서있는 목록은 숫자와 점을 사용한다.

```markdown
1. 첫번째
2. 두번째
3. 세번째
1. 1을 다시 써도 네번째
```
**적용예**:
1. 첫번째

2. 두번째

3. 세번째

4. 1을 다시 써도 네번째

   

* 순서없는 목록(글머리 기호 : `*`, `+`, `-` 지원)

```markdown
  * 가
  	* 나
  		* 다
  
  + 가
  	+ 나
  		+ 다
  
  - 가
  	- 나
  		- 다
```
**적용예**:
* 가
	* 나
		* 다
+ 가
	+ 나
		+ 다
  
- 가
	- 나
		- 다  


**현재까지는 어떤 번호를 입력해도 순서는 내림차순으로 정의된다.**



## 4. 코드강조

4개의 공백 또는 하나의 탭으로 들여쓰기를 만나면 변환되기 시작하여 들여쓰지 않은 행을 만날때까지 변환이 계속된다.
### 4.1 인라인(inline) 코드
`grave`는 키보드상 숫자 1 옆에 `~` 옆에 있다.

`코드강조`

```markdown
블록코드 강조
```
**적용예**:
	 `코드강조`
	 

	 ```
	 블록코드 강조
	 ```



### 4.2 들여쓰기

```markdown
This is a normal paragraph:

    This is a code block.
    
end code block.
```
**적용예**:

This is a normal paragraph:

    This is a code block.

end code block.

***
한줄 띄어 쓰지 않으면 인식이 제대로 안되는 문제가 발생한다.
```markdown
This is a normal paragraph:
    This is a code block.
end code block.
```
**적용예**:
This is a normal paragraph:
    This is a code block.
end code block.



### 4.3 코드블럭

코드블럭은 다음과 같이 2가지 방식을 사용할 수 있습니다.
* `<pre><code>{code}</code></pre>` 이용방식

```markdown
<pre>
<code>
public class MyApp{
	public static void main(String[] args){
		System.out.println("Hello, goeasy");
	}
}
</code>
</pre>
```
**적용예**:

<pre>
<code>
public class MyApp{
	public static void main(String[] args){
		System.out.println("Hello, goeasy");
	}
}
</code>
</pre>



* 코드블럭코드(```)을 이용하는 방법
```markdown
\```java
	public class MyApp{
		public static void main(String[] args){
			System.out.println("Hello, goeasy");
		}
	}
\```
```

**적용예**:

```java
	public class MyApp{
		public static void main(String[] args){
			System.out.println("Hello, goeasy");
		}	
	}	
```

## 5. 수평선

아래 줄은 모두 수평선을 만든다. 마크다운 문서를 미리보기로 출력할 때 페이지 나누기 용도로 많이 사용한다.

```

***

* * *

---

*****

- - -

---------------------------------------
```

**적용예**:

***

* * *

---

*****

- - -

---------------------------------------



## 6. 링크

* 참조링크

```markdown
문법
[link keyword][id]
[id]: URL "Optional Title here"

적용예시
Link: [Google][googlelink]
[googlelink]: https://google.com "Go google"
```
**적용예:**

Link: [Google][googlelink] 
[googlelink]:  https://google.com "Go google"



* 외부링크

```markdown
문법: [Title](link)
적용예시: [Google](https://google.com, "google link")
```
**적용예:**

 Link: [Google](https://google.com, "google link")



* 자동연결

```markdown
일반적인 URL 혹은 이메일주소인 경우 적절한 형식으로 링크를 형성한다.
* 외부링크: <https://example.com>
* 외부링크: https://example.com
* 이메일 링크: <addrres@example.com>
```

**적용예:**
* 외부링크: <https://example.com>
* 외부링크: https://example.com
* 이메일 링크: <addrres@example.com>



## 7. 강조

```markdown
*single asterisks*
_single underscores_
**double asterisks**
__double underscores__
~~cancelline~~
문장중간에 사용할 경우에는 **띄어 쓰기**를 사용하는 것이 좋다.
```
**적용예**:

*single asterisks* <br>
_single underscores_ <br>
**double asterisks** <br>
__double underscores__ <br>
~~cancelline~~ <br>
문장중간에 사용할 경우에는 **띄어 쓰기**를 사용하는 것이 좋다.  



## 8. 이미지

```markdown
![Alt text](/assets/images/markdown-syntax/smile.PNG)
![Alt text](/assets/images/markdown-syntax/smile.PNG "Optional title")
```
**적용예**:<br>
![Alt text](/assets/images/markdown-syntax/smile.PNG)
![Alt text](/assets/images/markdown-syntax/smile.PNG "smile")

사이즈 조절 기능은 없기 때문에 `<img width="" height=""></img>`를 이용한다.
```markdown
<img src="/assets/images/markdown-syntax/smile.PNG" width="100px" height="100px" title="px(픽셀) 크기 설정" alt="smile">
<img src="/assets/images/markdown-syntax/smile.PNG" width="10%" height="10%" title="px(픽셀) 크기 설정" alt="smile">
```
**적용예**:<br>
<img src="/assets/images/markdown-syntax/smile.PNG" width="100px" height="100px" title="px(픽셀) 크기 설정" alt="smile"> 
 <br>
<img src="/assets/images/markdown-syntax/smile.PNG" width="10%" height="10%" title="px(픽셀) 크기 설정" alt="smile">



## 9. 줄 바꿈

3칸 이상 띄어쓰기(`   `)를 하면 줄이 바뀐다.

일반 줄바꿈이 동작하지 않는 환경(설정 및 버전에 따라)의 경우, '3칸 이상의 띄어쓰기'나 \<br>를 활용할 수 있다.

```markdown
* 줄 바꿈을 하기 위해서는 문장 마지막에서 3칸이상을 띄어쓰기 해야한다.
이렇게
* 줄 바꿈을 하기 위해서는 문장 마지막에서 3칸이상을 띄어쓰기 해야한다.___
이렇게

동해물과 백두산이 마르고 닳도록 
하느님이 보우하사 우리나라 만세   <!--띄어쓰기 2번-->
무궁화 삼천리 화려 강산<br>
대한 사람 대한으로 길이 보전하세

```
**적용예**:

* 줄 바꿈을 하기 위해서는 문장 마지막에서 3칸이상을 띄어쓰기 해야한다.<br>이렇게
* 줄 바꿈을 하기 위해서는 문장 마지막에서 3칸이상을 띄어쓰기 해야한다.     
이렇게

동해물과 백두산이 마르고 닳도록 
하느님이 보우하사 우리나라 만세   
무궁화 삼천리 화려 강산<br>
대한 사람 대한으로 길이 보전하세



## 10. Table 표

헤더 셀을 구분할때 3개 이상의 `-`(hyphen/dash) 기호가 필요하다.
헤더 셀을 구분하면서 `:`(Colons)기호로 셀(열/칸) 안에 내용을 정렬할 수 있다.
> 오른쪽 정렬 --- <br>
> 가운데 정렬 :---: <br> 
> 왼쪽 정렬 ---: <br>

가장 좌측과 가장 우측에 있는 `|`(virtical bar) 기호는 생략 가능하다.
```markdown
1 | 2 | 3
---|:---:|---:
오른쪽 정렬 | 가운데 정렬 | 왼쪽정렬
```
**적용예**:

1 | 2 | 3
---|:---:|---:
오른쪽 정렬 | 가운데 정렬 | 왼쪽정렬




## 11. 마크다운 포맷 무시하기

```markdown
*이건데*  \*이렇게\*
```
**적용예**: <br>
*이건데*  \*이렇게\*




## 12. 이모지 emoji
```markdown
:[이모지 텍스트]:
```
**적용예**:
:heart:, :smile:, :revolving_hearts:



* 단축키

window10: `윈도우 키` + `마침표(.)`

mac: `command` + `Control` + `spacce bar`



이모지 텍스트 참조: [emoji](https://doozi316.github.io/markdown/2020/08/10/MD2/, "emojiRef")




## 13. 체크박스(Check Box)
`-`, `*`, `+` 뒤에 띄어쓰기 후 `[]`를 넣어 작성한다. `[]`안에 띄어쓰기를 하면 빈 체크박스, `x`를 넣으면 체크된 체크박스가 생긴다.

```markdown
- [ ] 운동하기
- [x] 강의듣기
```
**적용예**:

- [ ] 운동하기
- [x] 강의듣기



## Reference

* http://nblog.syszone.co.kr/archives/9917

* https://steemit.com/kr/@nand/markdown

* https://heropy.blog/2017/09/30/markdown

* https://gist.github.com/ihoneymon/652be052a0727ad59601















