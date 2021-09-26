package parentSignup;

public interface Fee 
{
	/**
	 * getFee method is used to get the monthly rate to attend school full time
	 * @return a double number
	 */
	default double getFee()
	{
		return 900.0;
	}
}
