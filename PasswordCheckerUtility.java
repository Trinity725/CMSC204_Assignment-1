
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	private PasswordCheckerUtility() {
		
	}
	
	/**
	 * Tests to ensure that the password is between six and nine characters
	 * @param password - password string to be checked
	 * @return true if password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) 
	{
		boolean flag;
		
		if(password.length() >= 6 && password.length()<= 9)
			flag = true;
		else flag = false;
		
		return flag;
	}
	
	/**
	 * Checks to ensure that the password as at least one number
	 * @param password - password string to be checked
	 * @return true if the password has a number
	 * @throws NoDigitException - thrown if the password does not have a number
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException 
	{
		for (int i = 0; i < password.length(); i++) {
			
			char charAtIndex = password.charAt(i);
			if (charAtIndex >= 48 && charAtIndex <= 57)
				return true;
		}
		throw new NoDigitException();
	}
	
	/**
	 * Checks to see if password has a lowercase character
	 * @param password - password string parameter to be checked
	 * @return true password has lowercase letter
	 * @throws NoLowerAlphaException - thrown if password does not have lower case letter
	 */
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException 
	{
		
		for (int i = 0; i < password.length(); i++)
		{
			if (Character.isLowerCase(password.charAt(i)))
				return true;		
		}
			throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks to see if the password has an uppercase character
	 * @param password - password parameter to be checked
	 * @return true if password contains an uppercase character
	 * @throws NoUpperAlphaException - thrown if password does not have uppercase character
	 */
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException 
	{

		for(int i = 0; i < password.length(); i++)
		{
			
			if(Character.isUpperCase(password.charAt(i)))
			{
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * Checks to make sure password contains a special character
	 * @param password - password parameter to be checked
	 * @return true if password has special character
	 * @throws NoSpecialCharacterException - thrown if password does not have special character
	 */
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException 
	{
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches())
			return true;
		throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks if password is at least six characters long
	 * @param password - password parameter to be checked
	 * @return true if password is 6 characters or more
	 * @throws LengthException - thrown if password is less than 6 characters
	 */
	public static boolean isValidLength(java.lang.String password) throws LengthException 
	{
		if (password.length() < 6)
		{
			throw new LengthException();
		}else
			return true;
	}
	
	/**
	 * Checks if password has 3 characters in succession
	 * @param password - password parameter to be checked
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException - thrown if does not meet Sequence requirement
	 */
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException 
	{
		
		for(int i = 0; i < password.length() - 2; i++)
		{
			if(password.charAt(i) == password.charAt(i+1))
			{
				if(password.charAt(i) == password.charAt(i + 2))
				{
				throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}
	
	/** 
	 * Compares two passwords to check if they are the same
	 * @param password - password parameter to be checked
	 * @param passwordConfirm - passwordConfirm string to be compared to password parameter
	 * @throws UnmatchedException - thrown if passwords are not the same
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException 
	{
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}

	/**
	 * Password comparison with return
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) 
	{
		return password.equals(passwordConfirm);
	}
	
	/**
	 * Checks if password is valid but between 6 & 9 characters
	 * @param password - - string to be checked if weak password
	 * @return true if length of password is between 6 and 9 (inclusive)
	 * @throws WeakPasswordException - thrown if password is weak or if password is invalid
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException 
	{
		
		if(hasBetweenSixAndNineChars(password) == true)
		{
			throw new WeakPasswordException();
		}else
			return false;
	}
	
	/**
	 *	Adds invalid passwords to an ArrayList
	 * @param passwords - parameter to read from
	 * @return invalidPasswords - ArrayList of invalid passwords
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords) {
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		if (passwords == null) {
			invalidPasswords.add("N/A");
			return invalidPasswords;
		}
		
		for (java.lang.String next : passwords) {
			
			String blankSpace = " ";
			try {
				
				isValidPassword(next);
				
			} catch (Exception e) {
				invalidPasswords.add(next + blankSpace + e.getMessage());
			}
		}
		
		return invalidPasswords;
	}
	
	
	/**
	 * Return true if  all test are true valid password
	 * @param password - string parameter to be checked for
	 * @return true if all tests are true
	 * @throws LengthException - thrown if length is less than 6 characters
	 * @throws NoUpperAlphaException - thrown if no uppercase letter
	 * @throws NoLowerAlphaException - thrown if no lowercase letter
	 * @throws NoDigitException - thrown if no number
	 * @throws NoSpecialCharacterException - thrown if password has no special character
	 * @throws InvalidSequenceException - thrown if more than 2 of same character in succession
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

		
		if(isValidLength(password) == true &&
				hasUpperAlpha(password) == true &&
				hasLowerAlpha(password) == true &&
				hasDigit(password) == true &&
				hasSpecialChar(password) == true &&
				NoSameCharInSequence(password) == true)
		{
			return true;
		}else
			return false;
		
	}
	
}