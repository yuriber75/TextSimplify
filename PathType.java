package ie.atu.sw;

/**
 * Represents different types of file paths used 
 *
 * <ul>
 *   <li> EMBEDDING - embeddings file, which contains word vectors</li>
 *   <li> GOOGLE - Google words list file</li>
 *   <li> OUTPUT - path to output file processed</li>
 *   <li> TEXT - input text file for processing</li>
 * </ul>
 *
 * This enum is used in conjunction with FilePathUtils
 */
public enum PathType {
    EMBEDDING, GOOGLE, OUTPUT, TEXT
}