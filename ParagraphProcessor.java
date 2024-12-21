package ie.atu.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Processes paragraphs by replacing words not present in a list (example: Google-1000) 
 * with the most similar based on the Similarity Calculator chosen
 */
public class ParagraphProcessor  {

    private final Set<String> wordList;
    private final Map<String, double[]> wordVectors;
    private final SimilarityCalculator similarityCalculator;


    /**
     * Constructs a ParagraphProcessor.
     *
     * @param wordList a set of words to validate and use for replacement (example google-1000)
     * @param wordVectors is embeddings file (example wordEmbedding Map) 
     * 		  <ul>	
     *          <li>key: word</li>
     *          <li>value:vectors</li>
     *        </ul>
     * @param similarityCalculator an instance for calculate similarity between vectors
     */
    public ParagraphProcessor(Set<String> wordList, Map<String, double[]> wordVectors, SimilarityCalculator similarityCalculator) {
        this.wordList = wordList;
        this.wordVectors = wordVectors;
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
     * @param textWords list of words from input (example inputText)
     * @return a processed list of words replaced 
     */
    public List<String> process(List<String> textWords) {//Big O = O(n log n)
        int totalSteps = textWords.size();               //Big O = O(1) 
        for (int i = 0; i < textWords.size(); i++) {     //Big O = O(n) 
            String word = textWords.get(i);              //Big O = O(1) 
                      
            // if the word is not in google find similarity
            // if the return is not null replace word in the list
            if (!wordList.contains(word)) {              //Big O = O(n) 
                String mostSimilarWord = findMostSimilarWord(word);    //Big O = O(n log n)
                if (mostSimilarWord != null) {           //Big O = O(1)  
                    textWords.set(i, mostSimilarWord);   //Big O = O(1) 
                }
            }
            
            ProgressMeter.printProgress(i + 1, totalSteps);  //Big O = O(1) 
            try {
                Thread.sleep(30);                            //Big O = O(1) 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        return textWords;
    }

    /**
     * Finds the most similar word based on the similarity calculator chosen.
     * 
     * @param targetWord the word to find a replacement for
     * @return the most similar word or null if not found
     */
    private String findMostSimilarWord(String targetWord) {  //Big O = O(n log n)

        double[] targetVector = wordVectors.get(targetWord); //Big O = O(1)
        // retrieve the vector from embeddings File for the given word
        
        if (targetVector == null) { 
        // if word is not found do not compare return null
            return null;                                    //Big O = O(1)
        }

        var similarityComparator = new SimilarityComparator(targetVector, similarityCalculator, wordVectors);//Big O = O(1)
        //instance the comparator 
        //targetVector -> vector to be searched
        //similarityCalculator -> similarity calculator chosen
        //wordVector -> embeddings Map   
        
        List<String> googleWordsWithVector = new ArrayList<>(); 
        //creating a new list with vector
        
        for (String word : wordList) {                      //Big O = O(n) 
        //for every word in wordList if it is found then add to googleWordsWithVector
            if (wordVectors.get(word) != null) {            //Big O = O(1) | this was for avoiding issue when some word was not in embedding
                googleWordsWithVector.add(word);            //Big O = O(1)
            }
        }

        Collections.sort(googleWordsWithVector, similarityComparator);  //Big O = O(n log n)
        //<String> void java.util.Collections.sort(List<String> list, Comparator<? super String> c)
        //Sorting method, most similar at the beginning of the list

        return googleWordsWithVector.isEmpty() ? null : googleWordsWithVector.get(0);  //Big O = O(1)
        // return first word in the list if not null
    }    
}    
