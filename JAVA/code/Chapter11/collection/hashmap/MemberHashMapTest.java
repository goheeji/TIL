package collection.hashmap;

import collection.hashmap.Member;

public class MemberHashMapTest {

	public static void main(String[] args) {
		
		MemberHashMap manager = new MemberHashMap();
		
		Member memberLee = new Member(100, "Lee");
		Member memberGo = new Member(200, "Go");
		Member memberHeo = new Member(300, "Heo");
		
		manager.addMember(memberLee);
		manager.addMember(memberGo);
		manager.addMember(memberHeo);
		
		manager.showAllMember();
		
		manager.removeMember(100);
		manager.showAllMember();
		
		
	}

}
