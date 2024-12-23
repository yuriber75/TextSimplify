package ie.atu.sw;

/**
 * Interface for calculating similarity between two vectors.
 * 
 */

public abstract interface SimilarityCalculator {
	
	/**
	 *  Defines similarity between two vectors
	 *
     * @param vectorA first word vector
     * @param vectorB second word vector
     * @return Distance between the vectors
	 */
	public double calculateSimilarity(double[] vectorA, double[] vectorB); //Big O = depend from specification

}
