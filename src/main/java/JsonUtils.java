import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.json.simple.ItemList;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println("\nGOT DATA FROM WEATHER SITE FOR A FEW DAYS: \n" + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void parseCurrentJson(String resultJson) {
        try {
            JSONObject JsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
         JSONArray array = new JSONArray();
         Double biggestDifference=0.0;
String biggestDifferenceDay="";


//convert json to string
String jsonObjectString = JsonObject.toString();
String [] array1 = jsonObjectString.split("\"dt\":"); //separate string with data
for (int i =1; i<array1.length-1; i++) {
    String[] array2 = array1[i].split("temp\":"); //separate string with temperature
        String[] array3 = array2[0].split(","); //separate string for getting temperature(double)
        Double a,b,result;
        a = Double.parseDouble(array3[0]); //geting double (temperature)
        String[] array4 = array3[1].split(":"); //separate string for get feels_like temperature
        String[]array5 = array4[1].split(","); // need to read untill ","
        b = Double.parseDouble(array5[0]); //getting double (feels_like)
        result = Math.abs(a-b); // check difference
        if (result>biggestDifference){
            biggestDifference=result;
            String[] arrayTemp1 = array1[i].split("\"dt_txt\":"); //get date of this dt item
            String[] arrayTemp2=arrayTemp1[1].split(",");
            biggestDifferenceDay = arrayTemp2[0]; //read date untill ","
        }
    }
biggestDifference = biggestDifference/32; //convert in Celcium
            System.out.println("\n1)\nBiggest difference between temperature and feels like (Celcium): " + biggestDifference);
            System.out.println("\nBiggest difference day: " + biggestDifferenceDay);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}