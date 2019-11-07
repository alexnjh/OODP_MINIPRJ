package miniprj;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Booking implements Serializable{
	
	private String bookingID;
	private String name;
	private String contactNum;
	private String email;
	private int age;
	private BookingStatus status;
	private Date date;
	private PaymentEntry paymentEntry;
	private List<MovieTicket> movieTickets;
	
	
	public Booking(PaymentEntry pe,
			BookingStatus status, 
			String name,
			String contact,
			String email,
			int age, 
			ShowTimeItems st,
			List<MovieTicket> movieTickets){
		
		this.bookingID = null; 
		this.paymentEntry = pe;
		this.status = status; 
		this.name = name;
		this.age = age;
		this.contactNum = contact;
		this.email = email;
		this.date = Calendar.getInstance().getTime();
		this.movieTickets = movieTickets;

		
		
	}
	public String getBookingID() {
		return bookingID;
	}
	
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	
	public BookingStatus getStatus() {
		return status;
	}
	
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public PaymentEntry getPaymentEtry() {
		return paymentEntry;
	}
	
	public void setPaymentEntry(PaymentEntry paymentEntry) {
		this.paymentEntry = paymentEntry;
	}
	
	public void addMovieTicket(MovieTicket ticket) {
		movieTickets.add(ticket);
	}
	
	public void removeMovieTicket(MovieTicket ticket) {
		movieTickets.remove(ticket);
	}
	
	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}
	
}
