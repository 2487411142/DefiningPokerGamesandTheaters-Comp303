package chapte6;

import java.util.EnumMap;

public class Program {

	private Show aDefault = Show.NULL;
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	
	public Program() {
		initialize();
	}
	
	public void setDefault(Show pShow) {
		aDefault = pShow;
	}
	
	public void initialize() {
		initialize(Day.values() );
	}
	
	public void initialize(Day...pDays) {
		for (Day day : pDays) {
			aShows.put(day, aDefault.copy() );
		}
	}
	
	public void clear() {
		for (Day day : Day.values() ) {
			aShows.put(day, Show.NULL);
		}
	}
	
	public void add(Day pDay, Show pShow) {
		assert pDay != null;
		aShows.put(pDay, pShow);
	}
	
	public void remove (Day pDay) {
		assert pDay != null;
		aShows.remove(pDay);
	}
	
	public Show get(Day pDay) {
		assert pDay != null;
		return aShows.get(pDay);
	}
	
	public String toString() {
		StringBuilder a = new StringBuilder("");
		for (Day day : Day.values()) {
			a.append(String.format("%s: " + aShows.get(day).description() + "\n", day.toString() )  );
		}
		return a.toString();
	}
}
