package ie.atu.sw;

import java.util.Scanner;

/**
 * Processing user inputs to modify file paths
 *
 * <ul>
 *   <li>Display a menu for updating a file path</li>
 *   <li>Take user input to confirm and update the file path</li>
 *   <li>Validate the user-provided file path and handle invalid inputs</li>
 * </ul>
 */
public class MenuFilePathProcessor {

    private final MenuFilePathDisplay display;

    public MenuFilePathProcessor(MenuFilePathDisplay display) {
        this.display = display; // not created a " new MenuFilePathDisplay();" here to avoid tight coupling
    }

    public void processFilePath(Scanner scanner, PathType type) {   //Big O = O(1) 
        display.displayFilePathMenu(type);

        scanner.nextLine();                                         //Big O = O(1) 
        String choice = scanner.nextLine().trim().toLowerCase();

        if ("y".equals(choice)) {                                   //Big O = O(n) 
            System.out.print("Enter new path: ");                   //Big O = O(1) 
            String newPath = scanner.nextLine().trim();             //Big O = O(1) 
            if (FilePathUtils.isValidPath(newPath)) {               //Big O = O(n) 
                FilePathUtils.setFilePath(type, newPath);           //Big O = O(1) 
                display.displaySuccessMessage(newPath);             //Big O = O(1) 
            } else {
                display.displayErrorMessage();                      //Big O = O(1) 
            }
        } else {
            display.displayUnchangedMessage();                      //Big O = O(1) 
        }
    }
}
