package ie.atu.sw;

/**
 * Implementation of the SimilarityCalculator interface for calculate 
 * correlation between two vectors using Euclidean Distance
 */
public class SimilarityCalculatorEuclideanDistanceImpl implements SimilarityCalculator {

    /**
     * Calculates the Euclidean Distance between two vector 
     *
     * @param vectorA first word vector
     * @param vectorB second word vector
     * @return Euclidean distance (higher score indicates higher similarity)
     * @throws IllegalArgumentException occurs if vector have different length
     */
    @Override
    public double calculateSimilarity(double[] vectorA, double[] vectorB) { // Big O = O(n)
        if (vectorA.length != vectorB.length) { // Big O = O(1)
            throw new IllegalArgumentException("Ops .. Vector must have same lenght!");
        }

        double sumOfSquares = 0.0;                          // Big O = O(1)
        for (int i = 0; i < vectorA.length; i++) {          // Big O = O(n)
            double difference = vectorA[i] - vectorB[i];    // Big O = O(1)
            sumOfSquares += difference * difference;        // Big O = O(1)
        }
        double euclideanDistance = Math.sqrt(sumOfSquares); // Big O = O(1)

        return 1.0 / (1.0 + euclideanDistance);             // Big O = O(1)
    }
}
