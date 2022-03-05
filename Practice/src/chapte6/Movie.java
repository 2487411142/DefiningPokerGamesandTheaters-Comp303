package chapte6;

public class Movie implements Show {
	
	private int aYear;
	private int aTime;
	private String aTitle;
	
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
	
	@Override
	public int time() {
		return aTime;
	}

	@Override
	public String description() {
		return String.format("[%s (%d) : %d mimutes]", aTitle, aYear, aTime);
	}

	@Override
	public Movie copy() {
		return new Movie(this);
	}
	
	@Override
	public String toString() {
		return description();
	}

}
