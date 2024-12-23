package ie.atu.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Here is where the magic is happening!

/**
 * Processes paragraphs by replacing words not present in a list (example: Google-1000) 
 * with the most similar based on the Similarity Calculator chosen
 */
public class ParagraphProcessor  { //probably I can find a better name but since I analysing the whole sentence it's at least acceptable

    private final Set<String> wordsGoogle;
    private final Map<String, double[]> wordsEmbedding;
    private final SimilarityCalculator similarityCalculator;

    /**
     * Constructs a ParagraphProcessor.
     * 
     * @param wordsList a set of words to validate and use for replacement (example google-1000)
     * @param wordsVector is embeddings file (example wordEmbedding Map) 
     * 		  <ul>	
     *          <li>key: word</li>
     *          <li>value:vectors</li>
     *        </ul>
     * @param similarityCalculator an instance for calculate similarity between vectors
     */
    public ParagraphProcessor(Set<String> wordsList, Map<String, double[]> wordsVector, SimilarityCalculator similarityCalculator) {
        this.wordsGoogle = wordsList;
        this.wordsEmbedding = wordsVector;
        this.similarityCalculator = similarityCalculator;
    }

    /**
     * Processes the list of words:
     * 		  <ul>	
     *          <li>Check how many words needed to be checked</li>
     *          <li>If not found replace word</li>
     *          <li>If is not in the list then replace delegating to method findMostSimilarWord</li>
     *          <li>Displays the progressMeter Processor</li>
     *        </ul>
     * 
     * @param wordsListToCheck list of words from input (example inputText)
     * @return a processed list of words replaced 
     */
    public List<String> process(List<String> wordsListToCheck) {//Big O = O(n log n)
        int numberOfWords = wordsListToCheck.size();            //Big O = O(1) 
        for (int i = 0; i < numberOfWords; i++) {               //Big O = O(n) 
            String singleWordToCheck = wordsListToCheck.get(i); //Big O = O(1) 
                      
            // if the word is not in google find similarity
            // if the return is not null replace word in the list
            if (!wordsGoogle.contains(singleWordToCheck)) {      //Big O = O(n) 
                String mostSimilarWord = findMostSimilarWord(singleWordToCheck);//Big O = O(n log n)
                if (mostSimilarWord != null) {                  //Big O = O(1)  
                    wordsListToCheck.set(i, mostSimilarWord);   //Big O = O(1) 
                }
            }
            
            ProgressMeter.printProgress(i + 1, numberOfWords);  //Big O = O(1) 
            try {
                Thread.sleep(30);                               //Big O = O(1) 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        return wordsListToCheck;
    }

    /**
     * Finds the most similar word based on the similarity calculator chosen.
     * 
     * @param wordToCheck the word to find a replacement for
     * @return the most similar word or null if not found
     */
    private String findMostSimilarWord(String wordToCheck) {         //Big O = O(n log n)

        double[] vectorWordToCheck = wordsEmbedding.get(wordToCheck);//Big O = O(1)
        // retrieve the vector from embeddings File for the given word
        
        if (vectorWordToCheck == null) { 
        // if word is not found do not compare return null
            return null;                                             //Big O = O(1)
        }

        var similarityComparator = new SimilarityComparator(vectorWordToCheck, similarityCalculator, wordsEmbedding);//Big O = O(1)
        //instance the comparator 
        //vectorWordToCheck -> vector to be searched
        //similarityCalculator -> similarity calculator chosen
        //wordsEmbedding -> embeddings Map   
        
        List<String> googleWordsWithVector = new ArrayList<>(); 
        //creating a new list with vector
        
        for (String word : wordsGoogle) {                      //Big O = O(n) 
        //for every word in google-1000 if it is found in Embedding then add to googleWordsWithVector
            if (wordsEmbedding.get(word) != null) {            //Big O = O(1) | this was for avoiding issue when some word was not in embedding
                googleWordsWithVector.add(word);               //Big O = O(1)
            }
        }
      
        /*
         * Sorts a list of words by how similar they are to a target vector.
         * It uses the SimilarityComparator, which compares two words at a time.
         * The embeddings for each word are taken from the map, and the similarity
         * is calculated with the target vector.
         *
         * The `Collections.sort` method calls the `compare` method many times
         * (about O(n log n) comparisons) to find the correct order. The result is
         * a list ordered from most similar to least similar to the target vector.
         */
        Collections.sort(googleWordsWithVector, similarityComparator);  //Big O = O(n log n)
        //<String> void java.util.Collections.sort(List<String> list, Comparator<? super String> c)
        //Sorting method, most similar at the beginning of the list
        /*
         * Lambda expression as per notes
         * however even if SHORTER does not separe the concern 
         * 
         * Collections.sort(googleWordsWithVector, 
         *   (word1, word2) -> Double.compare(
         *   similarityCalculator.calculateSimilarity(targetVector, wordsEmbedding.get(word2)),
         *   similarityCalculator.calculateSimilarity(targetVector, wordsEmbedding.get(word1))
         *   )
         * );
         */
        

        return googleWordsWithVector.isEmpty() ? null : googleWordsWithVector.get(0);  //Big O = O(1)
        // return first word in the list if not null
    }    
}    
