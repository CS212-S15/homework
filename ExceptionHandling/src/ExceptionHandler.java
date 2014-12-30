/**
 * A class used to practice exception handling.
 * @author 
 *
 */
public class ExceptionHandler {
	
	/**
	 * A method that takes as input two strings, uses the Integer.parseInt method
	 * to convert each to an integer, and returns the result of performing integer
	 * division of num1str/num2str.
	 * 
	 * If the first parameter is not a valid integer the method prints the following
	 * message (exactly!) to System.err and returns -1:
	 * First parameter is not an integer.
	 * 
	 * If the second parameter is not a valid integer the method prints the following
	 * message (exactly!) to System.err and returns -1:
	 * Second parameter is not an integer.
	 * 
	 * If the second parameter is a 0 the method prints the following message 
	 * (exactly!) and returns -1:
	 * Cannot divide by 0.
	 * 
	 * @param num1str
	 * @param num2str
	 * @return 
	 */
	public static int divideNoExceptions(String num1str, String num2str) {
		//TODO
		return -1;
	}
	
	/**
	 * A method that takes as input two strings, uses the Integer.parseInt method
	 * to convert each to an integer, and returns the result of performing integer
	 * division of num1str/num2str.
	 * 
	 * If the first or second parameter is not a valid integer the method propagates
	 * the Runtime NumberFormatException.
	 * 
	 * If the second parameter is a 0 the method prints the following message 
	 * (exactly!) to System.err and returns -1:
	 * Cannot divide by 0.
	 * 
	 * @param num1str
	 * @param num2str
	 * @return 
	 */
	public static int dividePropagateNFE(String num1str, String num2str) {
		//TODO
		return -1;
	}
	
	/**
	 * A method that takes as input two strings, uses the Integer.parseInt method
	 * to convert each to an integer, and returns the result of performing integer
	 * division of num1str/num2str.
	 * 
	 * If the first parameter is not a valid integer the method prints the following
	 * message (exactly!) to System.err and returns -1:
	 * First parameter is not an integer.
	 * 
	 * If the second parameter is not a valid integer the method prints the following
	 * message (exactly!) to System.err and returns -1:
	 * Second parameter is not an integer.
	 * 
	 * If the second parameter is a 0 the method propagates a Runtime ArithmeticException.
	 * 
	 * @param num1str
	 * @param num2str
	 * @return 
	 */
	public static int dividePropagateDivByZero(String num1str, String num2str) {
		//TODO
		return -1;
	}
	
	/**
	 * A method that takes as input two strings, uses the Integer.parseInt method
	 * to convert each to an integer, and returns the result of performing integer
	 * division of num1str/num2str.
	 * 
	 * If the first parameter is not a valid integer the method throws a new 
	 * InvalidInputException with the following string (exactly!) as its message.
	 * First parameter is not an integer.
	 * 
	 * If the second parameter is not a valid integer the method throws a new 
	 * InvalidInputException with the following string (exactly!) as its message.
	 * Second parameter is not an integer.
	 * 
	 * If the second parameter is 0 method throws a new 
	 * InvalidInputException with the following string (exactly!) as its message.
	 * Cannot divide by 0.
	 * 
	 * @param num1str
	 * @param num2str
	 * @return 
	 */

	public static int divideThrowNew(String num1str, String num2str) throws InvalidInputException {
		//TODO
		return -1;
	}

	
	
}
