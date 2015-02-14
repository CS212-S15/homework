import static org.junit.Assert.fail;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class TestTFIDF {

	ArrayList<HashMap<String, Integer>> documents;
	
	@Test
	public void testThreeWordQuery() {
		
		ArrayList<Double> expected = new ArrayList<>();
		expected.add(0.0587);
		expected.add(0.088);
		expected.add(0.0587);
		
		ArrayList<Double> result = TFIDFScorer.computeScore("usf computer science", documents);
		compareResults(expected, result);
		
	}

	
	@Test
	public void testTwoWordQueryNotFound() {
		
		ArrayList<Double> expected = new ArrayList<>();
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		
		ArrayList<Double> result = TFIDFScorer.computeScore("usf computing", documents);
		compareResults(expected, result);
		
	}
	

	@Test
	public void testOneWord() {
		
		ArrayList<Double> expected = new ArrayList<>();
		expected.add(0.0587);
		expected.add(0.044);
		expected.add(0.0);
		
		ArrayList<Double> result = TFIDFScorer.computeScore("computer", documents);
		compareResults(expected, result);
		
	}

	@Test
	public void testTwoWordQuery() {
		
		ArrayList<Double> expected = new ArrayList<>();
		expected.add(0.0587);
		expected.add(0.0880);
		expected.add(0.0587);
		
		ArrayList<Double> result = TFIDFScorer.computeScore("computer science", documents);
		compareResults(expected, result);
		
	}

	
	public void compareResults(ArrayList<Double> expected, ArrayList<Double> result) {
		if(result.size() != expected.size()) {
			fail("Number of TFIDF scores returned does not match one score per document.");
		}
		
		for(int i = 0; i < result.size(); i++) {
			
			double toCompare = result.get(i);
			DecimalFormat df = new DecimalFormat("#.####");      
			toCompare = Double.valueOf(df.format(toCompare));
			
			
			if(toCompare != expected.get(i)) {
				fail("Result incorrect for document at position " + i);
			}		 	
			
		}
	}
	
	public static HashMap<String, Integer> buildMap(String[] doc) {
		HashMap<String, Integer> docMap = new HashMap<>();		
		for(String word: doc) {
			if(docMap.containsKey(word)) {
				docMap.put(word, docMap.get(word)+1);
			} else {
				docMap.put(word, 1);
			}
		}
		return docMap;
		
	}
	
    @Before
    public void setUp() {
		documents = new ArrayList<>();		
		
		String[] doc1 = "my computer is faster than your computer".split("[^a-zA-Z0-9]+");
		documents.add(buildMap(doc1));
		
		String[] doc2 = "i love computer science".split("[^a-zA-Z0-9]+");		
		documents.add(buildMap(doc2));		
		
		String[] doc3 = "science is fun".split("[^a-zA-Z0-9]+");		
		documents.add(buildMap(doc3));
    
    }


}
