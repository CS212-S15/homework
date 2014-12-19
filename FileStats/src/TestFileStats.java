import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Test;


public class TestFileStats {

	@Test
	public void testDigitDelimiterTrue() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		try {
			fs = new FileStats(path, true);
			assertTrue((11 == fs.getWordCount()));			
		} catch(IOException ioe) {
			fail("Error parsing file. " + ioe.getMessage());
		}
	}

	@Test
	public void testDigitDelimiterFalse() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		try {
			fs = new FileStats(path, false);
			assertTrue((10 == fs.getWordCount()));			
		} catch(IOException ioe) {
			fail("Error parsing file. " + ioe.getMessage());
		}
	}

	@Test
	public void testBadPath() {
		Path path = FileSystems.getDefault().getPath("input/NOTAVAILABLE.txt");
		FileStats fs = null;
		try {
			fs = new FileStats(path, false);
			fail("Expecting IOException with bad input path.");
		} catch(IOException ioe) {
			assertTrue(ioe instanceof IOException);
		}
	}

	@Test
	public void testToString() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		try {
			fs = new FileStats(path, false);
			assertEquals("Correct toString return format.", "Count: 10", fs.toString());			
		} catch(IOException ioe) {
			fail("Error parsing file. " + ioe.getMessage());
		}
	}
	
	@Test
	public void testFileName() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		try {
			fs = new FileStats(path, false);
			assertEquals("Correct fileName.", "input/test1.txt", fs.getFileName());			
		} catch(IOException ioe) {
			fail("Error parsing file. " + ioe.getMessage());
		}
	}
	
}
