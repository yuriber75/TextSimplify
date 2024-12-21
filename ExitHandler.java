package ie.atu.sw;

/**
 * Managing the graceful exit of the program. 
 */
public class ExitHandler {
	
    /**
     * Exits gracefully the program by printing an exit message
     * 
     * @return `false` to stop the loop and close the program
     */	
	// exit gracefully; System.exit(0) extreme method simulate error
    public boolean exitAndThanks() {                                             //Big O = O(1) 
        System.out.println("Thank you for taking the time to use this program"); // be always
		System.out.println("Bye Bye"); 											 // polite :)
        return false;
    }
}
