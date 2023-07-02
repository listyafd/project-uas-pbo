import java.util.ArrayList;

public class Cafe {
	//ArrayList
	private ArrayList<Orders> cafe = new ArrayList<Orders>();
	private ArrayList<Member> members = new ArrayList<Member>();
	
	public ArrayList<Orders> getOrders(){
		return this.cafe;
	}
	
	public ArrayList<Member> getMembers(){
		return this.members;
	}
	
	public void setOrders(ArrayList<Orders> cafe) {
		this.cafe = cafe;
	}
	
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	
	public void addMember(Member member) {
		if (!isMemberIdExist(member.getId())){
			this.members.add(member);
		}
	}
	
	public Boolean isMemberIdExist(String id) {
		Boolean isExist = false;
		for (Member member : this.members) {
			if (member.getId().equals(id)) {
				isExist = true;
				System.out.println("This ID already taken");
			}
		}
	return isExist;
	}
	
	public Boolean isAMember(String id) {
		Boolean isMember = false;
		for (Member member : this.members) {
			if (member.getId().equals(id)) {
				isMember = true;
				System.out.println("This ID is a member");
			}
		}
	return isMember;
	}
}

//first