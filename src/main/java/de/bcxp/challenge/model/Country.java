package de.bcxp.challenge.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model class for Country data
 */
@Data
@Builder
public class Country {
    private String name;
    private String capital;
    private String accession;
    private int population;
    private int area;
    private int gdp;
    private float hdi;
    private int meps;
}
