package ie.atu.sw;

import java.util.Scanner;

/**
 * Manages file path updates for all the files
 * Handler for specifying and modifying file paths 
 *
 */
public class FilePathManager {
    private MenuFilePathProcessor menuFilePathProcessor;

    /**
     * Constructs a new FilePathManager
     *
     * Initializes a MenuFilePathProcessor with  MenuFilePathDisplay for handling user interaction
     */
    public FilePathManager() {
    	MenuFilePathDisplay display = new MenuFilePathDisplay();
        this.menuFilePathProcessor = new MenuFilePathProcessor(display);
    }

    /**
     * Specifies the file path for the given PathType
     *
     * Delegates the file path specification to the appropriate private method
     *
     * @param scanner Instance for capturing user input
     * @param pathType Enum value indicating the type of file path 
     * @throws IllegalArgumentException If the pathType is unknown
     */
    public void specifyFile(Scanner scanner, PathType pathType) {  //Big O = O(1) 
        switch (pathType) {
            case EMBEDDING -> specifyEmbeddingFile(scanner);
            case GOOGLE    -> specifyGoogleFile(scanner);
            case TEXT      -> specifyTextFile(scanner);
            case OUTPUT    -> specifyOutputFile(scanner);
            default        -> throw new IllegalArgumentException("Unknown PathType: " + pathType);
        }
    }

    /**
     * Specifies the file path for the embeddings file delegating input and validation to 
     * MenuFilePathProcessor
     *
     * @param scanner Instance for capturing user input
     */
    private void specifyEmbeddingFile(Scanner scanner) { //Big O = O(1) 
        menuFilePathProcessor.processFilePath(scanner, PathType.EMBEDDING);
    }

    /**
     * Specifies the file path for the Google-1000 file delegating input and validation to 
     * MenuFilePathProcessor
     *
     * @param scanner Instance for capturing user input
     */
    private void specifyGoogleFile(Scanner scanner) {    //Big O = O(1) 
        menuFilePathProcessor.processFilePath(scanner, PathType.GOOGLE);
    }

    /**
     * Specifies the file path for the InputText file delegating input and validation to 
     * MenuFilePathProcessor
     *
     * @param scanner Instance for capturing user input
     */
    private void specifyTextFile(Scanner scanner) {      //Big O = O(1)  
        menuFilePathProcessor.processFilePath(scanner, PathType.TEXT);
    }

    /**
     * Specifies the file path for the Output file delegating input and validation to 
     * MenuFilePathProcessor
     *
     * @param scanner Instance for capturing user input
     */
    private void specifyOutputFile(Scanner scanner) {    //Big O = O(1) 
        menuFilePathProcessor.processFilePath(scanner, PathType.OUTPUT);
    }
}
