package ie.atu.sw;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  Abstract base class for data loaders that utilise buffered reading.
 *  
 *  This class provides utility methods in order to reuse the method
 *  
 * @param <T> generic data type
 */
public abstract class DataLoaderBuffer<T> implements DataLoader<T> {

	/**
     * Reads all lines from a file then returns list of strings.
     * 
     * Uses a buffered reader to read the file efficiently
     * 
     * @param filePath The location of the file to load
     * @return List of String, one string represent one line
     * @throws RuntimeException If issue finding or loading the file
     */    
    public List<String> readFileLines(String filePath) { // Big O = O(n)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            return br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Ops.. Reading error file: " + filePath, e);
        }
    }
}