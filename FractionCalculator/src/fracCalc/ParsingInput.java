package fracCalc;
import java.util.Scanner;
public class ParsingInput {

	public static void main(String[] args) {
	//Test input: "over/theRiver + through the_woods"
		
		
		
	Scanner in = new Scanner(System.in);
	String me = in.nextLine();
	System.out.printf("Before: %s\nAfter: %s", me, parse(me));

	}
	public static String parse(String input) {
	/*Parsing Identifiers
	 * '_' before a fraction part of a mixed number 
	 * '+', '-', '*', '/' denote the operation located between two spaces
	 *
	 * 
	 */
		int division = input.indexOf('/');
		int addition = input.indexOf('+');
		int firstSpace = input.indexOf(' ');
		int secondSpace = input.indexOf(' ', firstSpace+ 1);
	
		
		
		return input.substring(division - 1, addition);
		
	}
}
