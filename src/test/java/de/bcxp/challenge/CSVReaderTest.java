package de.bcxp.challenge;

import de.bcxp.challenge.countrystrategy.CountryCSVReader;
import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.Weather;
import de.bcxp.challenge.weatherstrategy.WeatherCSVReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    private CountryCSVReader reader;
    private WeatherCSVReader weatherReader;

    @BeforeEach
    void setUp() {
        reader = new CountryCSVReader(";");
        weatherReader = new WeatherCSVReader(";");
    }

    @Test
    void countryValidInput() {
        List<String> values = Arrays.asList("Germany", "Berlin", "Founder", "83120520", "357386", "3863344", "0.947", "96");
        Country country = reader.processLine(values, 1);
        assertNotNull(country);
        assertEquals("Germany", country.getName());
        assertEquals("Berlin", country.getCapital());
        assertEquals("Founder", country.getAccession());
        assertEquals(83120520, country.getPopulation());
        assertEquals(357386, country.getArea());
        assertEquals(3863344, country.getGdp());
        assertEquals(0.947, country.getHdi(), 1e-5);
        assertEquals(96, country.getMeps());
    }

    @Test
    void countryInvalidInput() {
        List<String> values = Arrays.asList("Germany", "Berlin", "Founder", "83120520", "357386", "3863344", "0.947");
        assertThrows(IllegalArgumentException.class, () -> reader.processLine(values, 1));
    }

    @Test
    void weatherValidInput() {
        List<String> values = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14");
        Weather weather = weatherReader.processLine(values, 1);
        assertNotNull(weather);
        assertEquals(1, weather.getDay());
        assertEquals(2, weather.getMaxTemp());
        assertEquals(3, weather.getMinTemp());
        assertEquals(4, weather.getAvgTemp());
        assertEquals(5, weather.getAvgDewPoint());
        assertEquals(6, weather.getPrecipitation());
        assertEquals(7, weather.getWindDirection());
        assertEquals(8, weather.getAvgWindSpeed());
        assertEquals(9, weather.getMaxDirection());
        assertEquals(10, weather.getMaxSpeed());
        assertEquals(11, weather.getSkyCover());
        assertEquals(12, weather.getMaxRelativeHumidity());
        assertEquals(13, weather.getMinRelativeHumidity());
        assertEquals(14, weather.getAvgSeaLevelPressure());
    }

    @Test
    void weatherInvalidInput() {
        List<String> values = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
        assertThrows(IllegalArgumentException.class, () -> weatherReader.processLine(values, 1));
    }
}
