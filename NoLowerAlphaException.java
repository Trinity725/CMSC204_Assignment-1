
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super("The password must contain a lower-case letter");
	}

}
