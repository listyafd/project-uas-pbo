import java.util.ArrayList;

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
		public ArrayList<Orders> foodDrinks = new ArrayList<Orders>();
		
		public void memesan(Orders pesanan) {
			this.foodDrinks.add(pesanan);
		}
		
		public void membatalkan(Orders pesanan) {
			this.foodDrinks.remove(pesanan);
		}
		

		//polimorphism overriding
		@Override
		void data() {
			System.out.println(getName() +" with ID "+getId());
			
		}
	}
//third