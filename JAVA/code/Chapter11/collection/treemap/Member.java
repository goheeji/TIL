package collection.treemap;

import java.util.Comparator;

public class Member implements Comparator<Member>{

	private int memberId;
	private String memberName;
	
	public Member() {}
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName + "회원님의 아이디는 " + memberId + "입니다.";
	}
	
	@Override
	public int hashCode() {
		return memberId;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Member) {
			Member member = (Member)obj;
			return (this.memberId == member.memberId); 
		}
		
		return false;
	}
	//Comparator를 implements 했을 때
	@Override
	public int compare(Member member1, Member member2) {//this, 매개변수
		return member1.memberId-member2.memberId;
		
	}
	
	//Comparable 을 implement 했을 때
//	@Override
//	public int compareTo(Member member) {
//
//		//return (this.memberId-member.memberId); //id로 정렬 내꺼가 더 컸을때(양수가 반환) 오름차순으로 정렬 내림차순은 *-1 정렬
//		return this.memberName.compareTo(member.getMemberName()); //이름으로 정렬
//	}
	
	

	
}