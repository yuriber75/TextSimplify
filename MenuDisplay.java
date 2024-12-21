package ie.atu.sw;

/**
 * This utility class handles the presentation of the initial menu 
 * 
 * Menu options include:
 * <ul>
 *   <li>Specifying paths for the Word Embeddings file</li>
 *   <li>Specifying paths for the Google 1000 file</li>
 *   <li>Specifying paths for the input text file</li>
 *   <li>Specifying paths for the output file</li>
 *   <li>Executing the analysis and generating a report</li>
 *   <li>Quitting the application</li>
 * </ul>
 */
public class MenuDisplay { //Big O = O(1)

    /**
     * Prints the main menu to the console
     * 
     * This method outputs a styled menu using ConsoleColour} and prompts the user 
     * to select an option. 
     */
	public static void printMenu() {		
		System.out.println(ConsoleColour.RED);
		System.out.println("***********************************************************************");
		System.out.println("*           ATU - Dept. of Computer Science & Applied Physics         *");
		System.out.println("*                                                                     *");
		System.out.println("*                   Virtual Threaded Text Simplifier                  *");
		System.out.println("*                                                                     *");
		System.out.println("***********************************************************************");
		System.out.println("(1) Specify a path for Word Embeddings File (default: ./embeddings.txt)");
		System.out.println("(2) Specify a path for Google 1000 File (default: ./google-1000.txt)");
		System.out.println("(3) Specify a path for Text to analize (default: ./inputText.txt)");
		System.out.println("(4) Specify a path for Output File (default: ./out.txt)");
		System.out.println("(5) Execute, Analyse and Report");
		System.out.println("(6) Quit");
		
		//Output a menu of options and solicit text from the user
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
		System.out.print("Select Option [1-6]>");
		System.out.println();
		
	}

}
