package core.basesyntax;

import core.basesyntax.fileservice.LocalFileReader;
import core.basesyntax.fileservice.LocalFileReaderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopTest {
    private static LocalFileReader FILE_READER = new LocalFileReaderImpl();
    private static final String INPUT_FIRST_FILE = "src/test/resources test1.csv";
    private static final String INPUT_SECOND_FILE = "src/test/resources test2.csv";
    private static final String INPUT_THIRD_FILE = "src/test/resources test3.csv";
    private static final String INPUT_NONEXISTENT_FILE = "src/test/resources test4.csv";
    private static final String REPORT_FIRST_FILE = "src/test/resources report_test1.csv";
    private static final String REPORT_SECOND_FILE = "src/test/resources report_test2.csv";
    private static final String REPORT_THIRD_FILE = "src/test/resources report_test3.csv";
    private FruitShop fruitShop;

    // Reads report and deletes it after reading
    public String readResult(String reportPath) {
        String[] path = reportPath.split(" ");
        List<List<String>> listOfLists = FILE_READER.readFile(path);
        String result = listOfLists.stream()
                .map(s -> String.join(",", s))
                .collect(Collectors.joining("\n"));
        try {
            Files.deleteIfExists(Paths.get(path[0] + FileSystems.getDefault().getSeparator() + path[1]));
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        return result;
    }

    @Before
    public void init() {
        fruitShop = new FruitShop();
    }

    @Test
    public void testFirstFile() {
        fruitShop.runFruitShop(INPUT_FIRST_FILE);
        String expected = "fruit, quantity\nbanana, 110";
        String actual = readResult(REPORT_FIRST_FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSecondFile() {
        fruitShop.runFruitShop(INPUT_SECOND_FILE);
        String expected = "fruit, quantity\nbanana, 130";
        String actual = readResult(REPORT_SECOND_FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testThirdFile() {
        try {
            fruitShop.runFruitShop(INPUT_THIRD_FILE);
            Assert.fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("No such operation d", e.getMessage());
        }
    }

    @Test
    public void testNonexistentFile() {
        try {
            fruitShop.runFruitShop(INPUT_NONEXISTENT_FILE);
            Assert.fail("RuntimeException was expected");
        } catch (RuntimeException e) {
            Assert.assertEquals("No such file", e.getMessage());
        }
    }
}
