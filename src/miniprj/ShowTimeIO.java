package miniprj;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ShowTimeIO {
	private String movies = "";
	private String[] moviesArray;
	private String timings = "";
	private String[] timingsArray;
	private String cineplex = "";
	private String[] cineplexArray;
	private String cinema = "";
	private String[] cinemaArray;
	private String date = "";
	private String[] dateArray;
	
	public ShowTimeIO() {
	}
	
	public ArrayList<ShowTimeItems> readShowTime() {
		movies = read("C:\\Personal Folder\\University and Scholarship matters\\CECZ2002 Object-Oriented Design and Programming\\miniprj\\miniprj\\showtimes.txt",0);
		moviesArray = movies.split("\\|");
		date = read("C:\\Personal Folder\\University and Scholarship matters\\CECZ2002 Object-Oriented Design and Programming\\miniprj\\miniprj\\showtimes.txt",1);
		dateArray = date.split("\\|");
		timings = read("C:\\Personal Folder\\University and Scholarship matters\\CECZ2002 Object-Oriented Design and Programming\\miniprj\\miniprj\\showtimes.txt",2);
		timingsArray = timings.split("\\|");
		cineplex = read("C:\\Personal Folder\\University and Scholarship matters\\CECZ2002 Object-Oriented Design and Programming\\miniprj\\miniprj\\showtimes.txt",3);
		cineplexArray = cineplex.split("\\|");
		cinema = read("C:\\Personal Folder\\University and Scholarship matters\\CECZ2002 Object-Oriented Design and Programming\\miniprj\\miniprj\\showtimes.txt",4);
		cinemaArray = cinema.split("\\|");
		ArrayList<ShowTimeItems> showTimes = new ArrayList<>();
		for (int i=0; i<moviesArray.length; i++) {
			showTimes.add(new ShowTimeItems(timingsArray[i], dateArray[i], cineplexArray[i], cinemaArray[i], moviesArray[i]));
		}
		return showTimes;
	}
	
	private String read(String fileName, int line) {
		String content = "";
		
		try {
			content = Files.readAllLines(Paths.get(fileName)).get(line);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
}

