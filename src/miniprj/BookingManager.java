package miniprj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class BookingManager implements Serializable, Manager{
	
	private static double bookingFee = 1.5d;
	private static double GST = 1.07d;
	
	private Payment pay = new Payment();
	private static ArrayList<Booking> booking = new ArrayList<Booking>();
	private CineplexManager cm = new CineplexManager();
	
	public BookingManager() {
		booking.clear();
		booking.addAll(FileIO.readFile(Directory.DIR_BOOKING));
	}
	
	public Booking createBooking(String name, String contact, String email, int age, ShowTimeItems showTimeItem, String[] seatStringArray){
		PaymentEntry paymentEntry;
		List<MovieTicket> movieTicketList;
		MovieTicket movieTicket; //may need to edit raw code
		
		//to get back the cinema we are in.
		String cinema = showTimeItem.getCinema();
		Date current = Calendar.getInstance().getTime();
		
		//to get to the part 2 of the corresponding BookingID as required from Assignment
		SimpleDateFormat dateTime =  new SimpleDateFormat("yyyyMMddHHmm");
		
		Cineplex cplex = cm.getCineplex(showTimeItem.getCineplex());
		
		Cinema cinemaObj = cplex.getCinema(showTimeItem.getCinema());
		
		int cinemaId = cinemaObj.getCinemaID(); //need to get cinemaId from Alex/Aleem
		String dateTimeId = dateTime.format(current.getTime());
		
		//BookingID is derived from cinemaId and dateTimeId ("XXXXyyyyMMddHHmm")
		String BookingID = cinemaId + dateTimeId; 
		
		int ticket_quantity = seatStringArray.length;
		
		// need to get price for ticket need to ask cheeHao
		//double ticket_price = TicketPrice.getPrice(current.getDay(),cinemaClass ,movieType, age); 
		//double Total_Price_wGST = (double)((ticket_quantity * ticket_price + bookingFee) * 1.07);
		
		double Total_Price_wGST = 10.0; 
		
		paymentEntry = pay.createPayment(BookingID, Total_Price_wGST, PaymentType.AMEX);
		
		movieTicketList = new ArrayList<MovieTicket>();
		//create movie ticket
		for(String seatNo : seatStringArray) {
			
			//need to create movie ticket
			movieTicketList.add(new MovieTicket(Total_Price_wGST,seatNo,showTimeItem.getDate(),showTimeItem.getTiming(),showTimeItem.getCineplex(),showTimeItem.getCinema(),"haowei",Day.FRIDAY,cinemaObj.getCinemaClass(),MovieType.BLOCKBUSTER));
			
		}
		
		//create booking
		Booking bookingEntry = new Booking(paymentEntry, BookingStatus.ACCEPTED,name,contact,email,age,showTimeItem, movieTicketList);
	    booking.add(bookingEntry);
	    
		FileIO.saveToFile(booking, Directory.DIR_BOOKING);
		reloadData();
		
		return booking.get(booking.size()-1);
		
	
	}
	
	/*
	public void updateBooking(String bookingID, BookingStatus status, PaymentType paymentType ,int movieGoerID, ShowTimeItems showTimeItems){
		Date date = showTimeItems.getTiming();
		MovieGoer movieGoer = movieGoer.getMovieGoerByID(movieGoerID);
		BookingEntry booking = BookingManager.getBooking(bookingID);
		booking.setBookingID(bookingID);
		booking.setStatus(status);
		booking.setDate(date);
		booking.setPaymentEntry(null);
		booking.setMovieGoer(movieGoer);
		// updated
		booking.updateBooking(booking);
	}
	*/

	public Booking getBooking(String bookingID) {
		for(Booking i : booking) {
			if(i.getBookingID().equals(bookingID));
			{
				return i;
			}
		}
		return null;
	}
	
	private int getBookingInt(String bookingID) {
		for(int i=0;i<booking.size();i++) {
			if(booking.get(i).getBookingID().equals(bookingID));
			{
				return i;
			}
		}
		return -1;
	}
	
	public boolean checkBooking(String date, String cineplex, String cinema, String time, String seatID) {
		
		List<MovieTicket> temp;
		
		for(int i=0;i<booking.size();i++) {
			
			temp = booking.get(i).getMovieTickets();
			
			for (int k=0;k<temp.size();k++) {
				if(temp.get(k).getCineplex().compareTo(cineplex) == 0
						&&temp.get(k).getCinema().compareTo(cinema) == 0
						&&temp.get(k).getDate().compareTo(date) == 0
						&&temp.get(k).getTime().compareTo(time) == 0
						&&temp.get(k).getSeatID().compareTo(seatID) == 0) {
					
					return true;
					
				}
			}
		}
		
		return false;
	}

	public void deleteBooking(String bookingID){
		booking.remove(getBookingInt(bookingID));
	}

	@Override
	public void reloadData() {
		booking.clear();
		booking.addAll(FileIO.readFile(Directory.DIR_BOOKING));
		
	}
	
}
