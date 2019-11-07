package miniprj;

public class Review {
	private int rating;
	private String content;
	
	public Review(String content, int rating) {
		this.content = content;
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public String getContent() {
		return content;
	}
}
