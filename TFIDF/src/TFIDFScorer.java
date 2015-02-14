import java.util.ArrayList;
import java.util.HashMap;


public class TFIDFScorer {
	
	/**
	 * Takes as input a query and an ArrayList of HashMaps where each HashMap represents a single document and 
	 * stores the words appearing in that document and the number of times the word appears. Calculates the TFIDF 
	 * score for the query in each document and returns the results in an ArrayList.
	 * 
	 * Example:
	 * doc1 - the cat ran
	 * doc2 - the dog and the cat jumped
	 * query - dog cat
	 * 
	 * In this case, the documents ArrayList would be of size two.
	 * The first element would be a HashMap that mapped [the -> 1, cat -> 1, ran -> 1]
	 * The second element would be a HashMap that mapped [the -> 2, dog -> 1, and -> 1, cat -> 1, jumped ->1]
	 * 
	 * The result would be an ArrayList of size two. The first value would be the TFIDF score of 'dog cat' 
	 * in doc1 and the second value would be the TFIDF score of 'dog cat' in doc2.
	 * 
	 * The TFIDF score of 'dog cat' in doc1 would be the TFIDF score of dog in doc1 plus the TFIDF score of cat in 
	 * doc1.
	 * 
	 * Use log base 10 in your solution.
	 * 
	 * @param query
	 * @param documents
	 * @return
	 */
	public static ArrayList<Double> computeScore(String query, ArrayList<HashMap<String, Integer>> documents) {
		
				
		//TF - number of times word occurs / total number of words in document
		//IDF - log(total docs / docs containing word)
		
		//TFIDF = TF*IDF
		
		return null;
	}
	
	
}
