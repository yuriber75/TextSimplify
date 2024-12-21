package ie.atu.sw;

/**
 * Implementation of the SimilarityCalculator interface for calculate 
 * correlation between two vectors using Cosine Distance
 */
public class SimilarityCalculatorCosineImpl implements SimilarityCalculator {

    /**
     * Calculates the Cosine Distance between two vector 
     *
     * @param vectorA first word vector
     * @param vectorB second word vector
     * @return Cosine distance ( between 1 (identical and -1 weaker similarity)
     */
    @Override
    public double calculateSimilarity(double[] vectorA, double[] vectorB) { // Big O = O(n)
        double dotProduct = 0.0; // Big O = O(1)
        double squaredA = 0.0;   // Big O = O(1)
        double squaredB = 0.0;   // Big O = O(1)
        
        for (int i = 0; i < vectorA.length; i++) { // Big O = O(n)
            dotProduct += vectorA[i] * vectorB[i]; // Big O = O(1)
            squaredA += vectorA[i] * vectorA[i];   // Big O = O(1)
            squaredB += vectorB[i] * vectorB[i];   // Big O = O(1)
        }

        return dotProduct / (Math.sqrt(squaredA) * Math.sqrt(squaredB)); // Big O = O(1)
    }
}