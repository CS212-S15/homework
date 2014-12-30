import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestExceptionHandler {

	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setErr(new PrintStream(errContent));
	}
	
	@Test
	public void testDivideNoExceptionsValid() {
		double result = ExceptionHandler.divideNoExceptions("5", "1");
		assertTrue(5==result);		
	}

	@Test
	public void testDivideNoExceptionsBadFirstParam() {
		ExceptionHandler.divideNoExceptions("a", "1");
		assertTrue("First parameter is not an integer.".equals(errContent.toString().trim()));
	}

	@Test
	public void testDivideNoExceptionsBadSecondParam() {
		ExceptionHandler.divideNoExceptions("5", "a");
		assertTrue("Second parameter is not an integer.".equals(errContent.toString().trim()));
	}

	@Test
	public void testDivideNoExceptionsBadDenominator() {
		ExceptionHandler.divideNoExceptions("5", "0");
		assertTrue("Cannot divide by 0.".equals(errContent.toString().trim()));
	}

	@Test
	public void testDividePropagateNFEValid() {
		double result = ExceptionHandler.dividePropagateNFE("5", "1");
		assertTrue(5==result);		
	}

	@Test
	public void testDividePropagateNFEBadFirstParam() {
		try {
			ExceptionHandler.dividePropagateNFE("a", "1");
			fail("dividePropagateNFE should throw a NumberFormatException when first parameter is not an integer.");
		} catch(NumberFormatException nfe) {
			assertTrue(nfe.getMessage().contains("input string: \"a\""));	
		}		
	}

	@Test
	public void testDividePropagateNFEBadSecondParam() {
		try {
			ExceptionHandler.dividePropagateNFE("5", "a");
			fail("dividePropagateNFE should throw a NumberFormatException when second parameter is not an integer.");
		} catch(NumberFormatException nfe) {
			assertTrue(nfe.getMessage().contains("input string: \"a\""));	
		}		
	}

	@Test
	public void testDividePropagateNFEBadDenominator() {
		ExceptionHandler.dividePropagateNFE("5", "0");
		assertTrue("Cannot divide by 0.".equals(errContent.toString().trim()));
	}


	@Test
	public void testDividePropagateDivByZeroValid() {
		double result = ExceptionHandler.dividePropagateDivByZero("5", "1");
		assertTrue(5==result);		
	}

	@Test
	public void testDividePropagateDivByZeroBadFirstParam() {
		ExceptionHandler.dividePropagateDivByZero("a", "1");
		assertTrue("First parameter is not an integer.".equals(errContent.toString().trim()));
	}

	@Test
	public void testDividePropagateDivByZeroBadSecondParam() {
		ExceptionHandler.dividePropagateDivByZero("5", "a");
		assertTrue("Second parameter is not an integer.".equals(errContent.toString().trim()));
	}

	@Test
	public void testDividePropagateDivByZeroBadDenominator() {
		
		try {
			ExceptionHandler.dividePropagateDivByZero("5", "0");
			fail("dividePropagateDivByZero should throw an ArithmeticException when second parameter is 0.");
		} catch(ArithmeticException ae) {
			assertTrue(ae.getMessage().contains("/ by zero"));	
		}
	}

	@Test
	public void testDivideThrowNew() {
		try {
			double result = ExceptionHandler.divideThrowNew("5", "1");
			assertTrue(5==result);
		} catch(InvalidInputException iee) {
			fail("InvalidInputException thrown for valid input.");
		}
	}

	@Test
	public void testDivideThrowNewBadFirstParam() {
		try {
			ExceptionHandler.divideThrowNew("a", "1");
			fail("InvalidInputException not thrown for invalid input (a, 1).");
		} catch(InvalidInputException iie) {
			assertTrue("First parameter is not an integer.".equals(iie.getMessage()));
		}
	}

	@Test
	public void testDivideThrowNewBadSecondParam() {
		try {
			ExceptionHandler.divideThrowNew("5", "a");
			fail("InvalidInputException not thrown for invalid input (5, a).");
		} catch(InvalidInputException iie) {
			assertTrue("Second parameter is not an integer.".equals(iie.getMessage()));
		}
	}

	@Test
	public void testDivideThrowNewBadDenominator() {
		try {
			ExceptionHandler.divideThrowNew("5", "0");
			fail("InvalidInputException not thrown for invalid input (5, 0).");
		} catch(InvalidInputException iie) {
			assertTrue("Cannot divide by 0.".equals(iie.getMessage()));
		}
	}
	
	@After
	public void cleanUpStreams() {
	    System.setErr(null);
	}

}
