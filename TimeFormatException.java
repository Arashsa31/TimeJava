/**
 * @author Arash
 *
 */
public class TimeFormatException extends Exception {

	// default constructor
	public TimeFormatException() {
		super("Generic Exception Message.");
	}

	// overloaded constructor
	public TimeFormatException(String exceptionName) {
		super(exceptionName);
	}
}
