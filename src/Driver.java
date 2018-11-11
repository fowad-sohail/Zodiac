/**
 * The driver class with main method. Will ask user for their birthdate and then tell them their zodiac sign 
 * @author Fowad Sohail
 * @version 9/20/118
 */



import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Driver {
	
	/**
	 * Main method which will ask user for birthdate and tell them their zodiac sign
	 * @param args The String[] argument
	 * @throws ParseException
	 */
//	public static void main(String[] args) throws ParseException {
//		
//	    Date birthdate = getBirthdate();
//	    ZodiacTable zodiac = createZodiacTable();
//	    System.out.println(zodiac.determineSign(birthdate));
//	}

	
	
	
	
	/**
	 * Get the birthdate of the user according to their input using scanner
	 * @return yourBirthdate A Date object according to user input
	 */
	public static Date getBirthdate(String birthdateString) throws ParseException {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your birthdate(format like '11/25/1995'): ");
//		String birthdateString = sc.nextLine();
		
		String[] digits = birthdateString.split("/");
		int month = Integer.parseInt(digits[0]) - 1;	//Date constructor has months 0-11
		int day = Integer.parseInt(digits[1]);
		int year = Integer.parseInt(digits[2]) - 1900;
//		sc.close();
		
		Date yourBirthdate = new Date(year, month, day);
		return yourBirthdate;
		
	}

	/**
	 * Adds all the zodiac signs, starting with Aries ending with Pisces, to the collection signs
	 * @return allSigns The ZodiacTable object loaded with all zodiac signs for 118 and into 119
	 */
	public static ZodiacTable createZodiacTable() {
		ArrayList<ZodiacSign> signs = new ArrayList<>();
		
		Date ariesStart = new Date(118, 2, 20);
		Date ariesEnd = new Date(118, 3, 19);
		ZodiacSign aries = new ZodiacSign("Aries", ariesStart, ariesEnd);
		signs.add(aries);
		
		Date taurusStart = new Date(118, 3, 20);
		Date taurusEnd = new Date(118, 4, 20);
		ZodiacSign taurus = new ZodiacSign("Taurus", taurusStart, taurusEnd);
		signs.add(taurus);
		
		Date geminiStart = new Date(118, 4, 21);
		Date geminiEnd = new Date(118, 5, 20);
		ZodiacSign gemini = new ZodiacSign("Gemini", geminiStart, geminiEnd);
		signs.add(gemini);
		
		Date cancerStart = new Date(118, 5, 21);
		Date cancerEnd = new Date(118, 6, 21);
		ZodiacSign cancer = new ZodiacSign("Cancer", cancerStart, cancerEnd);
		signs.add(cancer);
		
		Date leoStart = new Date(118, 6, 22);
		Date leoEnd = new Date(118, 7, 22);
		ZodiacSign leo = new ZodiacSign("Leo", leoStart, leoEnd);
		signs.add(leo);
		
		Date virgoStart = new Date(118, 7, 23);
		Date virgoEnd = new Date(118, 8, 22);
		ZodiacSign virgo = new ZodiacSign("Virgo", virgoStart, virgoEnd);
		signs.add(virgo);
		
		Date libraStart = new Date(118, 8, 23);
		Date libraEnd = new Date(118, 9, 22);
		ZodiacSign libra = new ZodiacSign("Libra", libraStart, libraEnd);
		signs.add(libra);
		
		Date scorpioStart = new Date(118, 9, 23);
		Date scorpioEnd = new Date(118, 10, 21);
		ZodiacSign scorpio = new ZodiacSign("Scorpio", scorpioStart, scorpioEnd);
		signs.add(scorpio);
		
		Date sagittariusStart = new Date(118, 10, 22);
		Date sagittariusEnd = new Date(118, 11, 20);
		ZodiacSign sagittarius = new ZodiacSign("Sagittarius", sagittariusStart, sagittariusEnd);
		signs.add(sagittarius);
		
		Date capricornStart = new Date(118, 11, 21);
		Date capricornEnd = new Date(119, 0, 19);
		ZodiacSign capricorn = new ZodiacSign("Capricorn", capricornStart, capricornEnd);
		signs.add(capricorn);
		
		Date aquariusStart = new Date(119, 0, 20);
		Date aquariusEnd = new Date(119, 1, 17);
		ZodiacSign aquarius = new ZodiacSign("Aquarius", aquariusStart, aquariusEnd);
		signs.add(aquarius);
		
		Date piscesStart = new Date(119, 1, 18);
		Date piscesEnd = new Date(119, 2, 19);
		ZodiacSign pisces = new ZodiacSign("Pisces", piscesStart, piscesEnd);
		signs.add(pisces);
		
		
		
		ZodiacTable allSigns = new ZodiacTable(signs);
		return allSigns;
	}
}
