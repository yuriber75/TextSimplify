package ie.atu.sw;

public class MenuFilePathDisplay {

    /**
     * Displays the current file path and asks the user if they want to change it.
     *
     * @param type The type of the file path to display.
     */
    public void displayFilePathMenu(PathType type) {  //Big O = O(1) 
        System.out.println("");
        System.out.println(ConsoleColour.RED);
        System.out.println("Current path for " + type + " file is: " + FilePathUtils.getFilePath(type));
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        System.out.print("Would you like to change it? (y/n): ");
    }

    /**
     * Displays the updated file path.
     *
     * @param newPath The updated file path.
     */
    public void displaySuccessMessage(String newPath) {  //Big O = O(1) 
        System.out.println("Path updated successfully to: " + newPath);
    }

    /**
     * Displays an error message for an invalid path.
     */
    public void displayErrorMessage() {  //Big O = O(1) 
        System.out.println("Invalid path. Please try again.");
    }

    /**
     * Displays a message when the path remains unchanged.
     */
    public void displayUnchangedMessage() {  //Big O = O(1) 
        System.out.println("Path remains unchanged.");
    }
}
