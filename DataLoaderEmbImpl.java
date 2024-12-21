package ie.atu.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * Implementation of DataLoader for loading embeddings file
 * 
 * Reads a file containing word embeddings, example:
 * <ul>
 *    <li>frowning, -0.3082, -0.2343, .... 0.0965</li>
 *    <li>undermining, -0.1960, -0.5925, ..... -0.0366</li>
 * </ul>
 *  
 * Uses a virtual threads for storing data in a thread-safe map 
 */
public class DataLoaderEmbImpl extends DataLoaderBuffer<Map<String, double[]>> {

	private static final int VECTOR_DIM = 50;

    /**
     * Loads word embeddings from the specified file
     * 
     * Reads each line of the file, splits it into a word and its vector representation, 
     * and stores the result in a thread-safe map.
     * 
     * @param filePath The location of the file to load
     * @return a map where each key is a word and the values are vectors
     * @throws Exception if an error occurs while processing the file
     */	
	@Override
	public Map<String, double[]> load(String filePath) {               //Big O = O(n)
		// is not quadratic because is not grow based on the number of line in quadratic
		// however there is a loop inside and O(n * VECTOR_DIM) 
		
		Map<String, double[]> wordVectors = new ConcurrentHashMap<>(); //Big O = O(1)

		try (var pool = Executors.newVirtualThreadPerTaskExecutor()) { //Big O = O(1)

			for (String line : readFileLines(filePath)) {              //Big O = O(n)
				pool.execute(() -> {	                               //Big O = O(1)

					String[] parts = line.split(", ");                 //Big O = O(1)

					String word = parts[0];                            //Big O = O(1)
					double[] vector = new double[VECTOR_DIM];          //Big O = O(1)


					for (int i = 0; i < VECTOR_DIM; i++) {             //Big O = O(n) n=VECTOR_DIM
						vector[i] = Double.parseDouble(parts[i + 1]);  //Big O = O(1)
					}

					wordVectors.put(word, vector);                     //Big O = O(1)
				});
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}

		return wordVectors; 
	}
}
