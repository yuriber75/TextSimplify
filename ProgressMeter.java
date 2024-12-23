package ie.atu.sw;

/**
 * Provides a utility to display a progress meter in a terminal. 
 * The progress meter works by displaying a dynamic progress bar
 * that updates in place as progress is made.
 * 
 * Note:
 * <ul>
 * <li>The progress meter does <b>not</b> work in the Eclipse console, but will
 * work in Windows (DOS), Mac, and Linux terminals.</li>
 * <li>The progress meter uses the line feed character "\r" to return
 * to the start of the current line. Outputting text (e.g., using 
 * System.out.println(...) between calls to printProgress
 * will disrupt the progress bar, causing subsequent updates to appear on
 * a new line.</li>
 * <li>If the progress bar width exceeds the terminal width, the meter may
 * not display properly. The bar's size can be adjusted via the SIZE
 * constant.</li>
 * </ul>
 */
public class ProgressMeter {
	
	private static final int SIZE = 50;
    private static final char DONE_CHAR = '█'; // Change to whatever you like.
    private static final char TODO_CHAR = '░'; // Change to whatever you like.	
	/**
	 *  Terminal Progress Meter
	 *  -----------------------
	 *  You might find the progress meter below useful. The progress effect 
	 *  works best if you call this method from inside a loop and do not call
	 *  System.out.println(....) until the progress meter is finished.
	 *  
	 *  Please note the following carefully:
	 *  
	 *  1) The progress meter will NOT work in the Eclipse console, but will
	 *     work on Windows (DOS), Mac and Linux terminals.
	 *     
	 *  2) The meter works by using the line feed character "\r" to return to
	 *     the start of the current line and writes out the updated progress
	 *     over the existing information. If you output any text between 
	 *     calling this method, i.e. System.out.println(....), then the next
	 *     call to the progress meter will output the status to the next line.
	 *      
	 *  3) If the variable size is greater than the terminal width, a new line
	 *     escape character "\n" will be automatically added and the meter won't
	 *     work properly.
	 *      
	 *@param index word analysed
	 *@param total number of words in the sentence
	 */
	public static void printProgress(int index, int total) { //static method will work with class without create a new object
		if (index > total) return;	//Out of range
		
		System.out.print(ConsoleColour.BLUE_BOLD_BRIGHT);         //Big O = O(1)
	    
	    //Compute basic metrics for the meter
        int complete = (100 * index) / total;
        int completeLen = SIZE * complete / 100;
        
        /*
         * A StringBuilder should be used for string concatenation inside a 
         * loop. However, as the number of loop iterations is small, using
         * the "+" operator may be more efficient as the instructions can
         * be optimized by the compiler. Either way, the performance overhead
         * will be marginal.  
         */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < SIZE; i++) {
            sb.append((i < completeLen) ? DONE_CHAR : TODO_CHAR);
        }
        
        /*
         * The line feed escape character "\r" returns the cursor to the 
         * start of the current line. Calling print(...) overwrites the
         * existing line and creates the illusion of an animation.
         */
        System.out.print("\r" + sb + "] " + complete + "%");
        
        //Once the meter reaches its max, move to a new line.
        if (DONE_CHAR == total) System.out.println("\n");
    }
}
