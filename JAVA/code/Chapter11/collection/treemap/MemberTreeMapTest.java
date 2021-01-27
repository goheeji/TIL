package collection.treemap;

import collection.treemap.Member;

public class MemberTreeMapTest {

	public static void main(String[] args) {
		
		MemberTreeMap manager = new MemberTreeMap();
		
		Member memberHeo = new Member(300, "Heo");
		Member memberLee = new Member(100, "Lee");
		Member memberGo = new Member(200, "Go");
		Member memberHeo2 = new Member(400, "Heo");
		
		
		manager.addMember(memberLee);
		manager.addMember(memberGo);
		manager.addMember(memberHeo);
		manager.addMember(memberHeo2);
		
		manager.showAllMember();
		
		manager.removeMember(100);
		manager.showAllMember();
		
		
	}

}
