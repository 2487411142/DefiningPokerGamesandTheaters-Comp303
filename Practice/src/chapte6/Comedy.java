package chapte6;

public class Comedy implements Show {
	
	private String aComedian;
	private int aTime;
	private String aTitle;
	
	public Comedy (String pComedian, String pTitle, int pTime) {
		aTitle = pTitle;
		aComedian = pComedian;
		aTime = pTime;
	}
	
	public Comedy (Comedy pComedy) {
		aTitle = pComedy.aTitle;
		aComedian = pComedy.aComedian;
		aTime = pComedy.aTime;
	}
	
	public Comedy() {
		aTitle = "None";
		aComedian =	"None";
		aTime = 0;
	}
	
	@Override
	public int time() {
		return aTime;
	}

	@Override
	public String description() {
		return String.format("[%s: %s (%d minutes)]", aComedian, aTitle, aTime);
	}
	@Override
	public Comedy copy() {
		return new Comedy(this);
	}

}
