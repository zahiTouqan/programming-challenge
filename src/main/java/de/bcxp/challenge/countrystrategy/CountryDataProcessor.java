package de.bcxp.challenge.countrystrategy;

import de.bcxp.challenge.common.DataProcessor;
import de.bcxp.challenge.model.Country;

import java.util.List;

/**
 * Implementation of DataProcessor for Country data to find the country with the highest population density
 */
public class CountryDataProcessor implements DataProcessor<Country> {

    @Override
    public Country process(List<Country> data) {
        data.sort((c1, c2) -> (c2.getPopulation() / c2.getArea()) - (c1.getPopulation() / c1.getArea()));
        return data.get(0);
    }
}
