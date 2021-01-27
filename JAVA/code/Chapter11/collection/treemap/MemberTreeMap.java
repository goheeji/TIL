package collection.treemap;

import java.util.Iterator;
import java.util.TreeMap;


public class MemberTreeMap {
	
	private TreeMap<Integer, Member> treeMap; //Integer에 이미 정렬이 구현이되어있다.

	public MemberTreeMap(){
		treeMap = new TreeMap<Integer, Member>();
	}
	
	public void addMember(Member member){
		treeMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId){
		if(treeMap.containsKey(memberId)){
			treeMap.remove(memberId);
			return true;
		}
		System.out.println("회원 번호가 없습니다.");
		return false;
	}
	public void showAllMember(){
		Iterator<Integer> ir = treeMap.keySet().iterator(); //iterator객체가 key로 순환한다. key값으로 반환
		//hashMap.values().Iterator() //value로 반환
		while(ir.hasNext()){
			int key = ir.next();
			Member member = treeMap.get(key);
			System.out.println(member);
		}
		System.out.println();
	}
}
