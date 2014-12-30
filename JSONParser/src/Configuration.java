import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The Configuration class parses a JSON file containing configuration information and provides wrapper methods
 * to access the configuration data in the JSON object.
 * @author srollins
 *
 */
public class Configuration {

	/**
	 * Constants that store the keys used in the configuration file.
	 */
	public static final String INPUT_PATH = "inputPath";
	public static final String DIGIT_DELIMITER = "digitDelimiter";
	
	/**
	 * Declare any private data members that will be helpful.
	 */
	
	/**
	 * Instantiates a Configuration object.
	 * @param path - the location of the file 			
	 */
	public Configuration(Path path) {
		//TODO
	}
	
	/**
	 * Initializes a Configuration object. Uses a JSONParser to parse the contents of the file. Hint:
	 * I used a helper method to validate the contents of the file once it was parsed. Note: you will need
	 * to implement your own exception class called InitializationException.
	 * @throws InitializationException - thrown in the following cases: (1) an IOException is generated when 
	 * 				accessing the file; (2) a ParseException is thrown when parsing the JSON contents of the file;
	 * 				(3) the file does not contain the inputPath key; (4) the file does not contain the digitDelimiter 
	 * 				key; (5) the digitDelimiter value is not a boolean.
	 */
	public void init() throws InitializationException {		
		//TODO
	}
	

	/**
	 * Returns the value of associated with the inputPath key in the JSON configuration file.
	 * @return - value associated with key inputPath
	 */
	public String getInputPath() {
		//TODO
		return null;
	}
	

	/**
	 * Returns the value of associated with the digitDelimiter key in the JSON configuration file.
	 * @return - value associated with key digitDelimiter
	 */
	public boolean useDigitDelimiter() {
		//TODO
		return false;
	}
	
	/**
	 * Use the main method for testing as necessary.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		(new Configuration(FileSystems.getDefault().getPath("config.json"))).init();
	}
	
}
