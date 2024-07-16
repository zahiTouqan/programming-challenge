package de.bcxp.challenge.weatherstrategy;

import de.bcxp.challenge.common.AbstractCSVReader;
import de.bcxp.challenge.model.Weather;

import java.util.List;
import java.util.logging.Logger;

/**
 * CSV Reader Implementation for Weather data
 */
public class WeatherCSVReader extends AbstractCSVReader<Weather> {

    private static final Logger LOGGER = Logger.getLogger(WeatherCSVReader.class.getName());

    public WeatherCSVReader(String delimiter) {
        super(delimiter);
    }

    @Override
    public Weather processLine(List<String> values, int lineNumber) {
        if (values.size() != 14) {
            throw new IllegalArgumentException("Each line must have 14 values");
        }

        Weather.WeatherBuilder weatherBuilder = Weather.builder();
        try {
            weatherBuilder.day(Integer.parseInt(values.get(0)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse day for line %d", lineNumber));
        }

        try {
            weatherBuilder.maxTemp(Integer.parseInt(values.get(1)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse max temperature for line %d", lineNumber));
        }

        try {
            weatherBuilder.minTemp(Integer.parseInt(values.get(2)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse min temperature for line %d", lineNumber));
        }

        try {
            weatherBuilder.avgTemp(Integer.parseInt(values.get(3)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse average temperature for line %d", lineNumber));
        }

        try {
            weatherBuilder.avgDewPoint(Float.parseFloat(values.get(4)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse average dew point for line %d", lineNumber));
        }

        try {
            weatherBuilder.precipitation(Integer.parseInt(values.get(5)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse precipitation for line %d", lineNumber));
        }

        try {
            weatherBuilder.windDirection(Integer.parseInt(values.get(6)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse wind direction for line %d", lineNumber));
        }

        try {
            weatherBuilder.avgWindSpeed(Float.parseFloat(values.get(7)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse average wind speed for line %d", lineNumber));
        }

        try {
            weatherBuilder.maxDirection(Integer.parseInt(values.get(8)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse max direction for line %d", lineNumber));
        }

        try {
            weatherBuilder.maxSpeed(Integer.parseInt(values.get(9)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse max speed for line %d", lineNumber));
        }

        try {
            weatherBuilder.skyCover(Float.parseFloat(values.get(10)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse sky cover for line %d", lineNumber));
        }

        try {
            weatherBuilder.maxRelativeHumidity(Integer.parseInt(values.get(11)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse max relative humidity for line %d", lineNumber));
        }

        try {
            weatherBuilder.minRelativeHumidity(Integer.parseInt(values.get(12)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse min relative humidity for line %d", lineNumber));
        }

        try {
            weatherBuilder.avgSeaLevelPressure(Float.parseFloat(values.get(13)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse average sea level pressure for line %d", lineNumber));
        }

        return weatherBuilder.build();
    }
}
