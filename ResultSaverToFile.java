package ie.atu.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves result to a file
 */
public class ResultSaverToFile {
	/**
	 * Saves result in a file using BufferWriter 
	 * 
	 * @param results    Result to be saved
	 * @param outputPath Path for file
	 * @throws IOException occurs if there is a writing error
	 */
    public void saveResultsToOutputFile(String results, String outputPath) { // Big O = O(n)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
