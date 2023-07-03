import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Orders> listOrders = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	static Cafe cafe = new Cafe();
    private static double banyakDiskon;
	
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
				}else {
					throw new Exception("Select an option above!");
				}
			}catch(Exception e) {
				System.out.println("Error "+e);
			}
			System.out.println("Continue? ");
			isContinue = input.next();
		}
	}

	private static void initCafeOrders() {
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
		System.out.println("1. Cashier");
		System.out.println("2. Add member");
		System.out.println("3. Show Members");
		}
	
	public static void initCafeData() {
		Member member1 = new Member();
		member1.setId("0104");
		member1.setName("Lucian");
		
		Member member2 = new Member() ;
		member2.setId("2501");
		member2.setName("Liara");
		
		cafe.getMembers().add(member1);
		cafe.getMembers().add(member2);
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
	public static double discount(double diskon, double totalHarga) {
        double banyakDiskon = (diskon*totalHarga);
        return banyakDiskon;
	}

    public static double discount(int totalHarga,double banyakDiskon){
        return (totalHarga-banyakDiskon);
    }
	

public static void kasir() {
    System.out.println("==================Daftar Menu==================");
    System.out.println("No" + "\t\tNama" + "\t\t\tHarga");
    for (int i = 0; i < listOrders.size(); i++) {
        System.out.println((i + 1) + "\t\t" + listOrders.get(i).namaMakanan + "\t\t\t" + listOrders.get(i).hargaMakanan);
    }

    System.out.println("Apakah punya member?: y/n");
    String aMember = input.next();

    if (aMember.equals("y")) {
        System.out.println("Masukan ID:");
        String id = input.next();
        if (cafe.isAMember(id)) {
            System.out.println("Masukan nama anda: ");
            input.next();

            System.out.println("Masukan pesanan anda: ");
            int pesanan = input.nextInt();

            System.out.println("Masukan jumlah pesanan anda: ");
            int jumlah = input.nextInt();

            int totalHarga = listOrders.get(pesanan - 1).hargaMakanan * jumlah;

            System.out.println("Total belanjaan anda sebesar: Rp " + totalHarga);

            System.out.println("Selamat anda mendapatkan diskon sebesar " + discount(0.05, totalHarga));
            System.out.println("Jadi total belanjaan anda sebesar " + discount(totalHarga, discount(0.05, totalHarga)));
        } else {
            System.out.println("Maaf anda belum terdaftar sebagai member");
            System.out.println("Apakah anda ingin daftar sebagai member? y/n");
            String buat = input.next();
            if (buat.equals("y")) {
            addMember();
            System.out.println("Anda telah terdaftar sebagai member! ");
            }
        }
    } else if (aMember.equals("n")) {
        System.out.println("Apakah anda ingin daftar sebagai member? y/n");
        String buat = input.next();
        if (buat.equals("y")) {
            addMember();
            System.out.println("Anda telah terdaftar sebagai member! ");
        }else if(buat.equals("n")){
            System.out.println("Masukan nama anda: ");
            input.next();

            System.out.println("Masukan pesanan anda: ");
            int pesanan = input.nextInt();

            System.out.println("Masukan jumlah pesanan anda: ");
            int jumlah = input.nextInt();

            int totalHarga = listOrders.get(pesanan - 1).hargaMakanan * jumlah;

            System.out.println("Total belanjaan anda sebesar: Rp " + totalHarga);
        }
    }
}

	
	private static void showMembers() {
		for (Member member : cafe.getMembers()) {
			member.data();
		}
	}

	private static void addMember() {
		Member member = new Member();
		System.out.println("Masukan nama anda: ");
		String name = input.next();
		member.setName(name);
		
		System.out.println("Masukan custom id anda: ");
		String id = input.next();
		member.setId(id);
		cafe.addMember(member);
	}
}

//last