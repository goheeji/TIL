# [Git] Git 취소하기 명령어 모음
## 1. git add 취소하기
git add를 취소한다는 말은 git status를 했을때 파일 상태를 unstage로 변경한다는 말과 같다.

* 아래와 같이 실수로 `git add .` 명령을 사용하여 모든 파일을 Staging Area에 넣은 경우 `git reset HEAD [file]` 명령어를 통해 `git add` 를 취소할수 있다.

```
“Staging Area” 는 사용자가 git commit 명령을 실행했을 때 Git이 처리할 것들이 있는 곳이다.
```

```bash
$ git add .
$ git reset HEAD
```

* 뒤에 파일명이 없으면 add한 파일 전체를 취소한다.

## 2. git commit 취소하기
너무 일찍 commit을 한 경우, 어떤 파일을 뺴먹고 commit을 한경우
`git reset` 명령어 를 통해 git commit을 취소할 수 있다.

### 1. 우선 commit 목록을 확인한다.

```bash
$ git log
```
### 2. commit을 취소하는 명령어에는 세가지 종류가 있다.

HEAD: 현재 브랜치 마지막 커밋의 스냅샷
Index: 바로 다음에 커밋할 것들
워킹디렉토리: 샌드박스
{: .notice--info}

[여기](https://git-scm.com/book/ko/v2/Git-%EB%8F%84%EA%B5%AC-Reset-%EB%AA%85%ED%99%95%ED%9E%88-%EC%95%8C%EA%B3%A0-%EA%B0%80%EA%B8%B0)를 클릭하면 위의 트리에대한 자세한 설명을 볼 수 있다. 

* --soft
commit을 취소하고 index 보존(add한 상태, staged 상태), 워킹 디렉터리에 보존 

```bash
$ git reset --soft HEAD^
```
* --mixed (기본옵션)
commit을 취소하고 index 취소(add하기 전 상태, unstaged 상태), 워킹 디렉터리에 보존 

```bash
$ git reset --mixed HEAD^ //기본 옵션
$ git reset HEAD^ //위와 동일
$ git reset HEAD~2 //마지막 2개의 commit을 취소
```
* --hard 
commit을 취소하고  index 취소(add하기 전 상태, unstaged 상태), 워킹 디렉터리에서 삭제 

```bash
$ git reset --hard HEAD^ //워킹 디렉터리를 원격저장소의 마지막 commit 상태로 되돌린다.
```
단, 이 명령을 사용하면 원격 저장소에 있는 마지막 commit 이후 워킹 디렉터리와 add했던 파일들이 모두 사라지므로 주의해야한다.
{: .notice--danger}

### 3. commit message 변경하기
commit message를 잘못 적은 경우, `git commit -amend` 명령어를 통해 commit message를 변경 할 수 있다.

```bash
$ git commit --amend
```

## 3. git push 취소하기

이 명령을 사용하면 자신의 local의 내용을 remote에 강제로 덮어쓰기 하는 것이기 때문에 주의해야한다.<br>
되돌아간 commit 이후의 모든 commit정보가 사라지기 때문에 주의해야한다.<br>
특히 협업 프로젝트에서는 동기화 문제가 발생할 수 있으므로 팀원과 상의 후 진행하는것이 좋다.
{: .notice--warning}

### 1. 워킹 디렉터리에서 commit을 되돌린다.
* 가장 최근의 commit을 취소하고 워킹 디렉터리를 되돌린다.

```bash
$ git reset HEAD^
```

* Reflog(브랜치와 HEAD가 지난 몇 달동안에 가리켰였던 커밋) 목록 확인
```bash
$ git reflog 또는 $ git log -g
```

* 원하는 시점으로 워킹 디럭터리를 되돌린다.
```bash
$ git reset HEAD@{number} 또는 $git reset [commit id]
```
### 2. 되돌려진 상태에서 다시 commit을 한다.

```bash
$ git commit -m "commit message"
```

### 3. 원격 저장소에 강제로 push한다. 

* [방법 1] -f 옵션
-force 옵션과 동일하다.
```bash
$ git push origin [branch name] -f
```

* [방법 2] +[branch name]
해당 branch를 강제로 push한다.

```bash
$ git push origin +[branch name]
```
## 4. untracked 파일 삭제하기
git clean 명령은 추적 중이지 않은 파일만 지우는게 기본동작이다. 즉 .gitignore에 명시하여 무시되는 파일은 지우지 않는다.

* 디렉터리를 제외한 파일들만 삭제

```bash
$ git clean -f
```

* -d 옵션: 디렉터리까지 지우는 것

```bash
$ git clean -f -d //디렉터리까지 삭제
```
* -x 옵션: 무시된 파일(.DS_Store나 .gitignore에 등록한 확장자 파일들)까지 모두 지우는 것

```bash
$ git clean -f -d -x //무시된 파일까지 삭제
```
* -n 옵션: 가상으로 실행해보고 어떤 파일들이 지워질지 알려주는 것

```bash
$ git clean -n -d
Would remove build.TMP
Would remove tmp/

$ git clean -n -d -x
Would remove build.TMP
Would remove test.o
Would remove tmp/
```

## Reference
https://gmlwjd9405.github.io/2018/05/25/git-add-cancle.html

