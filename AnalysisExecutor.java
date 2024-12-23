package ie.atu.sw;

import java.util.*;

/**
 * AnalysisExecutor class is responsible for:
 * - text analysis workflow
 * 
 * Relies on other class in order to:
 * Load necessary data, debug(verify correct loading), process text similarity and save result.
 */
public class AnalysisExecutor {
    private final DataLoaderService dataLoaderService; 
    private final DebugLogger debugLogger;
    private final SimilarityCalculator similarityCalculator;
    private final ResultSaver resultSaver;
    
    /**
     * Constructor for AnalysisExecutor.
     * 
     * Initializes the services used in the analysis process:
     * - DataLoaderService: Loads the required data (word embeddings, Google words, text)
     * - DebugLogger: Logs the progress and debug information 
     * - SimilarityCalculator: Is similarity method chosen instantiation
     * - ResultSaver: Saves the final processed results
     * 
     * @param similarityCalculator used for similarity
     */
    public AnalysisExecutor(SimilarityCalculator similarityCalculator) {
        this.dataLoaderService = new DataLoaderService();
        this.debugLogger = new DebugLogger();
        this.similarityCalculator = similarityCalculator;
        this.resultSaver = new ResultSaver();
    }

    /**
     * execute Text Analysis process
     * 
     * This includes:
     * <ul>
     *   <li>dataLoaderService		   -> Loading word-embeddings, Google-1000, input text.</li>
     *   <li>debugging(verify loading) -> Print part or all loading data from Map or List</li>  
     *   <li>textProcessorService	   -> Processing the text</li>
     *   <li>stringConcatenation	   -> Converting the processed text to a single string.</li>
     * </ul>
     * 
     * 
     *
     * @throws InterruptedException If the thread is interrupted during execution
     * @throws RuntimeException If there are error during loading process (example wrong path)
     */     
    public void executeAnalysis() throws InterruptedException {                //Big O = O(n log n)
    	// Starting process message
        System.out.println("Starting text simplification and analysis...");    //Big O = O(1) 

        try {        
	        // Load data required
	        Map<String, double[]> wordEmbeddings = dataLoaderService.loadWordEmbeddings(FilePathUtils.getFilePath(PathType.EMBEDDING));//Big O = O(n)
	        Set<String> googleWords  = dataLoaderService.loadGoogleWords(FilePathUtils.getFilePath(PathType.GOOGLE));                  //Big O = O(n)
	        List<String> textWords = dataLoaderService.loadText(FilePathUtils.getFilePath(PathType.TEXT));                             //Big O = O(n)

	        Scanner scanner = new Scanner(System.in);
	        var debugMenuProcessor = new DebugMenuProcessor();
	        boolean debugRequested = debugMenuProcessor.processDebugRequested(scanner);
	        
	        if (debugRequested) {
		        // Debugging purpose
				System.out.println(ConsoleColour.GREEN);              //Big O = O(1) 
		        debugLogger.log("Debug start: ");                     //Big O = O(1)
		        debugLogger.printWordEmbeddings(wordEmbeddings);      //Big O = O(n)
		        debugLogger.printGoogleWords(googleWords);            //Big O = O(n)
		        debugLogger.printTextContent(textWords);              //Big O = O(n)
	        }
			
            ParagraphProcessor paragraphProcessor = new ParagraphProcessor(googleWords, wordEmbeddings, similarityCalculator); //Big O = O(1)
            List<String> processedText = paragraphProcessor.process(textWords);                                                //Big O = O(n log n)
            
	        // Process text in a String and save the result
	        String finalProcessedText = StringConcatenation.convertListToString(processedText);//Big O = O(n)
	        debugLogger.printProcessedText(finalProcessedText);                                //Big O = O(1)

	        resultSaver.saveResults(finalProcessedText, FilePathUtils.getFilePath(PathType.OUTPUT));//Big O = O(1)
	        
	    } catch (RuntimeException e) {
	    	// 
	        System.err.println("Error: " + e.getMessage());
	        System.err.println("Please verify the file paths and try again.");
	    }
    }
}
