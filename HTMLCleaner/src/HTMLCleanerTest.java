import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A helper class with several static methods that will help 
 * strip out all of the HTML. Meant to be used for the web 
 * crawler project.
 *
 * @see HTMLCleaner
 * @see HTMLCleanerTest
 */
@RunWith(Suite.class)
@SuiteClasses({
    HTMLCleanerTest.TestEntities.class,
    HTMLCleanerTest.TestTags.class,
    HTMLCleanerTest.TestElements.class,
    HTMLCleanerTest.TestClean.class})
public class HTMLCleanerTest {

    public static class TestEntities {
        /**
         * Tests "2010&ndash;2011". (View Javadoc to see rendering.)
         */
        @Test
        public void testNamed() {
            String test = "2010&ndash;2011";
            String expected = "2010 2011";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "2010&#8211;2011". (View Javadoc to see rendering.)
         */
        @Test
        public void testNumbered() {
            String test = "2010&#8211;2011";
            String expected = "2010 2011";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "2010&#x2013;2011". (View Javadoc to see rendering.)
         */
        @Test
        public void testHexadecimal() {
            String test = "2010&#x2013;2011";
            String expected = "2010 2011";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "touche&#769;!". (View Javadoc to see rendering.)
         */
        @Test
        public void testAccent1() {
            String test = "touche&#769;!";
            String expected = "touche !";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "touch&eacute;!". (View Javadoc to see rendering.)
         */
        @Test
        public void testAccent2() {
            String test = "touch&eacute;!";
            String expected = "touch !";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "hello&mdash;good&dash;bye". (View Javadoc to see rendering.)
         */
        @Test
        public void testMultiple() {
            String test = "hello&mdash;good&dash;bye";
            String expected = "hello good bye";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "hello & good-bye".
         */
        @Test
        public void testAmpersand() {
            String test = "hello & good-bye";
            String expected = "hello & good-bye";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * Tests "hello & good-bye;".
         */
        @Test
        public void testAndSemicolon() {
            String test = "hello & good-bye;";
            String expected = "hello & good-bye;";
            String actual = HTMLCleaner.stripEntities(test);

            Assert.assertEquals(expected, actual);
        }
    }

    public static class TestTags {

        /**
         * View Javadoc to see HTML rendering of test case:
         *
         * <pre>
         * <b>hello</b> world!
         * </pre>
         */
        @Test
        public void testSimple() {
            String test = "<b>hello</b> world!";
            String expected = "hello world!";
            String actual = HTMLCleaner.stripTags(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * View Javadoc to see HTML rendering of test case:
         *
         * <pre>
         * <b>hello
         * </b> world!
         * </pre>
         */
        @Test
        public void testSimpleNewLine() {
            String test = "<b>hello\n</b> world!";
            String expected = "hello\n world!";
            String actual = HTMLCleaner.stripTags(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * View Javadoc to see HTML rendering of test case:
         *
         * <pre>
         * <a
         *  name=toc>table of contents</a>
         * </pre>
         */
        @Test
        public void testAttributeNewline() {
            String test = "<a \n name=toc>table of contents</a>";
            String expected = "table of contents";
            String actual = HTMLCleaner.stripTags(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * View Javadoc to see HTML rendering of test case:
         *
         * <pre>
         * <p>Hello, <strong>world</strong>!</p>
         * </pre>
         */
        @Test
        public void testNestedTags() {
            String test = "<p>Hello, <strong>world</strong>!</p>";
            String expected = "Hello, world!";
            String actual = HTMLCleaner.stripTags(test);

            Assert.assertEquals(expected, actual);
        }

        /**
         * View Javadoc to see HTML rendering of test case:
         *
         * <pre>
         * <p>Hello, <br/>world!</p>
         * </pre>
         */
        @Test
        public void testLineBreak() {
            String test = "<p>Hello, <br/>world!</p>";
            String expected = "Hello, world!";
            String actual = HTMLCleaner.stripTags(test);

            Assert.assertEquals(expected, actual);
        }
    }

    public static class TestElements {
        @Test
        public void testStyle() {
            String test = "<style type=\"text/css\">body { font-size: 10pt; }</style>";
            String expected = "";
            String actual = HTMLCleaner.stripElement("style", test);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testStyleNewline1() {
            String test = "<style type=\"text/css\">\nbody { font-size: 10pt; }\n</style>";
            String expected = "";
            String actual = HTMLCleaner.stripElement("style", test);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testStyleNewline2() {
            String test = "<style \n type=\"text/css\">\nbody { font-size: 10pt; }\n</style>";
            String expected = "";
            String actual = HTMLCleaner.stripElement("style", test);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testMultiple() {
            String test = "a<test>b</test>c<test>d</test>e";
            String expected = "ace";
            String actual = HTMLCleaner.stripElement("test", test);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testMixed() {
            String test =
                    "<title>Hello</title><script>potato</script> world";
            String expected = "<title>Hello</title> world";
            String actual = HTMLCleaner.stripElement("script", test);

            Assert.assertEquals(expected, actual);
        }
    }

    public static class TestClean {

        @Test
        public void testNoHTML() {
            String test = "hello & good-bye;";
            String expected = "hello & good-bye;";

            String actual = HTMLCleaner.cleanHTML(test);
            Assert.assertEquals(expected, actual.trim());
        }

        @Test
        public void testOneLine() {
            String test = "<b>hello</p>&amp;<script>potato</script>world";
            String expected = "hello world";

            String actual = HTMLCleaner.cleanHTML(test);
            Assert.assertEquals(expected, actual.trim());
        }

        @Test
        public void testSimplePage() {
            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html>\n");
            html.append("<html>\n");
            html.append("<head>\n");
            html.append("    <meta charset=\"utf-8\">\n");
            html.append("    <script type=\"text/javascript\" src=\"d3.v3.js\"></script>\n");
            html.append("    <style type=\"text/css\">\n");
            html.append("    body {\n");
            html.append("        font-size: 10pt;\n");
            html.append("        font-family: sans-serif;\n");
            html.append("    }\n");
            html.append("    </style>\n");
            html.append("</head>\n");
            html.append("<body>\n");
            html.append("Hello, world! &copy;2013\n");
            html.append("</body>\n");
            html.append("</html>\n");

            String expected = "Hello, world!  2013";
            String actual = HTMLCleaner.cleanHTML(html.toString());

            // note the trim to remove the blank lines
            Assert.assertEquals(expected, actual.trim());
        }
    }
}
