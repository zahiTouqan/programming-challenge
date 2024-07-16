package de.bcxp.challenge.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model class for Weather data
 * Using Lombok to generate getters and setters
 * And using builder for checking the required fields
 */
@Data
@Builder
public class Weather {
    private int day;
    private int maxTemp;
    private int minTemp;
    private int avgTemp;
    private float avgDewPoint;
    private int precipitation;
    private int windDirection;
    private float avgWindSpeed;
    private int maxDirection;
    private int maxSpeed;
    private float skyCover;
    private int maxRelativeHumidity;
    private int minRelativeHumidity;
    private float avgSeaLevelPressure;
}
