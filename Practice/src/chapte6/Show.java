package chapte6;

public interface Show {
	
	private static Show creatNull() {
		return new Show() {

			@Override
			public int time() {
				return 0;
			}

			@Override
			public String description() {
				return "No show";
			}
			
			@Override
			public boolean isNull() {
				return true;
			}

			@Override
			public Show copy() {
				return creatNull();
			}
			
		};
	}
	
	static Show NULL = creatNull();
	
	Show copy();
	
	int time();
	
	String description();
	
	default boolean isNull() {return false;}
}
