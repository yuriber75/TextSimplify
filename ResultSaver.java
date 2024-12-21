package ie.atu.sw;

public class ResultSaver {

	/**
	 * A utility class for saving processed results to a file.
	 * 
	 * This class is an abstraction to handle the saving of results,
	 * delegating the file-writing to the ResultSaverToFile class.
	 * It simplifies the interaction with file-saving mechanisms and promotes clean separation of concerns.
	 */
    private final ResultSaverToFile fileSaver; 

    /**
     * Constructs a new instance used for saving results.
     */
    public ResultSaver() {
    	this.fileSaver = new ResultSaverToFile();
    }  

    /**
     * Saves text results to the output file
     * 
     * @param processedText the processed text to save
     * @param outputFilePath the path for the output file 
     */
    public void saveResults(String processedText, String outputFilePath) {
        fileSaver.saveResultsToOutputFile(processedText, outputFilePath); 
    }
}
