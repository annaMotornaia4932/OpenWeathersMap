import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class Main {

//url for json data for a few days with my api
public static final String APPID="&appid=d4adf0eb771b55d1146ea7bbe1e2b820";
    public static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/forecast?q=Petersburg&&appid=d4adf0eb771b55d1146ea7bbe1e2b820";
    public static final String WEATHER_URL2 =
            "http://api.openweathermap.org/data/2.5/forecast?q=Petersburg&mode=xml&cnt=";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        URL url = JsonUtils.createUrl(WEATHER_URL);
        String resultJson = JsonUtils.parseUrl(url);
        JsonUtils.parseCurrentJson(resultJson);

        //parsing for 5 periods coz sinset/sunrise only abble for all period, not daily!!
        //there is no chance to get future sunset/sunrise for a next period, for tomorrow, day1..2 and ect. Only day0
        //json file:
        /*{"cod":"200","message":0,"cnt":4,"list":[{"dt":1646697600,"main":{"temp":271.66,"feels_like":266.94,"temp_min":268.27,"temp_max":271.66,"pressure":1013,"sea_level":1013,"grnd_level":994,"humidity":79,"temp_kf":3.39},"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"13n"}],"clouds":{"all":99},"wind":{"speed":4.13,"deg":17,"gust":7.99},"visibility":406,"pop":0.4,"snow":{"3h":0.46},"sys":{"pod":"n"},"dt_txt":"2022-03-08 00:00:00"},{"dt":1646708400,"main":{"temp":270.2,"feels_like":265.29,"temp_min":267.27,"temp_max":270.2,"pressure":1013,"sea_level":1013,"grnd_level":995,"humidity":84,"temp_kf":2.93},"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"13n"}],"clouds":{"all":99},"wind":{"speed":3.94,"deg":14,"gust":7.99},"visibility":459,"pop":0.52,"snow":{"3h":0.32},"sys":{"pod":"n"},"dt_txt":"2022-03-08 03:00:00"},{"dt":1646719200,"main":{"temp":268.47,"feels_like":262.64,"temp_min":266.87,"temp_max":268.47,"pressure":1015,"sea_level":1015,"grnd_level":997,"humidity":88,"temp_kf":1.6},"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"13d"}],"clouds":{"all":100},"wind":{"speed":4.63,"deg":22,"gust":8.22},"visibility":686,"pop":0.48,"snow":{"3h":0.22},"sys":{"pod":"d"},"dt_txt":"2022-03-08 06:00:00"},{"dt":1646730000,"main":{"temp":268.59,"feels_like":262.82,"temp_min":268.59,"temp_max":268.59,"pressure":1017,"sea_level":1017,"grnd_level":998,"humidity":82,"temp_kf":0},"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"13d"}],"clouds":{"all":100},"wind":{"speed":4.58,"deg":32,"gust":6},"visibility":10000,"pop":0.36,"snow":{"3h":0.12},"sys":{"pod":"d"},"dt_txt":"2022-03-08 09:00:00"}],"city":{"id":524901,"name":"Moscow","coord":{"lat":55.7522,"lon":37.6156},"country":"RU","population":1000000,"timezone":10800,"sunrise":1646712227,"sunset":1646752636}}*/
        //xml file:
        /*This XML file does not appear to have any style information associated with it. The document tree is shown below.
<weatherdata>
<location>
<name>Petersburg</name>
<type/>
<country>US</country>
<timezone>-18000</timezone>
<location altitude="0" latitude="37.2279" longitude="-77.4019" geobase="geonames" geobaseid="4778626"/>
</location>
<credit/>
<meta>
<lastupdate/>
<calctime>0</calctime>
<nextupdate/>
</meta>
<sun rise="2022-03-07T11:32:28" set="2022-03-07T23:09:04"/>
<forecast>
<time from="2022-03-07T21:00:00" to="2022-03-08T00:00:00">
<symbol number="500" name="light rain" var="10n"/>
<precipitation probability="0.36" unit="3h" value="0.15" type="rain"/>
<windDirection deg="231" code="SW" name="Southwest"/>
<windSpeed mps="7.58" unit="m/s" name="Moderate breeze"/>
<windGust gust="17.66" unit="m/s"/>
<temperature unit="kelvin" value="297.93" min="297" max="297.93"/>
<feels_like value="297.82" unit="kelvin"/>
<pressure unit="hPa" value="1007"/>
<humidity value="52" unit="%"/>
<clouds value="scattered clouds" all="40" unit="%"/>
<visibility value="10000"/>
</time>
<time from="2022-03-08T00:00:00" to="2022-03-08T03:00:00">
<symbol number="500" name="light rain" var="10n"/>
<precipitation probability="1" unit="3h" value="0.85" type="rain"/>
<windDirection deg="284" code="WNW" name="West-northwest"/>
<windSpeed mps="5.24" unit="m/s" name="Gentle Breeze"/>
<windGust gust="11.45" unit="m/s"/>
<temperature unit="kelvin" value="295.84" min="291.66" max="295.84"/>
<feels_like value="295.73" unit="kelvin"/>
<pressure unit="hPa" value="1009"/>
<humidity value="60" unit="%"/>
<clouds value="broken clouds" all="60" unit="%"/>
<visibility value="10000"/>
</time>
<time from="2022-03-08T03:00:00" to="2022-03-08T06:00:00">
<symbol number="803" name="broken clouds" var="04n"/>
<precipitation probability="0.8"/>
<windDirection deg="305" code="NW" name="Northwest"/>
<windSpeed mps="4.57" unit="m/s" name="Gentle Breeze"/>
<windGust gust="9.49" unit="m/s"/>
<temperature unit="kelvin" value="289.98" min="286" max="289.98"/>
<feels_like value="289.29" unit="kelvin"/>
<pressure unit="hPa" value="1013"/>
<humidity value="60" unit="%"/>
<clouds value="broken clouds" all="80" unit="%"/>
<visibility value="10000"/>
</time>
<time from="2022-03-08T06:00:00" to="2022-03-08T09:00:00">
<symbol number="804" name="overcast clouds" var="04n"/>
<precipitation probability="0"/>
<windDirection deg="327" code="NNW" name="North-northwest"/>
<windSpeed mps="4.18" unit="m/s" name="Gentle Breeze"/>
<windGust gust="9.26" unit="m/s"/>
<temperature unit="kelvin" value="282.43" min="282.43" max="282.43"/>
<feels_like value="280.18" unit="kelvin"/>
<pressure unit="hPa" value="1018"/>
<humidity value="60" unit="%"/>
<clouds value="overcast clouds" all="100" unit="%"/>
<visibility value="10000"/>
</time>
</forecast>
</weatherdata>*/

        System.out.println("\n2)\n");
        Integer longestDay = 0;
        for (int i=1; i<5; i++) {
            URL url2 = XMLUtils.createUrl2(WEATHER_URL2 + i + APPID);
           Integer dayLight = XMLUtils.parseUrl2(url2); //parsing xml
            if(dayLight>longestDay){
                longestDay=dayLight;
            }
        }

        System.out.println("The longest day: "+ longestDay+ "sec");
    }
}