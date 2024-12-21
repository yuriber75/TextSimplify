package ie.atu.sw;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Paths;

/** 
 * Service class responsible for managing the loading of various types of data from files
 * 
 * Used to delegate responsibilities to implementation class and managing Exception if the file
 * is not read or not found
 */
public class DataLoaderService {

    /**
     * Loads embeddings.txt from the specified file.
     * 
     * Each line in the file is expected to contain a word followed by its vectors, example:
     * <ul>
     *    <li>frowning, -0.3082, -0.2343, .... 0.0965</li>
     *    <li>undermining, -0.1960, -0.5925, ..... -0.0366</li>
     * </ul>
     * 
     * Delegate the responsibility of loading the file to DataLoaderEmbImpl
     * 
     * @param filePath the file's path 
     * @return A map with 
     * 		   <ul>
     * 			 <li>key:Word</li>
     *           <li>value:Vectors</li>
     *         </ul>
     */
    public Map<String, double[]> loadWordEmbeddings(String filePath) { // Big O = O(n) from DataLoaderEmbImpl
        DataLoader<Map<String, double[]>> dataLoaderEmbed = new DataLoaderEmbImpl();
        return safeLoad(filePath, dataLoaderEmbed,  "Word Embeddings file");
    }

	/**
     * Loads google-1000.txt from the specified file.
     * 
     * Each line in the file is expected to contain a word, example:
     * <ul>
     *    <li>the</li>
     *    <li>of</li>
     *    <li>.....</li>
     *    <li>do</li>
     * </ul>
     * 
     * Delegate the responsibility of loading the file to DataLoaderGoogleImpl
     * 
	 * @param filePath the file's path 
	 * @return A Set with all the words 
	 */
    public Set<String> loadGoogleWords(String filePath) { // Big O = O(n) from DataLoaderGoogleImpl
        DataLoader<Set<String>> dataLoaderGoogle = new DataLoaderGoogleImpl();
        return safeLoad(filePath, dataLoaderGoogle, "Google Words file");
    }

	/**
     * Loads inputText.txt from the specified file.
     * 
     * File can be one or more lines
     * 
     * Delegate the responsibility of loading the file to DataLoaderTextImpl
     * 
	 * @param filePath the file's path 
	 * @return A List of words 
	 */
    public List<String> loadText(String filePath) { // Big O = O(n) from DataLoaderTextImpl
        DataLoader<List<String>> textLoader = new DataLoaderTextImpl();
        return safeLoad(filePath, textLoader,  "Text file");
    }

    /**
     * Checks if the specified file exists
     * Attempts to load the data using the provided DataLoader}
     * 
     * @param <T> The type of data to be loaded
     * @param filePath The location of the file to load
     * @param dataLoader implementation used to load the data
     * @return the data loaded from the file, of type T
     * @throws RuntimeException if the file does not exist or an error occurs during loading
     */
    private <T> T safeLoad(String filePath, DataLoader<T> dataLoader,  String typeFile) {       //Big O = O(n)
        if (!Files.exists(Paths.get(filePath))) {                                               //Big O = O(1)
            throw new RuntimeException("File " + typeFile + " not found: " + filePath);         //Big O = O(1)
        }
        try {
            return dataLoader.load(filePath);// Depends of the loading since mine are all O(n) -> Big O = O(n)
        } catch (Exception e) {                                                                 //Big O = O(1)
            throw new RuntimeException("Error loading " + typeFile + ": " + filePath, e);       //Big O = O(1)
        }
    }
}
