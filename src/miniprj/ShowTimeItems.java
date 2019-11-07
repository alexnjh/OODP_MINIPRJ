package miniprj;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ShowTimeItems implements Comparable<ShowTimeItems>, Serializable{
	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm");
	private String timing;
	private String date; 
	private String cineplex; 
	private String cinema;
	private String movie;
	private int cineplexid;	//
	
	
	
	public ShowTimeItems(String timing, String date, String cineplex, String cinema, String movie) {
		//timeFormat.format(this.timing);
		//dateFormat.format(this.date);
		
		this.date = date;
		this.timing = timing;
		this.cineplex = cineplex;
		this.cinema = cinema;
		this.movie = movie;
	}
	
	public String getMovie() {
		return movie;
	}
	
	public String getDate() {
		//date = dateFormat.format(date);
		return date;
	}
	
	public String getCineplex() {
		return cineplex;
	}
	
	public String getCinema() {
		return cinema;
	}
	
	public String getTiming() {
		//timing = timeFormat.format(timing);
		return timing;
	}
	
	public void printDetails() {
		System.out.println("Cineplex: " + cineplex);
		System.out.println("Date: " + date);
		System.out.println("Timing: " + timing);
		System.out.println("Cinema No.: " + cinema);
		System.out.println("Movie Title: " + movie);
	}

	public int compareTo(ShowTimeItems o) {
		String compare_cineplex=o.getCineplex();
        String compare_date=o.getDate();
        String compare_time=o.getTiming();
        /* For Ascending order*/
        if(this.cineplex.compareTo(compare_cineplex) == 0) {
            if(this.date.compareTo(compare_date) == 0) {
                return this.timing.compareTo(compare_time);
            } else {
                return this.date.compareTo(compare_date);
            }
        } else {
            return this.cineplex.compareTo(compare_cineplex);
        }

        /* For Descending order do like this */
        //return compareage-this.studentage;
	}
}
