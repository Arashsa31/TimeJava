import java.util.Scanner;

/**
 * @author Arash
 *
 */
public class TimeTester {
	public static void main(String[] args) {

		// scanner
		Scanner keyboard = new Scanner(System.in);
		// attribute
		String time = "";
		String quit = "n";
		boolean loopFlag = true;
		do {
			System.out.println("Enter time in 24-hour notation: (example: 04:35)");
			time = keyboard.next();
			try {
				Time currentTime = new Time();
				// sets time
				currentTime.setTime(time);
				// converts user time to standard time
				currentTime.standardTime();
				System.out.println("That is the same as \n" + currentTime.toString());
				System.out.println("Again? (y/n)");
				quit = keyboard.next();
				if (quit.equalsIgnoreCase("y"))
					loopFlag = false;
			} catch (TimeFormatException e) {
				System.out.println(e.getMessage());
				continue;
			}
		} while (loopFlag);
		keyboard.close();
		System.out.println("Goodbye.");
	}
}