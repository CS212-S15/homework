import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Test;


public class TestFileStats {

	@Test
	public void testDigitDelimiterTrue() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		fs = new FileStats(path, true);
		assertTrue((11 == fs.getWordCount()));			
	}

	@Test
	public void testDigitDelimiterFalse() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		fs = new FileStats(path, false);
		assertTrue((10 == fs.getWordCount()));			
	}

	@Test
	public void testBadPath() {
		Path path = FileSystems.getDefault().getPath("input/NOTAVAILABLE.txt");
		FileStats fs = null;
		fs = new FileStats(path, false);
		assertTrue((-1 == fs.getWordCount()));			
	}

	@Test
	public void testToString() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		fs = new FileStats(path, false);
		assertEquals("Correct toString return format.", "Count: 10", fs.toString());			
	}

	@Test
	public void testFileName() {
		Path path = FileSystems.getDefault().getPath("input/test1.txt");
		FileStats fs = null;
		fs = new FileStats(path, false);
		assertEquals("Correct fileName.", "input" + File.separator + "test1.txt", fs.getFileName());			
	}

}
