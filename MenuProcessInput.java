package ie.atu.sw;

import java.util.Scanner;							//important! call library scanner

/**
 * Utility class for processing user input
 * 
 * This class provides methods to validate and process user input, ensuring that
 * only valid numeric choices within a specified range are accepted.
 */
public class MenuProcessInput {

	 /**
     * Prompts the user to select a valid number within the given range.
     * 
     * This method ensures that the user input is an integer and falls within the
     * specified range (1 to max)
     * 
     * @param max the maximum value the user can select (inclusive)
     * @param scanner instance to read user input
     * @return the valid number chosen 
     */
	public static int processInput(int max, Scanner scanner) { //Big O = O(1)
    	
    	int choice = -1;
        boolean validChoice = false; 				//if not valid stay in the loop ask again input

        while (!validChoice) {						//repeat until choice is valid
            System.out.print("Pick an option: ");	//ask the user to input a value
            if (scanner.hasNextInt()) { 			//check if input is a int
                choice = scanner.nextInt(); 		//assign to a variable the input
                if (choice >= 1 && choice <= max) { //check if int is in the range of choices
                    validChoice = true;				//choice is valid exit from loop 
                } else {
                	//choice is a number, but out of range
                	System.out.println("Invalid choice. Please enter a number between 1 and " + max +".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number."); 	//choice not a number
                scanner.next(); 												//Clear the invalid input
            }
        }

        return choice; //return correct choice
    }
	
	
}
