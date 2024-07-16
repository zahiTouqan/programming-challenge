package de.bcxp.challenge;

import de.bcxp.challenge.common.DataReader;
import de.bcxp.challenge.countrystrategy.CountryCSVReader;
import de.bcxp.challenge.countrystrategy.CountryDataProcessor;
import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.Weather;
import de.bcxp.challenge.weatherstrategy.WeatherCSVReader;
import de.bcxp.challenge.weatherstrategy.WeatherDataProcessor;

import java.util.List;
import java.util.logging.Logger;

import static de.bcxp.challenge.common.Constants.*;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Read the weather data from a file
        DataReader<Weather> weatherReader = getWeatherDataReader();
        WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor(); // Your day analysis function call …
        List<Weather> weatherData = weatherReader.readData(App.class.getResourceAsStream("weather.csv"));
        int dayWithSmallestTempSpread = weatherDataProcessor.process(weatherData).getDay();
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        // Read the country data from a file
        DataReader<Country> countryReader = getCountryDataReader();
        CountryDataProcessor countryDataProcessor = new CountryDataProcessor(); // Your population density analysis function call …
        List<Country> countryData = countryReader.readData(App.class.getResourceAsStream("countries.csv"));
        String countryWithHighestPopulationDensity = countryDataProcessor.process(countryData).getName(); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }

    private static DataReader<Weather> getWeatherDataReader() {
        String[] getFileType = WEATHER_FILE.split("\\."); // Split the file name by dot to get suffix
        String filetype = getFileType[getFileType.length - 1]; // Get the last element of the split array just in case the name has any other dots
        DataReader<Weather> weatherReader; // Declare the reader
        if (filetype.equals("csv")) {
            weatherReader = new WeatherCSVReader(WEATHER_DELIMITER); // Create a new CSV reader
        } else { // Add more file types as needed
            LOGGER.severe("Unsupported file type: " + filetype + ". for weather data.");
            throw new UnsupportedFileTypeException("Unsupported file type: " + filetype + ". for weather data.");
        }
        return weatherReader;
    }

    private static DataReader<Country> getCountryDataReader() {
        // Did not abstract getting the data reader in case you would like to use different types for each file
        String[] getFileType = COUNTRY_FILE.split("\\.");
        String filetype = getFileType[getFileType.length - 1];
        DataReader<Country> countryReader;
        if (filetype.equals("csv")) {
            countryReader = new CountryCSVReader(COUNTRY_DELIMITER);
        } else {
            LOGGER.severe("Unsupported file type: " + filetype + ". for country data.");
            throw new UnsupportedFileTypeException("Unsupported file type: " + filetype + ". for country data.");
        }
        return countryReader;
    }
}
