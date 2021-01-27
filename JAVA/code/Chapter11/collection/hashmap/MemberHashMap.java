package collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;


public class MemberHashMap {
	
	private HashMap<Integer, Member> hashMap;

	public MemberHashMap(){
		hashMap = new HashMap<Integer, Member>();
	}
	
	public void addMember(Member member){
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId){
		if(hashMap.containsKey(memberId)){
			hashMap.remove(memberId);
			return true;
		}
		System.out.println("회원 번호가 없습니다.");
		return false;
	}
	public void showAllMember(){
		Iterator<Integer> ir = hashMap.keySet().iterator(); //iterator객체가 key로 순환한다. key값으로 반환
		//hashMap.values().Iterator() //value로 반환
		while(ir.hasNext()){
			int key = ir.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
		System.out.println();
	}
}
