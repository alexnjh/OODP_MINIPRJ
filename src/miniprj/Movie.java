package miniprj;

import java.io.Serializable;

public class Movie implements Serializable{
	private String title;
	private String synopsis;
	private String director;
	private ShowStatus ShowStatus;
	private String[] cast;
	private Review[] reviews;
	
	//change to this.
	public Movie(String title, String director ,String[] cast) {
		this.title = title;
		this.director =director;
		this.cast = cast;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	public String getDirector() {
		return director;
	}
	
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	public String[] getCast() {
		return cast;
	}
	public void setReview(Review[] reviews) {
		this.reviews = reviews;
	}
	public int getRating() {//geting review from array of reviews
		int avg=0,temp=0;
		for(int i=0; i< reviews.length ; i++ ) {
			reviews[i].getRating();
			temp = 0;
			temp += reviews[i].getRating();
		}
			avg = temp / reviews.length;
			return avg;
	}
	
	
}
