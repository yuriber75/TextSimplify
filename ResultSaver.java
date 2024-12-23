package ie.atu.sw;
/**
 * Saves processed results to a file
 * 
 * This class is an abstraction to handle the saving of results,
 * delegating the file-writing to the ResultSaverToFile class.
 */
public class ResultSaver {

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
