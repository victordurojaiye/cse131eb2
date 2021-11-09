package webscaper;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import support.cse131.ArgsProcessor;
import support.cse131.NotYetImplementedException;

public class WeatherReport {

	public WeatherReport(int zipCode) {
		super();
		String url = "https://forecast.weather.gov/zipcity.php?inputstring=" + zipCode;

		// TODO
		throw new NotYetImplementedException();

	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {

		// TODO
		throw new NotYetImplementedException();

	}

	public String getCurrentForecast() {

		// TODO
		return "Not Yet Implemented";

	}

	public String getCurrentTempF() {

		// TODO
		return "Not Yet Implemented";

	}

	public String getCurrentTempC() {

		// TODO
		return "Not Yet Implemented";

	}

	public String getCurrentHumidity() {

		// TODO
		return "Not Yet Implemented";

	}

	public static void main(String[] args) throws IOException {
		ArgsProcessor ap = new ArgsProcessor(args);

		int zipCode = ap.nextInt("What zip code?");

		WeatherReport weather = new WeatherReport(zipCode);

		System.out.println("Zip Code: " + weather.getZipCode());
		System.out.println("Forecast: " + weather.getCurrentForecast());
		System.out.println("    Temp: " + weather.getCurrentTempF() + ", " + weather.getCurrentTempC());
		System.out.println("Humidity: " + weather.getCurrentHumidity());
	}
}
