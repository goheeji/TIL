package collection.set;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
		
		MemberHashSet manager = new MemberHashSet();
		
		Member memberLee = new Member(100, "Lee");
		Member memberGo = new Member(200, "Go");
		Member memberHeo = new Member(300, "Heo");
		Member memberHeo2 = new Member(300, "Heo2");
		
		manager.addMember(memberLee);
		manager.addMember(memberGo);
		manager.addMember(memberHeo);
		manager.addMember(memberHeo2);
		
		manager.showAllMember();
		
		manager.removeMember(100);
		manager.showAllMember();
	}

}
