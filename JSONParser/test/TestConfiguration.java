import java.nio.file.FileSystems;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestConfiguration {

	@Test
	public void testGoodConfiguration() {
		try {
			Configuration configuration = new Configuration(FileSystems.getDefault().getPath("test/configurations/good.json"));
			configuration.init();
			assertEquals("input/gutenberg", configuration.getInputPath());
			assertEquals(false, configuration.useDigitDelimiter());
		} catch(InitializationException ie) {
			fail(ie.getMessage());
		}
	}

	@Test
	public void testBadInputPathKey() {
		try {
			Configuration configuration = new Configuration(FileSystems.getDefault().getPath("test/configurations/badinputpathkey.json"));
			configuration.init();
			fail("No InitializationException thrown to indicate inputPath is not specified in configuration file.");
		} catch(InitializationException ie) {
			assertTrue(ie.getMessage().contains("inputPath not specified"));
			
		}
	}

	@Test
	public void testBadDigitDelimiterKey() {
		try {
			Configuration configuration = new Configuration(FileSystems.getDefault().getPath("test/configurations/baddigitdelimiterkey.json"));
			configuration.init();
			fail("No InitializationException thrown to indicate digitDelimiter is not specified in configuration file.");
		} catch(InitializationException ie) {
			assertTrue(ie.getMessage().contains("digitDelimiter not specified"));
			
		}
	}

	@Test
	public void testBadFileName() {
		try {
			Configuration configuration = new Configuration(FileSystems.getDefault().getPath("test/configurations/UNKNOWN.json"));
			configuration.init();
			fail("No InitializationException thrown to indicate inability to open file.");
		} catch(InitializationException ie) {
			assertTrue(ie.getMessage().contains("Unable to open file"));
			
		}
	}

	@Test
	public void testUnparseableJSON() {
		try {
			Configuration configuration = new Configuration(FileSystems.getDefault().getPath("test/configurations/bad.json"));
			configuration.init();
			fail("No InitializationException thrown to indicate unparseable JSON.");
		} catch(InitializationException ie) {
			assertTrue(ie.getMessage().contains("Unable to parse file"));
			
		}
	}
	
	@Test
	public void testBadDigitDelimiterValue() {
		try {
			Configuration configuration = new Configuration(FileSystems.getDefault().getPath("test/configurations/baddigitdelimitervalue.json"));
			configuration.init();
			fail("No InitializationException thrown to indicate digitDelimiter is not a boolean value.");
		} catch(InitializationException ie) {
			assertTrue(ie.getMessage().contains("digitDelimiter not a boolean"));			
		}
	}
	
}
