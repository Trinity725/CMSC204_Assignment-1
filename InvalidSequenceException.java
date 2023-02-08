
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("The password cannot contain more than to of the same character in sequence");
	}

}
