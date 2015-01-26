import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * A class to read in a file and count the number of words in the file.
 * @author srollins
 *
 */
public class FileStats {
	
	/**
	 * Maintain a private variable that contains the number of words in the file.
	 */
	
	/**
	 * Maintain a private variable that contains the name of the file.
	 */
		
	/**
	 * Construct a FileStats object by using a Scanner to read in a file a token at a time
	 * maintaining a count of the number of tokens found.
	 * If digits are to be used as a delimiter then the pattern to use as a delimiter for the Scanner
	 * should include anything that is not an upper or lower case letter. If it is false
	 * then the pattern should include anything not a letter (upper/lower) or digit (0-9).
	 * @param fileName - Path to the file.
	 * @param digitDelimiter - true if digits should be used as a delimiter and false otherwise.
	 */
	public FileStats(Path fileName, boolean digitDelimiter) {
		//TODO: Complete method.
	}
	
	/**
	 * Returns the number of tokens found in the file.
	 * Return -1 if any exception is encountered processing the file.
	 * @return
	 */
	public int getWordCount() {
		//TODO: Complete method.
		return -1;
	}
	
	/**
	 * Returns the name of the file represented by this object.
	 * @return
	 */
	public String getFileName() {
		//TODO: Complete method.
		return null;
	}
	
	
	/**
	 * Returns a String representation of the form "Count: NUM" where NUM is the 
	 * number of words. Example: Count: 10
	 */
	public String toString() {
		//TODO: Complete method.
		return null;
	}
	
	
	/**
	 * Simple test for convenience.
	 * Feel free to modify.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		fs = new FileStats(path, true);
		System.out.println(fs.getWordCount());

	}
	
}
