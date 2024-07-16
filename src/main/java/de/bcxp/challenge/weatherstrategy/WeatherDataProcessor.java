package de.bcxp.challenge.weatherstrategy;

import de.bcxp.challenge.common.DataProcessor;
import de.bcxp.challenge.model.Weather;

import java.util.Comparator;
import java.util.List;

/**
 * Implementation of DataProcessor for Weather data to find the day with the smallest temperature spread
 */
public class WeatherDataProcessor implements DataProcessor<Weather> {
    @Override
    public Weather process(List<Weather> weatherData) {
        weatherData.sort(Comparator.comparingInt(w -> (w.getMaxTemp() - w.getMinTemp())));
        return weatherData.get(0);
    }
}
