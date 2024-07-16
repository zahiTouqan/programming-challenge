package de.bcxp.challenge.common;

import java.util.List;

/**
 * Interface for processing data.
 * Should be implemented by specific processing implementation (i.e. Weather or Country)
 *
 * @param <T> Type of the object to be processed
 */
public interface DataProcessor<T> {

    /**
     * Processes a list of objects and returns a single object based on the processing logic
     *
     * @param data List of objects to be processed
     * @return Object extracted using the processing logic
     */
    T process(List<T> data);
}
