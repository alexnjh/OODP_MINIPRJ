package miniprj;


public enum Age {
	SENIOR , STUDENT, CHILD, ADULT;  
	
	public static Age valueIgnoreCase(String age) {
		age = age.toUpperCase();
        return valueOf(age);
    }
	
}
