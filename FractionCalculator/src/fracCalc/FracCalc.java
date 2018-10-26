package fracCalc;
/*
 * APCS Project 1: FracCalc
 * Name: Mitchell Braun
 * Period: 2
 * Checkpoint: 
 * Date: 9/18/17
 *
 */
import java.util.Scanner;
public class FracCalc {
public static int WN1;
public static int Num1;
public static int Dem1;//calls all integers
public static int WN2;
public static int Num2;
public static int Dem2;

    public static void main(String[] args) 
    {
    	Scanner in = new Scanner(System.in);
 
    	
    	String first1 = in.nextLine();
    	//System.out.printf("%s\n", first1);
    	System.out.printf("%s",produceAnswer(first1));
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    
    
    
    
    public static String produceAnswer(String input)//parses the fraction 1 and operator and fraction 2
    { 
    	int division = input.indexOf('/'); // Creates a division variable for the substring
    	int firstspace = input.indexOf(' ');
    	int secondspace = input.indexOf(' ', firstspace + 1);
    	int SecondDivision = input.indexOf('/', secondspace + 1); //does the next division symbol
    	int underscore = input.indexOf('_');
    	int end = input.length();
    	String F1 = input.substring(0, firstspace);
    	String Operator = input.substring(firstspace + 1, secondspace);
    	String F2 = input.substring(secondspace + 1, end);
    	String F3 = input.substring(0,end);
    	int underscore21 = F2.indexOf('_');
    	int division21 = F2.indexOf('/');
    	int end21 = F2.length();
    	parsingfraction(F1, Operator, F2);
    	return assembley(Num1, Dem1, Num2, Dem2, Operator);
    	//Addition(Num1, Dem1, Num2, Dem2);
    	//return "";
    	
    }
    	
    	//F1 = F1 + Operator + F2;
    	//return F2;
    public static void parsingfraction(String F1, String Operator, String F2)//parses the actual fraction 1 & 2
    {
 
    	if(F1.contains("_"))
    	{
    		
    		WN1 = Integer.parseInt(F1.substring(0, F1.indexOf('_')));
    		Num1 = Integer.parseInt(F1.substring(F1.indexOf('_') + 1, F1.indexOf('/')));
    		Dem1 = Integer.parseInt(F1.substring(F1.indexOf('/') +1, F1.length()));
    		if(WN1<0)
    		{
    			Num1 = Num1 * -1;
    		}

    		Num1 = (WN1*Dem1)+Num1;
    		
    	}
    	else if(!F1.contains("/"))
    	{
    		WN1 = Integer.parseInt(F1.substring(0, F1.length()));
    		Num1 = WN1;
    		Dem1 = 1;
    	}
    	else
    	{
    		Num1 = Integer.parseInt(F1.substring(0, F1.indexOf('/')));
    		Dem1 = Integer.parseInt(F1.substring(F1.indexOf('/') + 1, F1.length()));
    	}
    	
    	//1/2 + 2_3/9
    	
    	if(F2.contains("_"))
    	{
    		WN2 = Integer.parseInt(F2.substring(0, F2.indexOf('_')));
    		Num2 = Integer.parseInt(F2.substring(F2.indexOf('_') + 1, F2.indexOf('/')));
    		Dem2 = Integer.parseInt(F2.substring(F2.indexOf('/') + 1, F2.length()));
    		if(WN2<0)
    		{
    			Num2 = Num2 * -1;
    		}
    		Num2 = (WN2*Dem2)+Num2;
    		
    		//return ("whole:" + WN2 + " " + "numerator:" + Num2 + " " + "denominator:" + Dem2);
    		
    	}
    	else if(!F2.contains("/"))
    	{
    		WN2 = Integer.parseInt(F2.substring(0, F2.length()));
    		Num2 = WN2;
    		Dem2 = 1;
    		//return ("whole:" + WN2 + " " + "numerator:0" + " " + "denominator:1");
    		
    	}
    	else
    	{
    		
    		Num2 = Integer.parseInt(F2.substring(0, F2.indexOf('/')));
    		Dem2 = Integer.parseInt(F2.substring(F2.indexOf('/') + 1, F2.length()));
    		//return ("whole:0" + " " + "numerator:" + Num2 + " " + "denominator:" + Dem2);
    	}
    }
    

		public static String assembley(int Num1, int Dem1, int Num2, int Dem2, String Operator) {//prints out the fraction depending on what it is
			if(Operator.contains("+"))
			{
				
				return Addition(Num1, Dem1, Num2, Dem2);
			}
			else if(Operator.contains("-"))
			{
				return Subtraction(Num1, Dem1, Num2, Dem2);
			}
			else if(Operator.contains("*"))
			{
				return Multiplication(Num1, Dem1, Num2, Dem2);
			}
			else
			{
				return Division(Num1, Dem1, Num2, Dem2);
			}
			
			
		}
		public static String Addition(int Num1, int Dem1, int Num2, int Dem2) {//Does the math for addition
			int top = (Num1 * Dem2) + (Num2 * Dem1);
			int bot = Dem2 * Dem1;
			return reduce(top, bot);
		}
			public static String Subtraction(int Num1, int Dem1, int Num2, int Dem2) {//does the math for subtraction
			int top = (Num1 * Dem2) - (Num2 * Dem1);
			int bot = Dem2 * Dem1;
			return reduce(top, bot);
		}
			public static String Multiplication(int Num1, int Dem1, int Num2, int Dem2) {//does the math for multiplication
				int top = Num1 * Num2;
				int bot = Dem1 * Dem2;
				return reduce(top, bot);
			}
			public static String Division(int Num1, int Dem1, int Num2, int Dem2) {//does the math for division
				int top = Num1 * Dem2;
				int bot = Dem1 * Num2;
				return reduce(top, bot);
				
			}
			public static String reduce(int Num, int Dem)//reduces the fraction
			{
				if (Num % Dem == 0) return "" + Num / Dem;//make sure it doesnt have any extra bits
				System.out.printf("%d/%d\n", Num, Dem);
				int whole = 0;
				int NewNum;
				if(Math.abs(Num)>Math.abs(Dem))// finds the common fraction
				{
					NewNum = Num % Dem;
					whole = (Num - NewNum) / Dem;
					Num = NewNum;
				}
				int gcf = GCF(Num, Math.abs(Dem));//divides it so it can be simplified
				//System.out.printf("%d/%d   %d\n", Num, Dem, gcf);
				Num = Num/gcf;
				Dem = Dem/gcf;
				//System.out.printf("%d/%d   %d\n", Num, Dem, gcf);
				if (Dem < 0) {//make sure it isnt negative in the ouput
					Num *= -1;
					Dem *= -1;
				}
				if(whole != 0)//sets up the actual answer
				{
					if(Num == 0 && Dem == 0)
					{
					return("" + whole);
					
					}
					return(whole + "_" + Math.abs(Num) + "/" + Math.abs(Dem));
				}
				else 
					{
					return(Num + "/" + Dem);
					}
				}
			

			
			public static int GCF(int X, int Y) //Finds greatest common factor
			{
				if (Y == 0) return X;//Does a trick that is on wikipedia
				return GCF(Y, X % Y);
				
				/*
			int f = 0;	
			if(X>=Y) { // if the Num is greater than the Denominator then
				f=Y; //Sets F to the Denominator
			}
			else
			{
				f=X; // if the Dem is greater than the denominator then it sets F to the Numerator
			}
			while(f>1) { 
				if(X%f!=0 || Y%f!=0) { //finds which remainder is equal to 0
					f=f-1;//goes down 1 in order to find the greatest common factor
				}
				else {
					return f; //if both are 0 then return f
				}
			}
			return 2; //Never going to reach this
			*/
			}
}


		
/*int factor = 1;
int greatest = 1;
while(factor <= X && factor <= Y)
	{
	if(X % factor == 0 && Y % factor == 0)
		{
		greatest = factor;
		factor++;
		}
	}
	return greatest;
    	
    	
    	
    	
    	
    	
    	
  /*
    	
    	if(input.contains("_"))
    	{
    	int division = input.indexOf('/'); // Creates a division variable for the substring
    	int firstspace = input.indexOf(' ');
    	int secondspace = input.indexOf(' ', firstspace + 1);
    	int SecondDivision = input.indexOf('/', secondspace + 1); //does the next division symbol
    	int underscore = input.indexOf('_');
    	int underscore2 = input.indexOf('_', underscore + 1);
    	int end = input.length(); //ends the substring so it doesn't go on forever
    	//int wholeNum = Integer.parseInt(input.substring(0,'_' ));
    	int wholeNum = Integer.parseInt(input.substring(0, input.indexOf('_')));
    	int firstNum = Integer.parseInt(input.substring(division - 1, division)); // Gets the first number
    	int secNum = Integer.parseInt(input.substring(division + 1 , firstspace));//second number
    	int wholeNum2 = Integer.parseInt(input.substring(secondspace + 1, underscore2));
    	int thirdNum = Integer.parseInt(input.substring(underscore2 + 1, SecondDivision)); //third number 
    	int fourthNum = Integer.parseInt(input.substring(SecondDivision + 1, end));// last number
    	
    	if(input.contains("+")) 
    	{
    	return Addition(input, firstNum, secNum, thirdNum, fourthNum, wholeNum, wholeNum2); //returns all the numbers for the addition thing
    	}
    	else if(input.contains("-"))
    	{
    	return subtraction(input, firstNum, secNum, thirdNum, fourthNum);
    	}
    	else if(input.contains("*"))
    	{
    	return multiplication(firstNum, secNum, thirdNum, fourthNum);
    	}
    	
       	else 
    	{
    	return division(firstNum, secNum, thirdNum, fourthNum);
    	}
    	}
    	else
    	{
        	int division = input.indexOf('/'); // Creates a division variable for the substring
        	int firstspace = input.indexOf(' ');
        	int secondspace = input.indexOf(' ', firstspace + 1);
        	int SecondDivision = input.indexOf('/', secondspace + 1); //does the next division symbol
        	int wholeNum = input.indexOf("");
        	int wholeNum2 = input.indexOf("");
        	int end = input.length(); //ends the substring so it doesn't go on forever
        	//int wholeNum = Integer.parseInt(input.substring(0,'_' ));
        	int firstNum = Integer.parseInt(input.substring(division - 1, division)); // Gets the first number
        	int secNum = Integer.parseInt(input.substring(division + 1 , firstspace)); //second number
        	int thirdNum = Integer.parseInt(input.substring(secondspace + 1, SecondDivision)); //third number 
        	int fourthNum = Integer.parseInt(input.substring(SecondDivision + 1, end));// last number
        	
        	if(input.contains("+")) 
        	{
        	return Addition(input, firstNum, secNum, thirdNum, fourthNum, wholeNum, wholeNum2); //returns all the numbers for the addition thing
        	}
        	else if(input.contains("-"))
        	{
        	return subtraction(input, firstNum, secNum, thirdNum, fourthNum);
        	}
        	else if(input.contains("*"))
        	{
        	return multiplication(firstNum, secNum, thirdNum, fourthNum);
        	}
        
           	else 
        	{
        	return division(firstNum, secNum, thirdNum, fourthNum);
        	}
    	}
    	
    	/*Alright so basically this gives an if else statements 
    	 * basically saying that if they have that sign then it will do that String so yeah
    	 */
    	//return "";
    	//return "" + firstNum + secNum + thirdNum + fourthNum;
  /*  }
    private static int[] parseOperand(String f1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String Addition(String input,int firstNum, int secNum, int thirdNum, int fourthNum, int wholeNum, int wholeNum2)
 /*   {
		if(input.contains("_")) {
			int TF = (wholeNum * secNum) + firstNum;
			int TF2 = (wholeNum2 * fourthNum) + thirdNum;
			int mom1 = TF * fourthNum;
			int mom2 = secNum * fourthNum;
			int mom3 = secNum * TF2;
			int mom4 = secNum * fourthNum;
			int mom5 = mom1 + mom3;
			String addG = Integer.toString(mom5);
			String addT = Integer.toString(mom2);
			addG = addG + "/" + addT;
			return addG;
			
		}
		else {
    	int poopy1 = fourthNum * firstNum; // multiplies the fourth and first number so we can have a common denominator
    	int poopy2 = fourthNum * secNum; // multiplies the fourth number with the second number so we can have a common denominator
    	int poopy3 = secNum * thirdNum; //gets the common denominator thing
    	int poopy4 = secNum * fourthNum; //gets the common denominator thing
    	int poopy5 = poopy1 + poopy3; //adds the top numbers
    	String addF = Integer.toString(poopy5); //creates the integers to string
    	String addR = Integer.toString(poopy2); // creates the integers to string
    	addF = addF + "/" + addR; //sets up the answer
    	return addF;
	*/	
  /*  }
    public static String subtraction(String input, int firstNum, int secNum, int thirdNum, int fourthNum)
    {
    	
    	int mitchell1 = fourthNum * firstNum; //sets up a common denominator and adds the numerators
    	int mitchell2 = fourthNum * secNum;
    	int mitchell3 = secNum * thirdNum;
    	int mitchell4 = secNum * fourthNum;
    	int mitchell5 = mitchell1 - mitchell3;
    	String addQ = Integer.toString(mitchell5); //does the string into an integer
    	String addC = Integer.toString(mitchell2);
    	addQ = addQ + "/" + addC; //sets up the actual answer
    	return addQ; //returns it to the thing

    }
    public static String multiplication(int firstNum, int secNum, int thirdNum, int fourthNum)
    {
    	int potty1 = firstNum * thirdNum; //just multiplies across
    	int potty2 = secNum * fourthNum;
    	String addX = Integer.toString(potty1); //creates the string into an integer
    	String addY = Integer.toString(potty2);
    	addX = addX + "/" + addY; //sets up the actual answer
    	return addX; //returns it to the thing
    }
    public static String division(int firstNum, int secNum, int thirdNum, int fourthNum)
    {
    	
    	int gabagool1 = firstNum * fourthNum;//cross multiplies
    	int gabagool2 = secNum * thirdNum;
    	String addM = Integer.toString(gabagool1); //makes the integer into a string
    	String addJ = Integer.toString(gabagool2);
    	addM = addM + "/" + addJ;//sets up the answer
    	return addM;//returns it to the thing
    }
   
    // TODO: Fill in the space below with any helper methods that you think you will need
   */

