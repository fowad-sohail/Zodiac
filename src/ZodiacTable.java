/**
 * A class for all of the zodiac signs stored in an ArrayList
 * @author Fowad Sohail
 * @version 9/20/2018
 */


import java.util.Date;
import java.util.Iterator;
import java.text.ParseException;
import java.util.ArrayList;

public class ZodiacTable {
	private static ArrayList<ZodiacSign> signs;
	
	/**
	 * Constructor that will initialize signs field to given ArrayList
	 * @param theseSigns The given ArrayList
	 */
	public ZodiacTable(ArrayList<ZodiacSign> theseSigns) {
		signs = theseSigns;
	}
	
	/**
	 * Display all zodiac signs in the zodiac table
	 */
	public void display() {
		for(ZodiacSign thisSign : signs) {
			System.out.println(thisSign.getName() + " " + thisSign.getStartingDate().toString() + " " + thisSign.getEndingDate().toString());
		}
	}
	
	/**
	 * Determines the sign for a given birthdate
	 * @param birthday The given birthdate
	 * @return "Your zodiac sign is: x" where x is the name of the zodiac sign
	 * @throws ParseException
	 */
	public static String determineSign(Date birthday) throws ParseException {
		ZodiacSign yourSign = null;
				
		birthday.setYear(119);
		//1/20 to 3/19 dates were causing errors, this was the workaround
		Date newYearStart = new Date(118, 11, 31);
		Date piscesEnd = new Date(119, 2, 20);
		if(!(birthday.after(newYearStart) && birthday.before(piscesEnd))) {
			birthday.setYear(118);
		}
		
		
		birthday.setHours(12);	//set time to noon
		birthday.setMinutes(0);
		birthday.setSeconds(0);
		

		for(ZodiacSign currentSign : signs) {
			if(birthday.after(currentSign.getStartingDate()) && birthday.before(currentSign.getEndingDate())) {
				yourSign = currentSign;
			}
			
			
			if(birthday.getMonth() == (currentSign.getEndingDate().getMonth()) &&	//this handles dates equal to 
					birthday.getDay() == (currentSign.getEndingDate().getDay())){	//the end date for a given sign
			
				yourSign = currentSign;
			}			
		}
		
		return yourSign.getName();
	
	}
}
