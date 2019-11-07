package miniprj;

public enum MovieType{
	 TWOD("2D"), THREED("3D"), BLOCKBUSTER("Blockbuster");
	
	private final String name;
	private MovieType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
