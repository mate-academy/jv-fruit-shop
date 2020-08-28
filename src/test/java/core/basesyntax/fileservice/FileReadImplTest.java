package core.basesyntax.fileservice;

import org.junit.Assert;
import org.junit.Test;

public class FileReadImplTest {
    private static final FileRead FILE_READ = new FileReadImpl();
    private static final String[] NULL_PATH = null;
    private static final String[] INCORRECT_PATH = {"no/such/folder", "andNoSuchFile.csv"};
    private static final String[] CORRECT_PATH = {"src/test/resources", "test1.csv"};

    @Test
    public void nullPath() {
        try {
            FILE_READ.readFile(NULL_PATH);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Path is null", e.getMessage());
        }
    }

    @Test
    public void incorrectPath() {
        try {
            FILE_READ.readFile(INCORRECT_PATH);
            Assert.fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            Assert.assertEquals("No such file", e.getMessage());
        }
    }

    @Test
    public void correctInput() {
        Assert.assertEquals(4, FILE_READ.readFile(CORRECT_PATH).size());
    }
}
