package miniprj;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		AdminLoginApp app = new AdminLoginApp();
		BookingApp b_app = new BookingApp();
		
		
		Scanner sc = new Scanner(System.in);
		
		
		int index;
		
		do {
			System.out.println("+---------------------------------------+");
			System.out.println("|					|");
			System.out.println("|					|");
			System.out.println("|  Please select option   		|");
			System.out.println("|					|");
			System.out.println("|					|");
			System.out.println("+---------------------------------------+");
			System.out.println("[1] Customer");
			System.out.println("[2] Admin");
			System.out.println("[3] Exit");
			index = sc.nextInt();
			
			switch(index) {
				case 1:
					b_app.open();
					break;
				case 2:
					app.loginPrint();
					break;
				case 3:
					return;
				default:
					break;
			}
			
		}while(true);

	}

}
