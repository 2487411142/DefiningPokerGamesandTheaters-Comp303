package chapte6;

public class SponsoredComedy extends Comedy{
	
	private String aSponsor;
	private int aSponsorTime;
	
	public SponsoredComedy(String pComedian, String pTitle, int pTime, 
			String pSponsor, int pSponsorTime) {
		
		super(pComedian, pTitle, pTime);
		aSponsor = pSponsor;
		aSponsorTime = pSponsorTime;
	}
}
