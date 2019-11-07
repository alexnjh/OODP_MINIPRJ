package miniprj;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class BookingApp {
	
	private BookingStatus status;
	private CineplexManager cm = new CineplexManager();
	private ShowTimeManager sm = new ShowTimeManager();
	private BookingManager bm = new BookingManager();
	private MovieManager mm = new MovieManager();
	private DateTimeFormatter parseDate = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
    private  DateTimeFormatter parseTime = DateTimeFormatter.ofPattern("HH:mm");
	
	private Scanner sc = new Scanner(System.in);
	
	public BookingApp() {
		
	}
	
	public void open() {
		
		int index = 0, ticketQty = 0, age = 0, index2 = 0;
		String seatID;
		String seats[];
		String name,contact,email;
		Booking booking;
		
		
		mm.printMovies();
		
		System.out.print("Enter movie index: ");
		index = sc.nextInt();
		
		
		System.out.println();
		
		
		ArrayList<String> dates=new ArrayList<String>();
		LocalDateTime ldt = LocalDateTime.now();
		String Time = ldt.format(parseTime);
		
		for(int i=0;i<8;i++) {
			dates.add(ldt.format(parseDate).toString());
			ldt = ldt.plusDays(1);
		}
		
		ArrayList<ShowTimeItems> temp_st = sm.getAndPrintShowTimeSim(mm.getMovie(index).getTitle(),dates,ldt.format(parseTime).toString());
		
		System.out.print("Select show time: ");
		index2 = sc.nextInt();
		
		ShowTimeItems si = sm.getShowTime(mm.getMovie(index).getTitle(),
				temp_st.get(index2-1).getCineplex(),
				temp_st.get(index2-1).getCinema(),
				temp_st.get(index2-1).getDate(),
				temp_st.get(index2-1).getTiming());
		
		System.out.print("Select number of tickets: ");
		ticketQty = sc.nextInt();
		sc.nextLine();
		seats = new String[ticketQty];
		
		Cineplex temp = cm.getCineplex(si.getCineplex());
		
		temp.printAvailableSeats(si);
		
		for(int i=0;i<ticketQty;i++) {
			System.out.print("Enter seat number(eg, A1): ");
			seatID = sc.nextLine();
			seats[i]=seatID;
		}
		
		System.out.print("Please enter your name: ");
		name = sc.nextLine();
		
		System.out.print("Please enter your age: ");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Please enter your contact number: ");
		contact = sc.nextLine();
		
		System.out.print("Please enter your email: ");
		email = sc.nextLine();
		
		
		
		System.out.println();
		System.out.println("Booking summary");
		System.out.println("----------------------");
		
		System.out.println("[Contact details]");
		System.out.println("Name:			"+name);
		System.out.println("Age:			"+age);
		System.out.println("Contact Number:		"+contact);
		System.out.println("Email:			"+email);
		System.out.println();
		System.out.println("[Ticket details]");
		System.out.println("Cineplex:		"+si.getCineplex());
		System.out.println("Cinema:			"+si.getCinema());
		System.out.println("Date:			"+si.getDate());
		System.out.println("Time:			"+si.getTiming());
		
		System.out.println();
		System.out.println();
		System.out.print("Please confirm your booking [Y/N]: ");
		
		char result = sc.nextLine().charAt(0);
		if(result == 'Y') {
			System.out.println("Booking Successful");
			
		}else {
			System.out.println("Booking Unsuccessful");
		}
		
		
	}
	
}
