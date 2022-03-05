package chapter9;

import java.util.HashMap;
import java.util.Map;

public class Movie implements Show {
	private int aYear;
	private int aTime;
	private String aTitle;
	private static final Map<String, Movie> aMovies = new HashMap<>();
	
	public Movie (String pTitle, int pYear, int pTime) {
		aTitle = pTitle;
		aYear = pYear;
		aTime = pTime;
	}
	
	public Movie (Movie pMovie) {
		aTitle = pMovie.aTitle;
		aYear = pMovie.aYear;
		aTime = pMovie.aTime;
	}
	
	public static Movie get(String pTitle, int pYear, int pTime) {
		return aMovies.computeIfAbsent(pTitle, title -> new Movie(pTitle, pYear, pTime));
	}
	
	public static String toHHMM(int pMinutes) {
		assert pMinutes > 0;
		return String.format("%d:%02d", pMinutes/60, pMinutes%60);
	}
	
	public String decade()
	{
	   return String.format("%02ds", ((this.year()-1900)%100)/10*10);
	}
	
	@Override
	public int time() {
		return aTime;
	}
	
	public int year() {
		return aYear;
	}
	
	public String title() {
		return aTitle;
	}
	
	
	@Override
	public String description() {
		return String.format("[%s (%d) : %d mimutes]", aTitle, aYear, aTime);
	}
	
	public boolean isOld() {
		return this.aYear < 1960;
	}
	
	public void print() {
		System.out.println(description());
	}
	
	@Override
	public String toString() {
		return description();
	}
}
