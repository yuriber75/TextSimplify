package ie.atu.sw;

import java.util.*;

/**
 * Compares two words with a  target vector.
 * It can be used for sorting words.
 * Implements Comparator 
 */
public class SimilarityComparator implements Comparator<String> {

    private final double[] targetVector;
    private final SimilarityCalculator similarityCalculator;
    private final Map<String, double[]> wordVectors; // 

    /**
     * Constructs:
     * 
     * @param targetVector           target vector to be compared
     * @param similarityCalculator   Similarity Calculator chosen between options
     * @param wordVectors            Embedding Maps (key is "String", value is "Vectors")
     */
    public SimilarityComparator(double[] targetVector, SimilarityCalculator similarityCalculator, Map<String, double[]> wordVectors) {
        this.targetVector = targetVector;
        this.similarityCalculator = similarityCalculator;
        this.wordVectors = wordVectors;
    }

    /**
     * Compares two words based on their similarity to the target vector.
     * If sorted in ascending order words with great similarity appear first
     * 
     * @param word1 first word vector
     * @param word2 second word vector
     * @return Negative integer less similar, Positive more similar, zero same similarity 
     */  
    @Override
    public int compare(String word1, String word2) { //Big O = O(1)
        double[] vector1 = wordVectors.get(word1);   //Big O = O(1)
        double[] vector2 = wordVectors.get(word2);   //Big O = O(1)

        // if vector are missing then consider them equals
        if (vector1 == null || vector2 == null) {    //Big O = O(1)
            return 0; 
        }

        double similarity1 = similarityCalculator.calculateSimilarity(targetVector, vector1); //Big O = O(1)
        double similarity2 = similarityCalculator.calculateSimilarity(targetVector, vector2); //Big O = O(1)

        return Double.compare(similarity2, similarity1); //Big O = O(1)
    }
}