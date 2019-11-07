package miniprj;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedHashSet;



public class ShowTimeManager implements Serializable, Manager{ 

	private static ArrayList<ShowTimeItems> showTimes = new ArrayList<ShowTimeItems>();
	private DateTimeFormatter parseDate = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
    private  DateTimeFormatter parseTime = DateTimeFormatter.ofPattern("HH:mm");
	private CineplexManager cm = new CineplexManager();
	private MovieManager mm = new MovieManager();
	
	static Scanner sc = new Scanner(System.in);
	
	public ShowTimeManager() {
		showTimes.clear();
		showTimes.addAll(FileIO.readFile(Directory.DIR_SHOWTIMES));
	}
	
	// need to optimise this function
	public void addShowTime() {
		LocalDate ld;
		LocalTime lt;
		int index;
		
		String timing;
		String date;
		String cineplex;
		String cinema;
		String movie;
		System.out.print("Please insert date (dd-mm-yyyy): ");
		date = sc.nextLine();
		ld = LocalDate.parse( date , parseDate );
		date = ld.format(parseDate);
		
		System.out.print("Please insert timing (hh:mm): ");
		timing = sc.nextLine();
		lt = LocalTime.parse( timing , parseTime );
		timing = lt.format(parseTime);
		
		cm.printCineplexes();
		System.out.println("Please insert Cineplex: ");
		index = sc.nextInt();
		
		Cineplex temp = cm.getCineplex(index);
		cineplex = temp.getName();
		
		temp.printCinemas();
		System.out.println("Please insert cinema: ");
		index = sc.nextInt();
		cinema = temp.getCinema(index).getCinemaName();
		
		mm.printMovies();
		System.out.println("Please insert movie name: ");
		index = sc.nextInt();
		movie = mm.getMovie(index).getTitle();
		
		showTimes.add(new ShowTimeItems(timing, date, cineplex, cinema, movie));
		sc.nextLine();
		FileIO.saveToFile(showTimes, Directory.DIR_SHOWTIMES);
		reloadData();
		
		
		
	}
	
	public ArrayList<ShowTimeItems> getAndPrintShowTimeSim(String movie, ArrayList<String> dates, String currentTime) {
		
		
		ArrayList<ShowTimeItems> temp = new ArrayList<>();
		for(int i=0;i<showTimes.size();i++) {
			if(showTimes.get(i).getMovie().compareTo(movie) == 0 && dates.contains(showTimes.get(i).getDate())) {
				
				if(showTimes.get(i).getDate().compareTo(dates.get(0))==0) {
					if(showTimes.get(i).getTiming().compareTo(currentTime)>=0) {
						temp.add(showTimes.get(i));
					}
				}else {
					temp.add(showTimes.get(i));
				}
			}
		}
		
	    Collections.sort(temp); // sort array

	    String check="";
	    String cineCheck="";
	    
		for(int i=0;i<temp.size();i++) {
			if(temp.get(i).getCineplex().compareTo(cineCheck) != 0) {
				System.out.println();
				System.out.println();
				System.out.println("====== "+temp.get(i).getCineplex()+" ======");
				cineCheck = temp.get(i).getCineplex();
				check = "";
			}
			if(temp.get(i).getDate().compareTo(check) != 0) {
				System.out.println();
				System.out.println("--- "+temp.get(i).getDate()+" ---");
				check = temp.get(i).getDate();
			}
			System.out.print("["+(i+1)+"]["+temp.get(i).getTiming()+"]  ");
		}
		
		System.out.println();
		System.out.println();
		
		return temp;
	}	
	
	
	public ShowTimeItems getShowTime(String movie, String cineplex, String cinema, String date, String timing) {
		for(int i=0;i<showTimes.size();i++) {
			if(showTimes.get(i).getMovie().compareTo(movie) == 0
					&&showTimes.get(i).getCineplex().compareTo(cineplex) == 0
					&&showTimes.get(i).getCinema().compareTo(cinema) == 0
					&&showTimes.get(i).getDate().compareTo(date) == 0
					&&showTimes.get(i).getTiming().compareTo(timing) == 0) {
				
				return showTimes.get(i);
				
			}
		}
		
		return null;
	}
	
	@Override
	public void reloadData() {
		showTimes.clear();
		showTimes.addAll(FileIO.readFile(Directory.DIR_SHOWTIMES));
	}
}
