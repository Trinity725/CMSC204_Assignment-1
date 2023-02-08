
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Trinity Martin
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> passwords;
	
	String pwFailDigit = "Trinity!CMSC";
	
	String pwUpperFail = "august14";
	
	String pwLowerFail = "BURGERKING";
	
	String pwSpecialCharacterFail = "Im2cool4U";
	
	String pwLengthFail = "Short";
	
	String pwSequenceFail = "aaaapple";
	
	String pwWeak = "Hello7!";

	@Before
	public void setUp() throws Exception {
		
		passwords = new ArrayList<>();
		passwords.addAll(Arrays.asList("HelloWorld123", "myPassword#", "apple084"));
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	
	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(pwLengthFail));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
		
	}
	
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(pwUpperFail));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(pwLowerFail));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("pwWeak");
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("4wardMarch#"));
		 	assertTrue("Did not throw an InvalidSequenceException",true);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword(pwFailDigit));
		 	assertTrue("Did not throw an NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw an NoDigitException",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("IWantC4ndy204!"));
			assertTrue("Did not throw an LengthException",true);
			assertTrue("Did not throw an NoUpperAlphaException",true);
			assertTrue("Did not throw an NoLowerAlphaException",true);
			assertTrue("Did not throw an NoDigitException",true);
			assertTrue("Did not throw an NoSpecialCharacterException",true);
			assertTrue("Did not throw an InvalidSequenceException",true);
		 	
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw an LengthException",true);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw an NoUpperAlphaException",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw an NoLowerAlphaException",true);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw an NoDigitException",true);
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw an NoSpecialCharacterException",true);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceException",true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(results.get(0), "HelloWorld123 The password must contain at least one special character");
		assertEquals(results.get(1), "myPassword# The password must contain at least one number");
		assertEquals(results.get(2), "apple084 The password must contain at least one uppercase letter");
	}
	
}
