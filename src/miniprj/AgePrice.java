package miniprj;


public enum AgePrice {
	SENIOR(5) , STUDENT(7), CHILD(7), ADULT(9),WEEKEND_ADULT(13),PLATINUM(38),ELITE(14);  
	//platinum $38 for one ticket ,weekday 28
			//BLOCKBUSTER MON-THURS - $38 AT PLATINUM
			//WEEKDAY STANDARD 9.00 ,FIRSTWEEK MOVIE 9.5
			//ELite 14 for 2d ,3d  = 18
			//weekend standard 13
			//3d add 2 dollars =16
			//if base price is 9.5 
			//how much is 5 discount 1.9
	
	 // constructor
   private AgePrice(final int price) {
       this.price = price;
   }

   // internal state
   private int price;

   public int getPrice() {
       return price;
   }
}
