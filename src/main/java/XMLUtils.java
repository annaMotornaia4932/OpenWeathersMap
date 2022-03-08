import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import javax.xml.crypto.dsig.XMLObject;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class XMLUtils {

    public static Integer parseUrl2(URL url2) throws IOException {
        Integer a,b, difference;
        difference = 0;
        if (url2 == null) {
            return 0;
        }
        //form String for parsing
        StringBuilder stringBuilder = new StringBuilder();
        String inputLineXML;
        BufferedReader inXML = new BufferedReader(new InputStreamReader(url2.openStream()));
        inputLineXML=inXML.readLine();
        inputLineXML+=inXML.readLine();

String []array1 = inputLineXML.split("rise=\"");//separate strings untill will get hours,minutes,secs
    String[] array2 = array1[1].split("T");
    String[] array3 = array2[1].split(":");

String timeRise = array3[0];
        String strPattern = "^0+(?!$)";
        timeRise = timeRise.replaceAll(strPattern, "");// delete 0 if it s begin of string

String minuteRise = array3[1];
        minuteRise = minuteRise.replaceAll(strPattern, "");// delete 0 if it s begin of string
String []array3_1 = array3[2].split("\"");
String secRise = array3_1[0];
        secRise = secRise.replaceAll(strPattern, "");// delete 0 if it s begin of string

        String []array4 = inputLineXML.split("set=\"");
        String[] array5 = array4[1].split("T");

        String[] array6 = array5[1].split(":");
        String timeSet = array6[0];
        timeSet = timeSet.replaceAll(strPattern, "");// delete 0 if it s begin of string
        String minuteSet = array6[1];
        minuteSet = minuteSet.replaceAll(strPattern, "");// delete 0 if it s begin of string
        String []array6_1 = array6[2].split("\"><");
        String secSet = array6_1[0];
        secSet = secSet.replaceAll(strPattern, "");// delete 0 if it s begin of string

        a=Integer.parseInt(timeRise);// convert to int
        b=Integer.parseInt(timeSet);
      difference = Math.abs(b - a) * 3600;//convert hour to sec

            a = Integer.parseInt(minuteRise);// convert to int
            b = Integer.parseInt(minuteSet);
                difference += Math.abs(b - a) * 60;//convert min to sec

                a = Integer.parseInt(secRise);// convert to int
                b = Integer.parseInt(secSet);

                    difference += Math.abs(b - a); //check difference
                System.out.println("Day DATA: "+array2[0]+" Day light: "+ difference+ "(sec)");
                    return difference;
                }


                public static URL createUrl2 (String link){
                    try {
                        return new URL(link);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }