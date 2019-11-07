package miniprj;

//import java.lang.Enum;
public class TicketPrice {
	private Day day;
	private CinemaClass cinemaClass;
	private MovieType movieType;
	private double price;
	private Age age;
	
	
	public double getPrice(String day,String cc, MovieType movieType,String age) {
		
		switch(Day.valueIgnoreCase(day))
		{
		
			case MONDAY:
			case TUESDAY:
			case WEDNESDAY:
			case THURSDAY:
				if( CinemaClass.NORMAL == CinemaClass.valueIgnoreCase(cc)) {
					if(MovieType.TWOD == movieType) 
					{
						if(Age.STUDENT == Age.valueIgnoreCase(age))	{				//student Price
						 price = AgePrice.STUDENT.getPrice();
							break;
							
						}else if(Age.ADULT == Age.valueIgnoreCase(age)) {
							price = AgePrice.ADULT.getPrice();	//adult Price
							break;
						}else if(Age.SENIOR == Age.valueIgnoreCase(age)) {
								 price = AgePrice.SENIOR.getPrice();	//Senior Price
								 break;
							}
					}else if(MovieType.THREED == (movieType)) {
						if(Age.ADULT == Age.valueIgnoreCase(age)) {
							price = AgePrice.ADULT.getPrice()+2;			//for the 3d will get price+2
							break;
						}else if(Age.STUDENT == Age.valueIgnoreCase(age)) {
							price = AgePrice.STUDENT.getPrice();				//Student price
							break;
						}else if(Age.SENIOR == Age.valueIgnoreCase(age)) {
							 price = AgePrice.SENIOR.getPrice();			//Senior Price
							 break;
						}// return 20
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						if(Age.ADULT == Age.valueIgnoreCase(age)) {
							price = AgePrice.ADULT.getPrice()+0.5;		//adult Price + 0.5
							break;
						}else if(Age.STUDENT == Age.valueIgnoreCase(age)) {	
							price = AgePrice.STUDENT.getPrice();		//student Price
							break;
						}else if(Age.SENIOR == Age.valueIgnoreCase(age)) {
							price = AgePrice.SENIOR.getPrice();			//senior price
							break;
						}
					}
					
				}else if(CinemaClass.ELITE == CinemaClass.valueIgnoreCase(cc) ) {
					if(MovieType.TWOD == (movieType)) {					//elite price
						price = AgePrice.ELITE.getPrice();
						break;
					}else if(MovieType.THREED == (movieType)) {
						 price = AgePrice.ELITE.getPrice()+2;			//with surchage of 3d glasss //elite price *1.25
						 break;
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						price = AgePrice.ELITE.getPrice();				//elite price	
						break;
					}
				}
				else if(CinemaClass.PLATINUM == CinemaClass.valueIgnoreCase(cc)) {					//platinum Price
					if(MovieType.TWOD == (movieType)) {
						price = AgePrice.PLATINUM.getPrice()-10;
						break;
					}else if(MovieType.THREED == (movieType)) {
						price = AgePrice.PLATINUM.getPrice()-10;
						break;
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						price = AgePrice.PLATINUM.getPrice()-10;
						break;
					}
				}break;
			
				
			case FRIDAY:
				if(CinemaClass.NORMAL == CinemaClass.valueIgnoreCase(cc)) {
					if(MovieType.TWOD == (movieType)) {		
						if(Age.STUDENT == Age.valueIgnoreCase(age)) {								//student Price
							price = AgePrice.STUDENT.getPrice() ;
							break;
						}else if(Age.ADULT == Age.valueIgnoreCase(age)) {
								 price = AgePrice.WEEKEND_ADULT.getPrice();	//Weekend adult Price
								 break;
							}else if(Age.SENIOR == Age.valueIgnoreCase(age)) {
									price = AgePrice.SENIOR.getPrice();		//Senior Price
									break;
							}
					}else if(MovieType.THREED == (movieType)) {
						if(Age.STUDENT == Age.valueIgnoreCase(age))
							 price = AgePrice.STUDENT.getPrice() ;
							else if(Age.ADULT == Age.valueIgnoreCase(age)) {
								 price = AgePrice.WEEKEND_ADULT.getPrice()+2;	//3D weekend adult add 2dollar
								 break;
							}else if(Age.SENIOR == Age.valueIgnoreCase(age)) {
									 price = AgePrice.SENIOR.getPrice();
									 break;
							}
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						price = AgePrice.WEEKEND_ADULT.getPrice()+0.5;
						break;
					}
					
				}else if(CinemaClass.ELITE == CinemaClass.valueIgnoreCase(cc) ) {		
					if(MovieType.TWOD == (movieType)) {
						price = AgePrice.ELITE.getPrice();		//elite price
						break;
					}else if(MovieType.THREED == (movieType)) {
						price = AgePrice.ELITE.getPrice()+2;		//elite price + 3d glass
						break;
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						price = AgePrice.ELITE.getPrice();
						break;
					}
				}
				else if(CinemaClass.PLATINUM == CinemaClass.valueIgnoreCase(cc)) {				//platinum price
					if(MovieType.TWOD == (movieType)) {
						price = AgePrice.PLATINUM.getPrice();
					}else if(MovieType.THREED == (movieType)) {
						price = AgePrice.PLATINUM.getPrice();
						break;
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						price = AgePrice.PLATINUM.getPrice();
						break;
					}
				}
				
			case SATURDAY:
			case SUNDAY:
			case EVE_PUBLIC_HOLIDAY: // add eve of public holiday
			case PUBLIC_HOLIDAY:
			
				if(CinemaClass.NORMAL == CinemaClass.valueIgnoreCase(cc)) {
					if(MovieType.TWOD == (movieType)) {
						price = AgePrice.WEEKEND_ADULT.getPrice();	//return adult price;
						break;
					}else if(MovieType.THREED == (movieType)) {
						price = AgePrice.WEEKEND_ADULT.getPrice()+2;	//return adult + $2;
						break;
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						price = AgePrice.WEEKEND_ADULT.getPrice()+0.5;  //return 13.5;
						break;
					}
					
				}else if(CinemaClass.ELITE == CinemaClass.valueIgnoreCase(cc) ) {
					if(MovieType.TWOD == (movieType)) {
						price = AgePrice.ELITE.getPrice();	 //return Elite price;
						break;
					}else if(MovieType.THREED == (movieType)) {
						price = AgePrice.ELITE.getPrice()+2;	//return ELITE +2
						break;
					}else if(MovieType.BLOCKBUSTER == (movieType)){
						 price =  AgePrice.ELITE.getPrice();//return 14.5;
						 break;
					}
				}
				else if(CinemaClass.PLATINUM == CinemaClass.valueIgnoreCase(cc)) {
					price = AgePrice.PLATINUM.getPrice();
					break;
				}break;
		}
		return price;
	}


	
}
