package ie.atu.sw;

import java.util.Scanner;

/**
 * Managing the main menu system of the application.
 * Provides user interface for specifying file paths, preparing the analysis process, 
 * and exiting the program gracefully.
 */
public class MenuManager {
    private final FilePathManager filePathManager;
    private final Scanner scanner;
    private final AnalysisPreProcessor analysisPreProcessor;
  
    /**
     * Constructs a MenuManager
     *
     * @param filePathManager Instance to handle file path management
     * @param scanner Instance for capturing user input
     */
    public MenuManager(FilePathManager filePathManager, Scanner scanner) {
        this.filePathManager = filePathManager;
        this.scanner = scanner;
        this.analysisPreProcessor = new AnalysisPreProcessor(scanner);
    }

    /**
     * Displays the main menu in a loop, input is requested, action performed
     *
     * @throws InterruptedException If the thread is interrupted during the menu processing.
     */
    public void displayMenu() throws InterruptedException {//Big O = O(1) 
        boolean keepRunning = true;
        while (keepRunning) {
            MenuDisplay.printMenu();
            int max = 6;
            int choice = MenuProcessInput.processInput(max, scanner);
            keepRunning = processChoice(choice);
        }
    }

    /**
     * Processes user's choice and performs action
     *
     * @param choice The user's menu choice as an integer
     * @return true , menu stays in loop, if false exit the program
     * @throws InterruptedException If the thread is interrupted during processing
     */
    private boolean processChoice(int choice) throws InterruptedException {//Big O = O(1) 
        switch (choice) {
            case 1 -> filePathManager.specifyFile(scanner, PathType.EMBEDDING);
            case 2 -> filePathManager.specifyFile(scanner, PathType.GOOGLE);
            case 3 -> filePathManager.specifyFile(scanner, PathType.TEXT);
            case 4 -> filePathManager.specifyFile(scanner, PathType.OUTPUT);
            case 5 -> {
            	analysisPreProcessor.prepareAnalysis(); 
            }
            case 6 -> {
                ExitHandler exitHandler = new ExitHandler();
                return exitHandler.exitAndThanks();
            }
            default -> System.out.println("Invalid Selection");
        }
        return true;
    }
}