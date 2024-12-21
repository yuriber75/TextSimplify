package ie.atu.sw;

import java.util.Scanner;

/**
 * The AnalysisPreProcessor class is responsible for preparing the analysis 
 * by allowing the user to select a similarity calculator and perform 
 * any necessary preparations before the analysis process starts.
 * 
 * The class interacts with the user to gather the preferred similarity 
 * metric (Cosine, Euclidean, Manhattan, or Pearson) and then passes the 
 * selected similarity calculator to the analysis executor.
 */
public class AnalysisPreProcessor {

    private SimilarityCalculator similarityCalculator;
    private final Scanner scanner;

    /**
     * Constructs a new AnalysisPreProcessor instance with the provided scanner 
     * 
     * @param scanner Instance used to capture user input
     */   
    public AnalysisPreProcessor(Scanner scanner) {
        this.scanner = scanner;
    }
    
    /**
     * Presenting a sub-menu to the user and allowing them to choose a similarity calculator 
     * SimilarityCalculator implementation is selected based on user's choice
     * 
     */   
    public void prepareAnalysis() { //Big O = O(1) 

    	SubMenuDisplay.printMenu();
        
        int max = 4;
        int choice = MenuProcessInput.processInput(max, scanner);
               
        switch (choice) {
	        case 1 -> {
	        	similarityCalculator = new SimilarityCalculatorCosineImpl();
	            System.out.println("Cosine Similarity selected.");	        	
	        }
	        case 2 -> {
	        	similarityCalculator = new SimilarityCalculatorEuclideanDistanceImpl();
	            System.out.println("Euclidean Distance selected.");	        	
	        }
	        case 3 -> {
	        	similarityCalculator = new SimilarityCalculatorManhattanImpl();
	            System.out.println("Manhattan Distance selected.");	        	
	        }
	        case 4 -> {
	        	similarityCalculator = new SimilarityCalculatorPearsonImpl();
	            System.out.println("Pearson Distance selected.");	        	
	        }
	        default ->{
	        	similarityCalculator = new SimilarityCalculatorCosineImpl();
	            System.out.println("Invalid choice, defaulting to Cosine Similarity.");        	
	        }
        }

        System.out.println("");
        // Now you can return the selected calculator
        startAnalysis();
    }

    /**
     * Starts the analysis with the selected SimilarityCalculator.
     */
    private void startAnalysis() { //Big O = O(1) 
        // Pass the chosen similarityCalculator to the AnalysisExecutor
        AnalysisExecutor executor = new AnalysisExecutor(similarityCalculator);
        try {
            executor.executeAnalysis(); // Execute the analysis
        } catch (InterruptedException e) {
            System.err.println("Analysis interrupted.");
        }
    }
}
