package miniprj;
import java.util.Scanner;

public class AdminLoginApp{
	
	
	private String username;
	private String password;
	public int i = 0;
	
	private AdminManager adminmanager = new AdminManager();
	private MovieManager moviemanager = new MovieManager();
	private CineplexManager cineplexmanager = new CineplexManager();
	private ShowTimeManager showtimemanager = new ShowTimeManager();
	private BookingManager bookingmanager = new BookingManager();
	
	
	
	private Scanner sc = new Scanner(System.in);
	
	
	public void loginPrint() {
		i=0;
		while(i<2) {
			System.out.println("Please enter the username: "); 
			Scanner scan = new Scanner(System.in);
			username = scan.nextLine();
			System.out.println("Please enter the password: ");
			password = scan.nextLine();
			if(adminmanager.authenticate(username,password)) {
				System.out.println("Login Successfully!");
				adminMenu();
				return;
			}else {
				System.out.println("Login Failed!");
				i ++;
				continue;
			}
		}
		System.out.println("Too many attempts, returning you back to the main menu...");
	}

	public void adminMenu() {
		
		do {
			System.out.println("Welcome! Please select what you want to do: ");
			System.out.println("=============== ADMIN MENU ===============");
			System.out.println("1. Cineplex settings");
			System.out.println("2. Cinema settings");
			System.out.println("3. Movie settings");
			System.out.println("4. Show time settings");
			System.out.println("5. Booking settings");
			System.out.println("6. Configure system Settings.");
			System.out.println("7. Exit");
			int userInput = sc.nextInt(); 
			switch (userInput) {
				case 1:
					cineplexMenu();
					break;
				case 2:
					//cinemaMenu();
					break;
				case 3:
					movieMenu();
					break;
				case 4:
					showtimeMenu();
					break;
				case 5:
					bookingMenu();
					break;
				case 6:
					systemMenu();
					break;
				case 7:
					return;
				default:
					break;
			}
		}while(true);
	}
	
	private void cineplexMenu() {
		
		do {
		System.out.println("=============== CINEPLEX SETTINGS ===============");
		System.out.println("1. Add Cineplex");
		System.out.println("2. Modify Cineplex");
		System.out.println("3. Remove Cineplex");
		System.out.println("4. Return");
		Scanner input = new Scanner(System.in);
		int adminInput = input.nextInt();
		switch(adminInput) {
		case 1: 
			cineplexmanager.addCineplex();
			break;
		case 2:
			//cineplexmanager.updateCineplex();
			break;
		case 3:
			//cineplexmanager.removeCineplex();
			break;
		case 4:
			return;
		default:
			break;
		}
		}while(true);
	}
	
	private void movieMenu() {
		
		do {
		System.out.println("=============== MOVIE SETTINGS ===============");
		System.out.println("1. Add Movie");
		System.out.println("2. Modify Movie");
		System.out.println("3. Remove Movie");
		System.out.println("4. Return");
		Scanner input = new Scanner(System.in);
		int adminInput = input.nextInt();
		switch(adminInput) {
		case 1: 
			moviemanager.addMovie();
			break;
		case 2:
			moviemanager.updateMovie();
			break;
		case 3:
			System.out.println("Please enter the movie title to remove: ");
			String movieTitle = sc.next();
			moviemanager.removeMovie(movieTitle);
			break;
		case 4:
			return;
		default:
			break;
		}
		}while(true);
	}
	
	private void bookingMenu() {
		
		do {
		System.out.println("=============== BOOKING SETTINGS ===============");
		System.out.println("1. Add new booking");
		System.out.println("2. Update booking");
		System.out.println("3. Remove booking");
		System.out.println("4. Return");
		Scanner input = new Scanner(System.in);
		int adminInput = input.nextInt();
		switch(adminInput) {
		case 1: 
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			return;
		default:
			break;
		}
		}while(true);
	}
	
	private void showtimeMenu() {
		
		do {
		System.out.println("=============== SHOW TIME SETTINGS ===============");
		System.out.println("1. Add new show times");
		System.out.println("2. Update show times");
		System.out.println("3. Remove show times");
		System.out.println("4. Return");
		Scanner input = new Scanner(System.in);
		int adminInput = input.nextInt();
		switch(adminInput) {
		case 1: 
			showtimemanager.addShowTime();
			break;
		case 2:
			//showtimemanager.updateShowTime();
			break;
		case 3:
			//showtimemanager.removeShowTime();
			break;
		case 4:
			return;
		default:
			break;
		}
		}while(true);
	}
	
	private void systemMenu() {
		
		do {
		System.out.println("=============== SYSTEM SETTINGS ===============");
		System.out.println("1. Add Admins");
		System.out.println("2. Modify Admins");
		System.out.println("3. Remove Admins");
		System.out.println("4. Return");
		Scanner input = new Scanner(System.in);
		int adminInput = input.nextInt();
		switch(adminInput) {
		case 1: 
			adminmanager.adminSignup();
			break;
		case 2:
			adminmanager.updateAdmin();
			break;
		case 3:
			System.out.println("Please enter the username to remove: ");
			String username = sc.next();
			if(adminmanager.removeAdmin(username)) {
				System.out.println("Admin removed sucessfully");
			}	
			break;
		case 4:
			return;
		default:
			break;
		}
		}while(true);
	}
}

