package ie.atu.sw;

/**
 * Implementation of the SimilarityCalculator interface for calculate 
 * correlation between two vectors using Manhattan algorithm
 */
public class SimilarityCalculatorManhattanImpl implements SimilarityCalculator {

    /**
     * Calculates the Manhattan distance between two vector 
     *
     * @param vectorA first word vector
     * @param vectorB second word vector
     * @return Manhattan distance
     * @throws IllegalArgumentException occurs if vector have different length
     */
    @Override
    public double calculateSimilarity(double[] vectorA, double[] vectorB) {
    	// Big O = O(n) n. of words in cycle for
        if (vectorA.length != vectorB.length) {
            throw new IllegalArgumentException("Ops .. Vector must have same lenght!");
        }

        double manhattanDistance = 0.0;

        for (int i = 0; i < vectorA.length; i++) {                   // Big O = O(n) 
            manhattanDistance += Math.abs(vectorA[i] - vectorB[i]);  // Big O = O(1) 
        }

        return 1.0 / (1.0 + manhattanDistance);   //inverted because this calculation has best score negative value
    }
}