package ie.atu.sw;

/**
 * This class is responsible for displaying the secondary menu to the user.
 */

public class SubMenuDisplay {

    /**
     * Displays the menu options for similarity 
     */
	public static void printMenu() {	// Big O = O(1) only print in console
		System.out.println(ConsoleColour.RED);
        System.out.println("");
        System.out.println("Choose a similarity calculator:");
        System.out.println("(1) Cosine Similarity");
        System.out.println("(2) Euclidean Distance");
        System.out.println("(3) Manhattan Distance");
        System.out.println("(4) Pearson Distance");
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        System.out.println("Select Option [1-4]>");       
	}	
}
