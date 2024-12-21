package ie.atu.sw;

/**
 * Generic interface for loading data from a file.
 * Heavy lift is demanded to class that implement this interface
 *
 * @param <T> The type of data that will be loaded by the implementing class
 */

public interface DataLoader<T> {

    /**
     * Loads data from a given file path
     *
     * @param 	filePath The location of the file to load
     * @return 	The data loaded from the file, as type T
     * @throws 	RuntimeException If issue finding or loading the file
     */
    T load(String filePath);
}
