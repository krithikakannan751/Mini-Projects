/*
    Krithika Kannan
    CS 2336.501
    WeatherBot - BotTester
    10/10/2020
**/

/*
    BotTester creates a bot for users to interact with and get the weather
    of a location based on zipcode.
 */
	public class BotTester
	{
		public static void main(String[] args) throws Exception
		{
			//Creates bot
			WeatherBotClass mybot = new WeatherBotClass();
			mybot.setVerbose(true);

			//Connects to chat bot
			mybot.connect("irc.freenode.net");

			//Joins channel
			mybot.joinChannel("#kkweatherbot");

			//sending prompt message to channel
			mybot.sendMessage("#kkweatherbot", "Hello! This bot will let you know the current, low, and" +
					" high temperatures for the current day based on entered zipcode.");
			mybot.sendMessage("#kkweatherbot", "Enter the word \"weather\" and then the zipcode" +
					" of the area whose weather you are looking for: ");
		}
	}

	


			