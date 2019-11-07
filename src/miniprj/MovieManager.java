
package miniprj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager implements Serializable, Manager{

	private static ArrayList<Movie> movies = new ArrayList<Movie>();
	private Scanner scan = new Scanner(System.in);
	
	public MovieManager() {
		movies.clear();
		movies.addAll(FileIO.readFile(Directory.DIR_MOVIES));
	}
	
	public Movie[] getMovies() {
		Movie[] movieList = new Movie[movies.size()];
	  	for(int i=0; i<movies.size(); i++) {
	  		movieList[i] = movies.get(i);
	  	}
	  	return movieList;
    }	
	
	public Movie getMovie(String movie) {
		for(int i=0; i<movies.size(); i++) {
			if(movies.get(i).getTitle().equals(movie)) {
				return movies.get(i);
			}
		}
		return null;
	}
	
	public Movie getMovie(int movie) {
		return movies.get(movie-1);
	}
	
	public void updateMovie() {
		if(movies.size() == 0) {
			System.out.println("There is no movie available!"); 
			return; 
		}
		System.out.println("Please enter the movie title that you wish to edit: ");
		String title = scan.next();
		for(int i=0; i<movies.size();i++) {
			if(movies.get(i).getTitle().contentEquals(title)) {
				System.out.println("Which of the following do you wish to edit?" );
				System.out.println("(1) Title ");
				System.out.println("(2) Director");
				System.out.println("(3) Cast");
				System.out.println("(4) Back");
				int choice = scan.nextInt();
				do {
				switch(choice) {
					case 1: 
						System.out.println("Please enter the new movie title: ");
						String newTitle = scan.next();
						movies.get(i).setTitle(newTitle);
						System.out.println("Movie title updated!");
						return;
					case 2:
						System.out.println("Please enter the new director: ");
						String newDirector = scan.next();
						movies.get(i).setDirector(newDirector);
						return;
					case 3:
						System.out.println("Please enter the number of cast:");
						int castcount = scan.nextInt();
						String[] newCast = new String[castcount];
						for(int x=0; x<castcount;x++) {
							System.out.println("Enter the Cast: ");
							newCast[x] = scan.nextLine();
						}
						movies.get(i).setCast(newCast);
						System.out.println("Cast updated sucessfully!");
						return;
					case 4:
						return;
					default:
						break;
				}
				}while(true);
			}else {
				//do nothing
			}
		}
		System.out.println("There is no such movie!");
		
	}
	
	
	
	public void addMovie() {
		String title;
		String director;
		String[] cast;
		System.out.println("Enter Movie Title: ");
		title = scan.nextLine();
		System.out.println("Enter the Director: ");
		director = scan.nextLine();
		System.out.println("Please enter the number of cast: ");
		int number = 0;
		number = scan.nextInt();
		cast = new String[number];
		
		scan.nextLine();
		
		for(int x=0; x<number; x++) {
			System.out.println("Enter the Cast: ");
			cast[x] = scan.nextLine();
		}
		movies.add(new Movie(title,director,cast)); 
		System.out.println("Added Successfully!");
		
		FileIO.saveToFile(movies, Directory.DIR_MOVIES);
		reloadData();
	}
	
	public void removeMovie(String Movie) {
		for(int i=0; i<movies.size();i++) {
			if(movies.get(i).getTitle().contentEquals(Movie)) {
				movies.remove(i);
				System.out.println("Removed Successfully!");
				return;
			}
		}
	}
	
	public void printMovies() {
		System.out.println("List of Movies: ");
		for(int i=0; i<movies.size(); i++) {	
			System.out.println("[" + (i+1) + "] " + movies.get(i).getTitle());
		}
		if(movies.size() == 0) {
			System.out.println("There is no movie available!"); 
		}
	}
	
	@Override
	public void reloadData() {
		movies.clear();
		movies.addAll(FileIO.readFile(Directory.DIR_MOVIES));
	}
}
