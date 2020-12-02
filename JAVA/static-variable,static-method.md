# static변수와 static메서드
## static 변수
- 여러 인스턴스가 하나의 값을 공유할 필요가 있어서 사용!<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/static/1.png"><br><br>

- static 변수는 처음 프로그램이 로드 될 때 데이터 영역에 생성된다.
- 인스턴스의 생성과 상관 없이 사용할 수 있으므로 클래스 이름으로 참조한다.
```java
Student.serialNum = 100;
```
- 클래스 변수, 정적 변수라고도 한다.

## static 변수와 인스턴스 변수

데이터 영역에 위치한 동일한 메모리를 참조<br>
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/static/2.png"><br><br>

## static 메서드
* static 변수를 위한 기능을 제공하는 static 메서드
* **static메서드에서는 인스턴스 변수를 사용할 수 없음**
* 클래스 이름으로 참조하여 사용하는 메서드

```java
Student.getSerialNum();
```
* 클래스 메서드, 정적 메서드라고도 함.

## 프로그램에서 변수의 유형
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/static/3.png"><br><br>