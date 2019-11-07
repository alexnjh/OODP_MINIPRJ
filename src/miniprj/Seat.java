package miniprj;

import java.io.Serializable;

public class Seat implements Serializable{

	private String seatID;
	
	public Seat(String seatID){
		this.seatID = seatID;
	}
	
	public String getSeatID() {
		return seatID;
	}
}
