package miniprj;

import java.io.Serializable;

public class MovieTicket implements Serializable{
	private double price;
	private String seatID;
	private String date;
	private String time;
	private String cineplex;
	private String cinema;
	private String ticketID;
	private Day day;
	private CinemaClass cinemaClass;
	private MovieType movieType;
	
	public MovieTicket(double price, String seatID, String date, String time, String cineplex, String cinema, String ticketID, Day day, CinemaClass cc, MovieType mt) {
		this.price = price;
		this.seatID = seatID;
		this.date = date;
		this.time = time;
		this.cineplex = cineplex;
		this.cinema = cinema;
		this.ticketID = ticketID;
		this.day = day;
		this.cinemaClass = cc;
		this.movieType = mt;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getSeatID() {
		return seatID;
	}
	public void setSeatID(String seatID) {
		this.seatID=seatID;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date=date;
	}
	
	public String getTime(){
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCineplex() {
		return cineplex;
	}
	public void setCineplex(String cineplex) {
		this.cineplex = cineplex;
	}public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema= cinema;
	}
}
