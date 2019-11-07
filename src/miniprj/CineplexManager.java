package miniprj;

import java.io.Serializable;
import java.util.ArrayList;

public class CineplexManager implements Serializable, Manager{
	
	private static ArrayList<Cineplex> listOfCineplexes = new ArrayList<Cineplex>();
	
	public CineplexManager() {
		listOfCineplexes.clear();
		listOfCineplexes.addAll(FileIO.readFile(Directory.DIR_CINEPLEX));
	}
	
	public CineplexManager(int size){
		
		listOfCineplexes = new ArrayList<Cineplex>();
		
		for(int i=0;i<size;i++) {
			System.out.println("+---------------------------------------+");
			System.out.println("|					|");
			System.out.println("|					|");
			System.out.println("|  Please enter details for Cineplex "+(i+1)+"  |");
			System.out.println("|					|");
			System.out.println("|					|");
			System.out.println("+---------------------------------------+");
			listOfCineplexes.add(new Cineplex());
		}
		
	}
	
	public void addCineplex() {
		System.out.println("+---------------------------------------+");
		System.out.println("|					|");
		System.out.println("|					|");
		System.out.println("| Please enter details for new Cineplex |");
		System.out.println("|					|");
		System.out.println("|					|");
		System.out.println("+---------------------------------------+");
		listOfCineplexes.add(new Cineplex());
		FileIO.saveToFile(listOfCineplexes, Directory.DIR_CINEPLEX);
		reloadData();
	}
	
	public void removeCineplex(int index) {
		listOfCineplexes.remove(index-1);
	}
	
	public void printCineplexes() {
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("List of cineplexes");
		System.out.println();
		for(int k=0;k<listOfCineplexes.size();k++) {
			System.out.println("["+(k+1)+"] "+listOfCineplexes.get(k).getName());
		}
		System.out.println("-----------------------------------------------");
	}
	
	public Cineplex getCineplex(int cineplex) {
		return listOfCineplexes.get(cineplex-1);
	}
	
	public Cineplex getCineplex(String cineplex) {
		Cineplex temp;
		for(int i=0;i<listOfCineplexes.size();i++) {
			temp = listOfCineplexes.get(i);
			if(temp.getName().compareTo(cineplex) == 0) {
				return temp;
			}
		}
		
		return null;
	}
	
	@Override
	public void reloadData() {
		listOfCineplexes.clear();
		listOfCineplexes.addAll(FileIO.readFile(Directory.DIR_CINEPLEX));
	}
	
}
