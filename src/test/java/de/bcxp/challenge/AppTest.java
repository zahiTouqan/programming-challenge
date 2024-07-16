package de.bcxp.challenge;

import de.bcxp.challenge.countrystrategy.CountryCSVReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void main_validInput() {
        App.main();
        assertEquals("Day with smallest temperature spread: 14\r\nCountry with highest population density: Malta\r\n", outContent.toString());
    }


}
