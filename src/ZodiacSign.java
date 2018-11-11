/**
 * A class for a Zodiac Sign that has names and starting/ending dates
 * @author Fowad Sohail
 * @version 9/20/2018
 */



import java.util.Date;

public class ZodiacSign {

	private String name;
	private Date startingDate;
	private Date endingDate;
	
	/**
	 * Constructor that will initialize all fields
	 * @param signName The name of zodiac sign
	 * @param startingDate The starting date for the range of dates for the zodiac sign
	 * @param endingDate The ending date for the range of dates for the zodiac sign
	 */
	public ZodiacSign(String signName, Date startingDate, Date endingDate) {
		this.name = signName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getStartingDate() {
		return this.startingDate;
	}
	
	public Date getEndingDate() {
		return this.endingDate;
	}
}
