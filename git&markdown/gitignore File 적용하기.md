gitignore File 적용하기
==

#  .gitignore 란?
버전관리에서 제외시킬 파일들의 목록을 가진 설정 파일

#  .gitignore 파일 만들기
## 1. .gitignore파일을 만든다.
* 항상 최상위 디렉토리에 존재해야한다.

* 버전관리에서 제외시킬 파일 또는 디렉터리를 입력한다.

* 문법 예시

```
# : comments

# no .a files
*.a

# but do track lib.a, even though you're ignoring .a files above
!lib.a

# only ignore the TODO file in the current directory, not subdir/TODO
/TODO

# ignore all files in the build/ directory
build/

# ignore doc/notes.txt, but not doc/server/arch.txt
doc/*.txt

# ignore all .pdf files in the doc/ directory
doc/**/*.pdf
```

특정 확장자로 끝나는 파일을 모두 버전관리에서 제외할 때는 `*.파일확장자` 처럼 적어주면 되고, 특정 디렉터리를 모두 제외할 경우 `디렉터리명/` 으로 기입하면 된다.

## 2. 적용하기
### 2.1 .버전관리중인 파일이 없는 상태에서 .gitignore을 적용하고 싶은 경우
.gitignore File을 같이 push

### 2.2 이미 버전관리 중인 파일을 Github에서 삭제하고 .gitignore을 적용하고 싶은 경우
#### 2.2.1 현재 Repository 캐시 모두 삭제

```console
git rm -r --cached .
```
#### 2.2.2 .gitignore와 함께 push

## 3. 성공
Local에서는 .gitignore설정한 파일들이 사라지지않지만 Remote에는 적용되어 올라간 모습을 볼수 있다.
![Alt img](https://github.com/goheeji/TIL/blob/master/git%26markdown/sample.png)
### 참고사항
아래의 사이트에서 운영체제, 개발환경, 프로그래밍언어에 따른 .gitignore파일을 만들어준다.<br>
https://www.toptal.com/developers/gitignore 
![Alt img](https://github.com/goheeji/TIL/blob/master/git%26markdown/sample2.png)

# references
https://nesoy.github.io/articles/2017-01/Git-Ignore
https://velog.io/@aquarius1997/gitignore-%EC%84%A4%EC%A0%95