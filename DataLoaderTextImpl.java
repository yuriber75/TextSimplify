package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DataLoader for loading inputText file
 * 
 * Reads a file containing a input text, example: "I go to the abbey"
 *  
 * The process involves reading the file line by line, splitting each line
 * and adding each word to the list.
 */
public class DataLoaderTextImpl extends DataLoaderBuffer<List<String>> {

    /**
     * Loads inputText from the specified file
     * 
     * Reads each line of the file, splits it into a word and stores the result 
     * in a list of strings
     * 
     * @param filePath The location of the file to load
     * @return a list of word in ArrayList
     */	
    @Override
    public List<String> load(String filePath) {        //Big O = O(n)
        List<String> words = new ArrayList<>();
        for (String line : readFileLines(filePath)) {
            String[] lineWords = line.split("[\\s,]+");
            for (String word : lineWords) {            //Big O = O(n)
                words.add(word.trim());                //Big O = O(1)
            }
        }
        return words;
    }
}