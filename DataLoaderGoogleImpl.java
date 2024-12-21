package ie.atu.sw;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * Implementation of DataLoader for loading google-1000 file
 * 
 * Reads a file containing a list of word, example:
 * <ul>
 *    <li>the</li>
 *    <li>of</li>
 *    <li>.....</li>
 *    <li>do</li>
 * </ul>
 *  
 * Uses a virtual threads for storing data in a thread-safe Set 
 */
public class DataLoaderGoogleImpl extends DataLoaderBuffer<Set<String>> {

    /**
     * Loads word google-1000 from the specified file
     * 
     * Reads each line of the file and store in a thread-safe set
     * 
     * @param filePath The location of the file to load
     * @return a set with the word find in the file
     * @throws Exception if an error occurs while processing the file
     */	
    @Override
    public Set<String> load(String filePath) { // Big O = O(n)
        Set<String> googleWords = ConcurrentHashMap.newKeySet(); // Thread-safe Set
        

        try (var pool = Executors.newVirtualThreadPerTaskExecutor()) { // the number of threads is unbounded is cheap because is Virtual

            for (String line : readFileLines(filePath)) { // Big O = O(n)
                pool.execute(() -> {
                    String word = line.trim(); // Get the word from the line
                    if (!word.isEmpty()) {
                        googleWords.add(word); // Add word to the thread-safe set
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return googleWords;
    }
}