package de.bcxp.challenge.countrystrategy;

import de.bcxp.challenge.common.AbstractCSVReader;
import de.bcxp.challenge.model.Country;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * CSV Reader Implementation for Country data
 */
public class CountryCSVReader extends AbstractCSVReader<Country> {

    private static final Logger LOGGER = Logger.getLogger(CountryCSVReader.class.getName());

    public CountryCSVReader(String delimiter) {
        super(delimiter);
    }

    @Override
    public Country processLine(List<String> values, int lineNumber) {
        if (values.size() != 8) {
            throw new IllegalArgumentException("Invalid number of columns in country.csv");
        }

        Country.CountryBuilder countryBuilder = Country.builder();
        if (!values.get(0).isBlank()) {
            countryBuilder.name(values.get(0));
        } else {
            LOGGER.warning(String.format("Country Name is empty for line %d", lineNumber));
        }

        if (!values.get(1).isBlank()) {
            countryBuilder.capital(values.get(1));
        } else {
            LOGGER.warning(String.format("Country Capital is empty for line %d", lineNumber));
        }

        if (!values.get(2).isBlank()) {
            countryBuilder.accession(values.get(2));
        } else {
            LOGGER.warning(String.format("Accession is empty for line %d", lineNumber));
        }

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        ParsePosition parsePosition = new ParsePosition(0);
        countryBuilder.population(numberFormat.parse(values.get(3), parsePosition).intValue());
        if (parsePosition.getIndex() != values.get(3).length()) { // Check if the whole string was parsed, otherwise contains some invalid characters
            LOGGER.warning(String.format("Could not parse population for %s in line %d", values.get(0), lineNumber));
        }

        parsePosition.setIndex(0);
        countryBuilder.area(numberFormat.parse(values.get(4), parsePosition).intValue());
        if (parsePosition.getIndex() != values.get(4).length()) {
            LOGGER.warning(String.format("Could not parse area for %s in line %d", values.get(0), lineNumber));
        }

        parsePosition.setIndex(0);
        countryBuilder.gdp(numberFormat.parse(values.get(5), parsePosition).intValue());
        if (parsePosition.getIndex() != values.get(5).length()) {
            LOGGER.warning(String.format("Could not parse gdp for %s in line %d", values.get(0), lineNumber));
        }

        try {
            countryBuilder.hdi(Float.parseFloat(values.get(6)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse hdi for %s in line %d", values.get(0), lineNumber));
        }

        try {
            countryBuilder.meps(Integer.parseInt(values.get(7)));
        } catch (NumberFormatException e) {
            LOGGER.warning(String.format("Could not parse meps for %s in line %d", values.get(0), lineNumber));
        }

        return countryBuilder.build();
    }
}
