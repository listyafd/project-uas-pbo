	//abstract class
	abstract class Buyer {
	private String name;
	private String id;
	
	//encapsulation
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	abstract void data(); //abstract method
}
	
	//inheritance
	public class Member extends Buyer{

		//polimorphism overriding
		@Override
		void data() {
			System.out.println(getName() +" with ID "+getId());
		}
	}
//third