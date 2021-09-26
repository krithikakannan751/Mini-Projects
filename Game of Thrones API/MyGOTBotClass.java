/*
    Krithika Kannan
    CS 2336.501
    GameOfThronesQuoteBot - MyGOTBotClass
    10/10/2020
**/

//Imports
import java.io.BufferedReader; //Reads text from a character-input stream
import java.io.InputStreamReader; //Converts Bytes into characters
import java.io.IOException; //Throws exception
import java.net.HttpURLConnection; //Makes connection to HTTP server
import java.net.URL; //Creates URL object
import java.net.MalformedURLException; //Throws URL errors
import com.google.gson.JsonObject; //Creates JsonObjects
import com.google.gson.JsonParser; //Able to convert Java object to Json object
import org.jibble.pircbot.*; //Gets pircbot

/*
	The myGOTBotClass manages user input and makes a call to the api
**/
public class MyGOTBotClass extends PircBot
{
	//Constructor
	public MyGOTBotClass()
	{
		this.setName("KKGotBot");
	}

	//Checks to see if user entered the word quote and a quote
	public void onMessage(String channel, String sender,
			String login, String hostname, String message)
	{
		
		//if user's query contains quote
		if ((message.contains("quote") || message.contains("Quote")) && (message.contains("bronn") || message.contains("brynden")
			||message.contains("cersei") || message.contains("hound")|| message.contains("jaime") || message.contains("littlefinger")
			|| message.contains("olenna") || message.contains("renly") || message.contains("tyrion") || message.contains("varys")))
		{
			
			//storing character's name in variable
			String character;			
			String words[] = message.split(" ");						
			character = words[1];
							
			try
			{
				//getting appropriate quote from character in String format
				String quote = getQuote(character);
				//displaying it by sending String to channel
				sendMessage(channel, "In " + character + "'s words: " + quote);
				sendMessage(channel,"Please enter the word \"Quote\" followed by the name of a GOT character(bronn, brynden, cersei, " +
						" hound, jamie, littlefinger, olenna, renly, tyrion, varys)");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}					
		}
		else
		{
			sendMessage(channel,"Incorrect Request!");
			sendMessage(channel,"Please enter the word \"Quote\" followed by the name of a GOT character(bronn, brynden, cersei, " +
					" hound, jamie, littlefinger, olenna, renly, tyrion, varys)");
		}
	}

	//Gets message
	String getQuote(String character) throws IOException
	{
		//creating URL connection and connecting with the API link
		URL url = new URL("https://got-quotes.herokuapp.com/quotes?char=" + character);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		//reading input
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null)
		{
				content.append(inputLine);
		}
		in.close();		
		con.disconnect();
		
		//creating a String object to convert input stream to String
		String json = content.toString();	
		
		//creating JSON object to parse json into a jsonObject
		JsonObject responseJsonObj = new JsonParser().parse(json).getAsJsonObject(); 
		
		//extracting quote and converting to string
		String quote = responseJsonObj.get("quote").getAsString();			
		
		return quote;
	}
}