package de.bcxp.challenge.common;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Abstract class for reading data from a CSV file
 * Should be extended by specific CSV reading implementation
 * Delimiter to be decided when initializing the implementation
 *
 * @param <T> Type of the object to be read
 */
public abstract class AbstractCSVReader<T> implements DataReader<T>{

    private static final Logger LOGGER = Logger.getLogger(AbstractCSVReader.class.getName());

    private final String delimiter;

    /**
     * Constructor with delimiter
     *
     * @param delimiter Delimiter used in the CSV file
     */
    public AbstractCSVReader(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Reads data from a csv file and returns a list of objects
     *
     * @param inputStream Stream of the file to be read
     * @return List of objects read from the file
     */
    public List<T> readData(InputStream inputStream) {
        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            br.readLine(); // Skip the header
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(delimiter));
                T object = processLine(values, lineNumber); // Process the line, logic in implementing class
                list.add(object);
                lineNumber++;
            }
        } catch (IOException e) {
            LOGGER.severe("Error reading file: " + e.getMessage());
        }
        return list;
    }
}
