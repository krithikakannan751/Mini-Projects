/*
    Krithika Kannan
    CS 2336.501
    GameOfThronesQuotBot - BotTester
    10/10/2020
**/

/*
    BotTester creates a bot for users to interact with and get the character's quote based on
    input name of a character from Game of Thrones.
**/
public class BotTester
{
	public static void main(String[] args) throws Exception
	{
		//creating a bot
		MyGOTBotClass mybot = new MyGOTBotClass();
		mybot.setVerbose(true);
		
		//connecting to chatbot website
		mybot.connect("irc.freenode.net");
		
		//joining channel
		mybot.joinChannel("#kkgotbot");
		
		//sending message prompting user
		mybot.sendMessage("#kkgotbot", "Hello! This bot will tell you a famous quote of a Game of Thrones" +
				" character");
		mybot.sendMessage("#kkgotbot", "Please enter the word \"quote\" followed by the name of a " +
				"GOT character(bronn, brynden, cersei, hound, jaime, littlefinger, olenna, renly, tyrion, varys)");
	}
}
