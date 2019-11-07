package miniprj;


public enum Day {
	SUNDAY, MONDAY, TUESDAY,WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, PUBLIC_HOLIDAY, EVE_PUBLIC_HOLIDAY;
	
	public static Day valueIgnoreCase(String day) {
        day = day.toUpperCase();
        return valueOf(day);
    }
}
