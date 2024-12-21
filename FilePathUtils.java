package ie.atu.sw;

import java.nio.file.*;

/**
 * Provides utility methods to manage file paths 
 * 
 * Includes:
 * <ul>
 *    <li>Default paths for embeddings, Google-1000, input text, and output files</li>
 *    <li>Methods to retrieve and update these paths</li>
 *    <li>A utility method to validate a given file path</li>
 * </ul>
 */
public class FilePathUtils {

    private static String filePathEmbedding = "./embeddings.txt";  
    private static String filePathGoogle    = "./google-1000.txt";         
    private static String filePathOutput    = "out.txt"; 					
    private static String filePathText      = "./inputText.txt";	
    
    /**
     * Retrieves the file path associated with a specific PathType
     * 
     * @param type The type of file path to retrieve (e.g., EMBEDDING, GOOGLE, OUTPUT, TEXT).
     * @return A String representing the file path
     */
    public static String getFilePath(PathType type) {//Big O = O(1) 
        return switch (type) {
            case EMBEDDING -> filePathEmbedding;
            case GOOGLE    -> filePathGoogle;
            case OUTPUT    -> filePathOutput;
            case TEXT      -> filePathText;
        };
    }
    
    /**
     * Updates the file path for a specific PathType
     * 
     * @param type The type of file path to update (e.g., EMBEDDING, GOOGLE, OUTPUT, TEXT).
     * @param path The new file path
     */
    public static void setFilePath(PathType type, String path) {//Big O = O(1) 
        switch (type) {
            case EMBEDDING -> filePathEmbedding = path;
            case GOOGLE    -> filePathGoogle    = path;
            case OUTPUT    -> filePathOutput    = path;
            case TEXT      -> filePathText      = path;
        }
    }
    
    /**
     * Validates a given file path
     * 
     * @param pathStr The file path as a String to validate
     * @return true path valid, false not valid
     */
    public static boolean isValidPath(String pathStr) {//Big O = O(n)  ->  Paths.get(p.toUri()).equals( p.toAbsolutePath())
        try {                                          
            Paths.get(pathStr);//https://docs.oracle.com/javase/8/docs/api/java/nio/file/Paths.html
            return true;
        } catch (InvalidPathException e) {
            return false;  
        }
    }
}