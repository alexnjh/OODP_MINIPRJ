package miniprj;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cineplex implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String location;
	private BookingManager bm = new BookingManager();
	private ArrayList<Cinema> listOfCinemas = new ArrayList<Cinema>();
	private transient Scanner sc = new Scanner(System.in);
	
	public Cineplex(String name,String loc,ArrayList<Cinema> noOfCinema){
		this.name = name;
		this.location = loc;
		listOfCinemas = noOfCinema;
	}
	
	public Cineplex(){
		int noSeats, cClass, noSeatsPerRow;
		int id;
		String cin_name;
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("Setting up Cineplex");
		System.out.println();
		System.out.println("-----------------------------------------------");
		
		System.out.println("-----------------------------------------------");
		System.out.println("Please enter cineplex name: ");
		System.out.println("-----------------------------------------------");
		name = sc.nextLine();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Please enter cineplex location: ");
		System.out.println("-----------------------------------------------");
		location = sc.nextLine();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Please enter number of cinemas to create: ");
		System.out.println("-----------------------------------------------");
		int noOfCinema = sc.nextInt();
		sc.nextLine(); // Remove trailing newline
		
		for(int i=0; i<noOfCinema; i++) {
			id = name.concat(location).hashCode();
			
			System.out.println("-----------------------------------------------");
			System.out.println("Please enter cinema name for Cinema "+(i+1)+": ");
			System.out.println("-----------------------------------------------");
			cin_name = sc.nextLine();
			while(cin_name.length() == 0) {
				System.out.println("Invalid input! Please enter name for Cinema "+(i+1)+":");
				cin_name = sc.nextLine();
			}
			
			System.out.println("-----------------------------------------------");
			System.out.println("Please enter number of seats for Cinema "+(i+1)+": ");
			System.out.println("-----------------------------------------------");
			noSeats = sc.nextInt();
			while(noSeats < 20) {
				System.out.println("Seat number to low! Please enter number of seats for Cinema "+(i+1)+":");
				noSeats = sc.nextInt();
			}
			
			System.out.println("-----------------------------------------------");
			System.out.println("Please enter number of seats per row for Cinema "+(i+1)+": ");
			System.out.println("-----------------------------------------------");
			noSeatsPerRow = sc.nextInt();
			while(noSeatsPerRow < 5 || noSeatsPerRow > 18) {
				System.out.println("Seat number must be betweee 5 to 18! Please enter number of seats per row for Cinema "+(i+1)+":");
				noSeatsPerRow = sc.nextInt();
			}
			
			System.out.println("-----------------------------------------------");
			System.out.println("Please select Cinema Class for Cinema "+(i+1)+": ");
			for(int k=0;k<CinemaClass.values().length;k++) {
				System.out.println("["+(k+1)+"] "+CinemaClass.values()[k]);
			}
			System.out.println("-----------------------------------------------");
			cClass = sc.nextInt();
			while(cClass > CinemaClass.values().length) {
				System.out.println("Invalid class! Please select Cinema Class for Cinema "+(i+1)+":");
				cClass = sc.nextInt();
			}
			
			listOfCinemas.add(new Cinema(id,CinemaClass.values()[cClass-1],cin_name,noSeats,noSeatsPerRow));
			sc.nextLine();
		}
		
	}
	
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(String loc) {
		this.location = loc;
	}
	
	public Cinema getCinema(int cinema) {
		return listOfCinemas.get(cinema-1);
	}
	
	public Cinema getCinema(String cinema) {
		Cinema temp;
		for(int i=0;i<listOfCinemas.size();i++) {
			temp = listOfCinemas.get(i);
			System.out.println(temp.getCinemaName());
			if(temp.getCinemaName().compareTo(cinema) == 0) {
				return temp;
			}
		}
		
		return null;
	}
	
	public int getCinemaIndex(String cinema) {
		Cinema temp;
		for(int i=0;i<listOfCinemas.size();i++) {
			temp = listOfCinemas.get(i);
			if(temp.getCinemaName().compareTo(cinema) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	// Methods used to print cinema details
	public void printCinemaDetails() {
		
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("There are a total of "+listOfCinemas.size()+" cinemas");
		System.out.println();
		System.out.println("-----------------------------------------------");
		
		for(int i=0;i<listOfCinemas.size();i++) {
			System.out.println((i+1)+" Cinema "+listOfCinemas.get(i).getCinemaID());
			System.out.println("  No of Seats:  "+listOfCinemas.get(i).getNoOfSeats());
			System.out.println("-----------------------------------------------");
		}
	}
	
	public void printCinemas() {
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("List of cinamas under "+this.name);
		System.out.println();
		for(int k=0;k<listOfCinemas.size();k++) {
			System.out.println("["+(k+1)+"] "+listOfCinemas.get(k).getCinemaName());
		}
		System.out.println("-----------------------------------------------");
	}
	
	// Methods use to get showtimes 
	public void printShowtimes() {
		int cinema;
		printCinemas();
		System.out.println();
		System.out.println("Please select a cinema: ");
		cinema = sc.nextInt();
		// print all the showtimes for current cinema
	}
	
	public void printShowtimes(String movie) {
		int cinema;
		printCinemas();
		System.out.println();
		System.out.println("Please select a cinema: ");
		cinema = sc.nextInt();
		while(cinema > listOfCinemas.size()) {
			printCinemas();
			System.out.println("Invalid input! please select a cinema in the list");
			System.out.println("Please select a cinema: ");
			cinema = sc.nextInt();
		}
		// print all the showtimes for current cinema for specific movie
	}
	
	public void printShowtimesByDate(String date) {
		int cinema;
		printCinemas();
		System.out.println();
		System.out.println("Please select a cinema: ");
		cinema = sc.nextInt();
		while(cinema > listOfCinemas.size()) {
			printCinemas();
			System.out.println("Invalid input! please select a cinema in the list");
			System.out.println("Please select a cinema: ");
			cinema = sc.nextInt();
		}
		// print all the showtimes for current cinema for specific date
	}
	
	public int getCinemaByName(String cinema) {
		
		for(int i=0;i<listOfCinemas.size();i++) {
			if(listOfCinemas.get(i).getCinemaName().compareTo(cinema) == 0) {
				return i;
			}
		}
		
		return 0;
	}
	
	// Method used to print available seats inside a cinema for a specific movie,data and time
	public void printAvailableSeats(ShowTimeItems st) {
		
		System.out.println();
		System.out.println();
		
		String cineplex = st.getCineplex();
		String cinema = st.getCinema();
		String time = st.getTiming();
		String date = st.getDate();
		
		
		int CinemaIndex = getCinemaIndex(st.getCinema());
		Seat[][] temp = listOfCinemas.get(CinemaIndex).getSeatLayout();
		 
		
		char a = (char) ('A'+(temp.length-1));
		int noOfSeatsPerRow = listOfCinemas.get(CinemaIndex).getNoOfSeatsPerRow();
		int printOffset = (noOfSeatsPerRow*3)/2;
		int k;
				

		for(k=0;k<printOffset+4;k++) {
			System.out.print(" ");
		}

		
		System.out.println("S C R E E N");
		
		System.out.println();
		
		System.out.print("         ");
		
		for(k=0;k<noOfSeatsPerRow;k++) {
			System.out.print((k+1));
			
			if(noOfSeatsPerRow>10 && (k==1 || k==noOfSeatsPerRow-3)) {
				
				if((k+1)>9) {
					System.out.print(" ");	
				} else {
					System.out.print("   ");
				}
			}else if(noOfSeatsPerRow>8 && k==(noOfSeatsPerRow-1)/2) {
				System.out.print("   ");
			}
			
			
			System.out.print("  ");
		}
		
		System.out.println();
		
		
		if(noOfSeatsPerRow>10) {
			for(k=0;k<noOfSeatsPerRow*3+24;k++) {
				System.out.print("-");
			}
		} else {
			for(k=0;k<noOfSeatsPerRow*3+18;k++) {
				System.out.print("-");
			}
		}
		
		System.out.println();
		System.out.println();
		
		
		for(int i=0;i<temp.length;i++) {
			System.out.print("Row "+(a)+"   ");
			for(int j=0;j<temp[i].length;j++) {
				if(temp[i][j] != null) {
					if(bm.checkBooking(date,cineplex,cinema,time,temp[i][j].getSeatID())) {					// If seat assigned for that time slot print X
						System.out.print("[X]");
					}else {
						System.out.print("[ ]");
					}
				}else {
					System.out.print("   ");
				}
				
				if(noOfSeatsPerRow>10) {
					if(j == 1) {
						System.out.print("   ");
					}
					
					if(j == temp[i].length-3) {
						System.out.print("   ");
					}
				}else if(noOfSeatsPerRow>8){
					if(j == (temp[i].length-1)/2) {
						System.out.print("   ");
					}
				}
			}
			System.out.println();
			a--;
		}
		
		
		System.out.println();
		System.out.println();
		if(noOfSeatsPerRow>10) {
			for(k=0;k<noOfSeatsPerRow*3+24;k++) {
				System.out.print("-");
			}
		} else {
			for(k=0;k<noOfSeatsPerRow*3+18;k++) {
				System.out.print("-");
			}
		}
		System.out.println();

		for(k=0;k<printOffset+2;k++) {
			System.out.print(" ");
		}

		
		System.out.println("E N T R A N C E");
		
		System.out.println();
		
		for(k=0;k<printOffset+1;k++) {
			System.out.print(" ");
		}
		
		System.out.println("[ ] Seat not occupied");
		
		for(k=0;k<printOffset+1;k++) {
			System.out.print(" ");
		}
		
		System.out.println("[X] Seat occupied");
		
		System.out.println();
		
	}

	
}
