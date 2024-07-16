package de.bcxp.challenge.common;

import java.io.InputStream;
import java.util.List;

/**
 * Interface for reading data from a file.
 * Should be implemented by specific reading implementation (i.e. CSV or JSON)
 *
 * @param <T> Type of the object to be read
 */
public interface DataReader<T> {

    /**
     * Reads data from a file and returns a list of objects
     *
     * @param inputStream Stream of the file to be read
     * @return List of objects read from the file
     */
    List<T> readData(InputStream inputStream);

    /**
     * Processes a line of the file and returns an object
     *
     * @param values List of values from the line
     * @param lineNumber Line number of the file to handle issues
     * @return Object created from the line
     */
    T processLine(List<String> values, int lineNumber);
}
