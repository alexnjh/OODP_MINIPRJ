package miniprj;

public enum CinemaClass {
	 NORMAL,
	 ELITE,
	 PLATINUM;
	public static CinemaClass valueIgnoreCase(String cinemaClass) {
        cinemaClass = cinemaClass.toUpperCase();
        return valueOf(cinemaClass);
    }
}
