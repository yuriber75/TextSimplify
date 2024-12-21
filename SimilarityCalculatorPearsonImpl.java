package ie.atu.sw;

/**
 * Implementation of the SimilarityCalculator interface for calculate 
 * correlation between two vectors using Pearson algorithm
 */
public class SimilarityCalculatorPearsonImpl implements SimilarityCalculator {

    /**
     * Calculates Pearson coefficient
     *
     * @param vectorA first word vector
     * @param vectorB second word vector
     * @return A value between -1(less similar) and 1(perfect match) 
     * @throws IllegalArgumentException if vector have different length
     * @throws ArithmeticException occurs if denominator is zero
     */
    @Override
    public double calculateSimilarity(double[] vectorA, double[] vectorB) {
    	// Big O = O(n) n. of words in cycle for
    	if (vectorA.length != vectorB.length) {
            throw new IllegalArgumentException("Ops .. Vector must have same lenght!");
        }

        int n = vectorA.length;

        double sumA = 0.0, sumB = 0.0, sumASquared = 0.0, sumBSquared = 0.0, sumProduct = 0.0;

        for (int i = 0; i < n; i++) {//Big O = O(n)
            sumA += vectorA[i];                        //Big O = O(1)
            sumB += vectorB[i];                        //Big O = O(1)
            sumASquared += vectorA[i] * vectorA[i];    //Big O = O(1)
            sumBSquared += vectorB[i] * vectorB[i];    //Big O = O(1)
            sumProduct += vectorA[i] * vectorB[i];     //Big O = O(1)
        }

        // Pearson Algorithm
        double numerator = sumProduct - ((sumA * sumB) / n);     //Big O = O(1)
        double denominator = Math.sqrt((sumASquared - (sumA * sumA) / n) * (sumBSquared - (sumB * sumB) / n));     //Big O = O(1)

        if (denominator == 0) {
            throw new ArithmeticException("Ops.. Denominator equal zero");
        }

        return numerator / denominator;
    }
}
