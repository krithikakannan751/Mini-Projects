/*
    Krithika Kannan
    CS 2336.501
    WeatherBot - ResponseClass
    10/10/2020
 **/

//Imports
import com.google.gson.JsonObject; //Creates JsonObjects
import com.google.gson.JsonParser; //Able to convert Java object to Json object

/*
    The ResponseClass creates a JsonObject and coverts the temp, temp_max,
    temp_min values into variables of double type.
 */
public class ResponseClass
{
    //Temperature Data Variables
    double temp; //stores current temp
    double high; //stores high temp for the day
    double low; //stores low temp for the day

    //Constructor
    public ResponseClass(String json)
    {
    	//creating a JsonObject to parse json as Object
    	JsonObject responseJsonObj = new JsonParser().parse(json).getAsJsonObject(); 

    	//getting main as json object
        JsonObject main = responseJsonObj.get("main").getAsJsonObject();

        //converting objects to double
        this.temp = main.get("temp").getAsDouble();
        this.high = main.get("temp_max").getAsDouble();
        this.low = main.get("temp_min").getAsDouble();
    }
}