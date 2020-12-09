# 다차원 배열
- 2차원 이상의 배열
- 지도, 게임, 평면이나 공간을 구현할 때 사용
- 이차원 배열의 예
<img src="https://github.com/goheeji/goheeji.github.io/blob/master/assets/images/java/multi-dimensional-arrays/1.png"><br>
행을 기준으로 열을 돌린다.

//2차원 배열 예제

```java
public class TwoDimension {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6,7 } }; // new하지 않고 바로 배열에서 초기화 가능

		System.out.println(arr.length); // 행의 갯수 2
		System.out.println(arr[0].length);// {1,2,3} 3
		System.out.println(arr[1].length);// {4,5,6,7} 4
		
		System.out.println("");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
```



