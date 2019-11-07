package miniprj;

import java.io.Serializable;

public class Cinema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cinemaID;
	private String cinemaName;
	//private ShowTime showTimes;
	private CinemaClass cinemaClass;
	private Seat[][] seats;
	private int noOfSeats = 0;
	private int noOfSeatsPerRow = 0;
	
	public Cinema(int id, CinemaClass cc, String name, int numSeats, int numSeatsPerRow) {
		cinemaID = id;
		cinemaClass = cc;
		cinemaName = name;
		noOfSeats = numSeats;
		noOfSeatsPerRow = numSeatsPerRow;
		
		int r,frontRow=noOfSeatsPerRow, offset=0;
		r = noOfSeats/noOfSeatsPerRow;
		
		if(r == 0) {
			seats = new Seat[1][noOfSeatsPerRow];
			frontRow=noOfSeats;
			if((noOfSeatsPerRow-frontRow)%2 == 0){
				offset = (noOfSeatsPerRow-frontRow)/2;
			}else {
				offset = noOfSeatsPerRow-frontRow;
			}
		}else if(noOfSeats%noOfSeatsPerRow != 0){
			seats = new Seat[r+1][noOfSeatsPerRow];
			frontRow = noOfSeats%noOfSeatsPerRow;
			if((noOfSeatsPerRow-frontRow)%2 == 0){
				offset = (noOfSeatsPerRow-frontRow)/2;
			}else {
				offset = noOfSeatsPerRow-frontRow;
			}
		}else {
			seats = new Seat[r][noOfSeatsPerRow];
		}
		
		char a = (char) ('A'+(seats.length-1));
		for(int i=0;i<seats.length;i++) {
			
			for(int j=0;j<seats[i].length;j++) {
				if(i == 0 && (j < offset || j > frontRow+offset-1)) {
					seats[i][j]=null;
				}else {
					seats[i][j]=new Seat(a+Integer.toString(j+1));
				}
			}
			a--;
		}
		
		
		
	}
	
	public int getCinemaID() {
		return cinemaID;
	}
	
	public String getCinemaName() {
		return cinemaName;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	public int getNoOfSeatsPerRow() {
		return noOfSeatsPerRow;
	}
	
	public Seat[][] getSeatLayout() {
		return seats;
	}
	
	public CinemaClass getCinemaClass() {
		return cinemaClass;
	}
	
	public void setCinemaID(int id) {
		cinemaID = id;
	}
	
	public void setCinemaClass(CinemaClass cc) {
		cinemaClass = cc;
	}
	
	//public ShowTime getShowTime() {
	//	return showTimes;
	//}
	
	
}
