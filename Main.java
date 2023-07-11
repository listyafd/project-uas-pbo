import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Orders> listOrders = new ArrayList<>();
	public static ArrayList<Member> members = new ArrayList<Member>();
	static Scanner input = new Scanner(System.in);
	static Cafe cafe = new Cafe(); //deklarasi variable cafe
	private static int totalHarga;

	public static void main(String[] args) {
		initCafeData();
		initCafeOrders();

		
		String isContinue = "y";
		
		while(isContinue.equals("y")) {
			showMenu();
			int selectedMenu = chooseMenu();
			try {
				if(selectedMenu == 1) {
					kasir();
				}else if(selectedMenu == 2) {
					addMember();
				}else if(selectedMenu == 3) {
					showMembers();
				}else if(selectedMenu == 4) {
					menuCafe();
				}else if(selectedMenu == 5) {
					deleteMenu();
				}else if(selectedMenu == 6) {
					updateMenu();
				}else if(selectedMenu == 7) {
					tambahMenu();
				}else {
					throw new Exception("Select an option above!");
				}
			}catch(Exception e) {
				System.out.println("Error "+e.getMessage());
			}
			System.out.println("Continue? ");
			isContinue = input.next();
		}
	}


	private static void initCafeOrders() { //objek-objek Orders 
		Orders menu1 = new Orders("Burger",25000);
		Orders menu2 = new Orders("Pasta",30000);
		Orders menu3 = new Orders("Cake",15000);
		Orders menu4 = new Orders("Coffee",20000);
		Orders menu5 = new Orders("Matcha",20000);
		
		listOrders.add(menu1);
		listOrders.add(menu2);
		listOrders.add(menu3);
		listOrders.add(menu4);
		listOrders.add(menu5);
		
	}

	public static void showMenu() {
		System.out.println("Welcome to DouxHwang Cafe");
		System.out.println("==========================");
		System.out.println("1. Kasir");
		System.out.println("2. Add member");
		System.out.println("3. Show Members");
		System.out.println("4. Show Menu Cafe");
		System.out.println("5. Delete Menu");
		System.out.println("6. Update Menu");
		System.out.println("7. Add Menu");
		}
	
	public static void initCafeData() {
		Member member1 = new Member("9999", "Lian");
		Member member2 = new Member("2501", "Hwang");
		Member member3 = new Member("0104", "Leon");

		cafe.addMember(member1);
		cafe.addMember(member2);
		cafe.addMember(member3);
	}
	
	public static int chooseMenu() {
		int pilihan = 0;
		boolean validInput = false;
		
		while(!validInput) {
			try {
				System.out.println("Choose menu: ");
				pilihan = input.nextInt();
				validInput = true;
			}catch (InputMismatchException e) {
				System.out.println("Invalid input!");
				input.next();
			}
		}
		return pilihan;
	}
	
    //overloading
	
	public static void menuCafe(){
		System.out.println("==================Daftar Menu==================");
		System.out.println("No" + "\t\tNama" + "\t\t\tHarga");
		for (int i = 0; i < listOrders.size(); i++) {
			System.out.println((i + 1) + "\t\t" + listOrders.get(i).namaMakanan + "\t\t\t" + listOrders.get(i).hargaMakanan);
		}
	}
	
	public static double discount(double diskon, double totalHarga) {
		double banyakDiskon = (diskon*totalHarga);
		return banyakDiskon;
	}
	
	public static double discount(int totalHarga,double banyakDiskon){
		return (totalHarga-banyakDiskon);
	}

	public static void kasir() {
		System.out.println("Apakah anda memiliki member? y/n");
		String aMember = input.next();

		if(aMember.equals("y")){
			System.out.println("Masukan ID:");
			String id = input.next();
	
			
		}
	}


	public static void proses(){
		menuCafe();
		System.out.println("Masukan nama anda: ");
		input.next();
		
		try {
			System.out.println("Masukan pesanan anda: ");
			int pesanan = input.nextInt();
			System.out.println("Masukan jumlah pesanan anda: ");
			int jumlah = input.nextInt();
			
			totalHarga = listOrders.get(pesanan - 1).hargaMakanan * jumlah;
			
			System.out.println("Total belanjaan anda sebesar: Rp " + totalHarga);
			if(cafe.isAMember(null)){
			System.out.println("Selamat anda mendapatkan diskon sebesar " + discount(0.05, totalHarga)+"\n");
			System.out.println("Jadi total belanjaan anda sebesar " + discount(totalHarga, discount(0.05, totalHarga))+"\n");
			}
		} catch (Exception e) {
			System.out.println("Masukan menu yang tersedia");
	}
}

	private static void showMembers() {
		for (Member member : cafe.getMembers()) {
			member.data();
		}
	}

	private static void addMember() {
				input.nextLine();

		Member member = new Member(null, null);
		System.out.println("Masukan nama anda: ");
		String name = input.nextLine();
		member.setName(name);
		
		System.out.println("Masukan custom id anda: ");
		String id = input.next();
		member.setId(id);
		cafe.addMember(member);
	}

	    private static void deleteMenu() {
        System.out.println("DELETE MENU");
		
        System.out.println("Masukan nomer menu yang ingin dihapus");
		menuCafe();

        try{
            int nomor = input.nextInt();
            System.out.print("Apakah anda yakin ingin menghapus " +listOrders.get(nomor-1).namaMakanan + " dari menu? y/n");
            input.nextLine();
            String validation = input.nextLine();

            if(validation.equals("y")){
                listOrders.remove(nomor-1);
                System.out.println("Menu makanan berhasil dihapus");
            }else if(validation.equals("n")){
				System.out.println("Anda membatalkan penghapusan menu");
			}else{
				return;
			}
        }catch (Exception e){
            System.out.println("Nomor menu tidak ada");
        }
}

  private static void updateMenu() {
        System.out.println("UPDATE MENU");
        System.out.println("Masukan nomer menu yang ingin diperbarui");
		menuCafe();

        try{
            int nomor = input.nextInt();
            System.out.println("Masukan nama makanan : ");
            input.nextLine();
            String namaMakanan = input.nextLine();
            System.out.println("Masukan harga : ");
            int hargaMakanan = input.nextInt();
            
            Orders orders = new Orders(namaMakanan, hargaMakanan);
            listOrders.set((nomor-1), orders);
        }catch (Exception e){
            System.out.println("Nomor menu tidak ada");
        }
    }

	    private static void tambahMenu() {
        System.out.println("TAMBAH MENU");

        System.out.println("Masukan nama makanan : ");
        input.nextLine();
        String namaMakanan = input.nextLine();
        System.out.println("Masukan harga : ");
        int hargaMakanan = input.nextInt();

        Orders orders = new Orders(namaMakanan, hargaMakanan);
        listOrders.add(orders);
    }
}

//last