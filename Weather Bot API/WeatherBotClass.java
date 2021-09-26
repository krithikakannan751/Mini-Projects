/*
    Krithika Kannan
    CS 2336.501
    WeatherBot - WeatherBotClass
    10/10/2020
**/

//Imports
import java.io.BufferedReader; //Reads text from a character-input stream
import java.io.InputStreamReader; //Converts Bytes into characters
import java.io.IOException; //Throws exception
import java.net.HttpURLConnection; //Makes connection to HTTP server
import java.net.URL; //Creates URL object
import java.net.MalformedURLException; //Throws URL errors
import java.text.DecimalFormat; //Formats decimals
import org.jibble.pircbot.*; //Gets pircbot

/*
	The WeatherBotClass manages the user input and mades the api call
**/
public class WeatherBotClass extends PircBot
{
	//Constructor - sets name for bot
	public WeatherBotClass()
	{
		this.setName("KKWeatherBot");
	}

	//Sets numbers to 2 decimal places
	private static final DecimalFormat format = new DecimalFormat("#.00");

	//Checks to see if input zipcode is an integer
	 public static boolean isInteger(String s)
	 {
	      boolean isValid = false;
	      try
	      {
	         Integer.parseInt(s);
	         isValid = true;
	      }
	      catch (NumberFormatException ex)
	      {
	        
	      }	 
	      return isValid;
	  }

	//Checks input message
	public void onMessage(String channel, String sender,
			String login, String hostname, String message)
	{
		//Checks too see if asking for weather
		if (message.contains("weather") || message.contains("Weather"))
		{
			//Variables
			ResponseClass weather; //Stores weather info (high, low, current temp)
			String zip; //Stores zipcode

			//Splits input message into an array
			String words[] = message.split(" ");

			//If zipcode was entered first or second
			if (isInteger(words[0]))
			{
				zip = words[0];
			}
			else
			{
				zip = words[1];
			}

			//Gets weather forecast
			try
			{
				//Gets the weather data
				weather = getWeatherbyZIP(zip);

				//Sends Message to Channel
				sendMessage(channel, "The weather’s going to be " + format.format((weather.temp-273.00)) + "C with a high of " + 
				format.format((weather.high-273.00)) + "C and a low of " + format.format((weather.low-273.00)) + "C.");
				sendMessage("#kkweatherbot", "Enter the word \"weather\" and then another zipcode" +
						" of the area whose weather you are looking for: ");
			}
			catch (IOException e)
			{
				sendMessage(channel, "Please enter a proper zipcode!" );
				sendMessage("#kkweatherbot", "Enter the word \"weather\" and then another zipcode" +
						" of the area whose weather you are looking for: ");
				e.printStackTrace();
			}					
		}
		else
		{
			sendMessage(channel, "Please enter the word \"weather\".");
			sendMessage("#kkweatherbot", "Enter the word \"weather\" and then another zipcode" +
					" of the area whose weather you are looking for: ");
		}
	}

	//Gets the Weather
	ResponseClass getWeatherbyZIP(String zip) throws IOException
	{
		//Connects with API and URL
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip + "&APPID=d18338c622d529de80cb4ab6eef42105");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		//Processes Input
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
			{
				   content.append(inputLine);
			}
			in.close();
			con.disconnect();

		//Creates ResponseClass object to hold data
		ResponseClass response = new ResponseClass(content.toString());

		//Returns weather data
		return response;		
	}	
}
