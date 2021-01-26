package collection.treeset;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("홍길동");
		treeSet.add("강감찬");
		treeSet.add("이순신");
		
		for(String str : treeSet){
			System.out.println(str); //오름차순으로 정렬이 되어 출력됨
		}

	}

}
