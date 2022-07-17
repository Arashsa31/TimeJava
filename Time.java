/**
 * @author Arash
 *
 */

public class Time {

	// attributes
	private int hours;
	private int minutes;
	private boolean pmFlag;

	// constructor
	public Time() throws TimeFormatException {
		setHour(0);
		setMinutes(0);
		setPMFlag(false);
	}

	// overloaded constructor
	public Time(String time) throws TimeFormatException {
		setTime(time);
		setPMFlag(false);
	}

	// overloaded constructor
	public Time(int hours, int minutes) throws TimeFormatException {
		setHour(hours);
		setMinutes(minutes);
		setPMFlag(false);
	}

	// setters
	/**
	 * @param hours
	 */
	public void setHour(int hours) throws TimeFormatException {
		if (hours >= 0 && hours < 24)
			this.hours = hours;
		else
			throw new TimeFormatException("Not a valid Hour!");
	}

	/**
	 * @param minutes
	 */
	public void setMinutes(int minutes) throws TimeFormatException {
		if (minutes >= 0 && minutes < 60)
			this.minutes = minutes;
		else
			throw new TimeFormatException("Not a valid Minute!");
	}

	/**
	 * @param pmFlag
	 */
	public void setPMFlag(boolean pmFlag) {
		this.pmFlag = pmFlag;
	}

	// getters
	/**
	 * @return
	 */
	public int getHour() {
		return hours;
	}

	/**
	 * @return
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @return
	 */
	public boolean getPMFlag() {
		return pmFlag;
	}

	/**
	 * @param hours
	 * @param minutes
	 */
	public void setTime(String time) throws TimeFormatException {
		// checks for exceptions
		if (time.length() > 5 || time.length() < 5)
			throw new TimeFormatException("Invalid time format Length!");
		if (time.charAt(2) != ':')
			throw new TimeFormatException("Invalid time format!");
		for (int i = 0; i < time.length(); i++) {
			//skips colon in the middle
			if (i == 2)
				i++;
			if (!Character.isDigit(time.charAt(i)))

				throw new TimeFormatException("Invalid digits!");
		}
		int tempHours = Integer.parseInt(time.substring(0, 2));
		int tempMinutes = Integer.parseInt(time.substring(3, 5));
		setHour(tempHours);
		setMinutes(tempMinutes);
	}

	/**
	 * converts the military time to standard time
	 */
	public void standardTime() {
		if (hours >= 12) {
			if (hours >= 13) {
				hours -= 12;
			}
			pmFlag = true;
		}

		if (hours == 0) {
			hours = 12;
		}
	}

	/**
	 * @return formatted toString
	 */
	public String toString() {
		String pm = "AM";
		if (pmFlag)
			pm = "PM";

		return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + " " + pm;
	}
}