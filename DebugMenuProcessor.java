package ie.atu.sw;

import java.util.Scanner;

/**
 * Handles the user input for enabling or disabling debug mode
 * 
 * For debug mode, is intended, possibility to print and check in console
 * data from Map and Set in order to verify if loading has been done
 * correctly
 */
public class DebugMenuProcessor {
    
	/**
     * Processes user input to determine if debug mode should be enabled
     * 
     * Prompts the user until they provide a valid response ('y' or 'n')
     * 
     * <ul>
     *   <li>(y) - debug enable</li>
     *   <li>(n) - debug skipped</li>
     * </ul>
     * 
     * @param scanner capture user input
     * @return A boolean value 
     */
    public boolean processDebugRequested(Scanner scanner) {   //Big O = O(1) 

        while (true) {  // Loop until a valid input is received
    		System.out.println(ConsoleColour.RED);        	
            System.out.println("Would you like to enable debug mode? In debug mode, you can:");
            System.out.println("* Display a specific number of lines from the word embedding map");
            System.out.println("* Display a specific number of words from the Google-1000 word set");
            System.out.println("* View the input sentence to be analyzed");
    		System.out.println("");            
            System.out.println("y - enable debug mode");
            System.out.println("n - skip debug mode");
    		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT); 
    		System.out.println("Select Option [y-n]>");
            System.out.print("Pick an option: ");    		
    		
			String choice = scanner.nextLine().trim().toLowerCase();  // Read user input, trim whitespace, and convert to lowercase

            if ("y".equals(choice)) {  // If the user enters 'y', return true
                return true;
            } else if ("n".equals(choice)) {  // If the user enters 'n', return false
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");  // Prompt for valid input
            }
        }
    }
}
